package com.eri.afrosell.service.orders;

import com.eri.afrosell.model.orders.Orders;
import com.eri.afrosell.model.orders.OrdersRequestModel;
import com.eri.afrosell.repositories.Orders.OrdersRepository;
import com.eri.afrosell.repositories.specifications.OrdersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


public interface OrdersService {

    public Page<Orders> doPagingOrders(OrdersRequestModel ordersRequestModel, Long companyId);

    public Orders getOrderByOrderIdAndCompanyID(Long orderId, Long companyId);

    public void updateStatusOrder(Orders order);


}
