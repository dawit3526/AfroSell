package com.eri.afrosell.service.product;
import com.eri.afrosell.model.CreateProductModel;
import com.eri.afrosell.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

interface ProductService {

    Page<Product> getByCompanyId(long companyId, int pageNumber, int pageSize);
    Product getProductById(long companyId, long productId);
    Iterable<Product> getProductsById(long companyId, List<Long> productIds);
    //Page<Product> getByCompanyIdAndCategoryId(Long companyId, Long categoryId, int pageNumber, int pageSize);
    Page<Product> doFilterSearchSortPagingProduct(long comId, long catId, long attrId, String searchKey, double mnPrice, double mxPrice, int minRank, int maxRank, int sortKey, boolean isAscSort, int pSize, int pNumber);
    Product save(CreateProductModel productRequest, Product product);
    Product update(Product product);
    }
