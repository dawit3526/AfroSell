package com.eri.afrosell.service.orders;

import com.eri.afrosell.model.orders.Orders;
import com.eri.afrosell.model.orders.OrdersRequestModel;
import com.eri.afrosell.repositories.Orders.OrdersRepository;
import com.eri.afrosell.repositories.specifications.OrdersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public Page<Orders> doPagingOrders(OrdersRequestModel ordersRequestModel, Long companyId){
        Page<Orders> listOrders = ordersRepository.findAll(new OrdersSpecification(companyId, ordersRequestModel.getSearchKey(), ordersRequestModel.getSortCase(), ordersRequestModel.isAscSort(), ordersRequestModel.getStatus()), new PageRequest(ordersRequestModel.getPageNumber(), ordersRequestModel.getPageSize()));
        return listOrders;

    }

    @Override
    public Orders getOrderByOrderIdAndCompanyID(Long orderId, Long companyId) {
        return ordersRepository.findOneByIdAndCompanyId(orderId, companyId);
    }

    @Override
    public void updateStatusOrder(Orders order) {
        ordersRepository.save(order);

    }
}
