package com.eri.afrosell.service.orders;

import com.eri.afrosell.database.model.OrderDetail;
import com.eri.afrosell.model.orders.Orders;
import com.eri.afrosell.model.orders.OrdersRequestModel;
import com.eri.afrosell.repositories.Orders.OrdersDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrdersDetailsRepository orderDetailRepository;


    @Override
    public List<OrderDetail> getListOrderDetail(Long orderId) {

        return orderDetailRepository.findAllByOrderId(orderId);
    }

}
