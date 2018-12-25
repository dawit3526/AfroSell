package com.eri.afrosell.repositories.Orders;

import com.eri.afrosell.database.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrdersDetailsRepository extends PagingAndSortingRepository<OrderDetail, String>, JpaSpecificationExecutor <OrderDetail> {

   List<OrderDetail> findAllByOrderId(Long orderId);

}
