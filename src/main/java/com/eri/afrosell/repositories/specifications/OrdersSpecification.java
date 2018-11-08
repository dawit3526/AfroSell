package com.eri.afrosell.repositories.specifications;

import com.eri.afrosell.model.orders.Orders;
import com.eri.afrosell.util.Constant;
import org.hibernate.jpa.criteria.CriteriaBuilderImpl;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;



public class OrdersSpecification implements Specification<Orders> {

    private final Long companyId;
    private final String searchKey;
    private final int sortCase;
    private final boolean ascSort;
    private final int status;

    public OrdersSpecification(Long companyId, String searchKey, int sortCase, boolean ascSort, int status) {
        this.companyId = companyId;
        this.searchKey = searchKey;
        this.sortCase = sortCase;
        this.ascSort = ascSort;
        this.status = status;
    }

    @Override
    public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new LinkedList<>();

//         filter by status
        if (status >= 0) {
            predicates.add(cb.equal(root.get("status"), status));
        }
        // filter by search key
        if (searchKey != null && !searchKey.trim().isEmpty()) {
            String wrapSearch = "%" + searchKey.trim() + "%";
            Predicate customerFirstname = cb.like(root.<String>get("customerFirstname"), wrapSearch);
            Predicate customerMiddlename = cb.like(root.<String>get("customerMiddlename"), wrapSearch);
            Predicate customerLastname = cb.like(root.<String>get("customerLastname"), wrapSearch);
            Predicate search = cb.or(customerFirstname, customerMiddlename, customerLastname);
            predicates.add(search);
        }
        // sort
        Path orderClause;
        switch (sortCase) {
            case Constant.SORT_BY_ITEMS_QUANTITY:
                orderClause = root.get("itemsQuantity");
                break;
            case Constant.SORT_BY_GRAND_TOTAL:
                orderClause = root.get("grandTotal");
                break;
            default: // sort by created order
                orderClause = root.get("createdAt");
        }

        if (ascSort) {
            query.orderBy(cb.asc(orderClause));
        } else {
            query.orderBy(cb.desc(orderClause));
        }
        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}