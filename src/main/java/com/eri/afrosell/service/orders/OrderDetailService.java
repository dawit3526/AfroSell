package com.eri.afrosell.service.orders;

import com.eri.afrosell.database.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
     public List<OrderDetail> getListOrderDetail(Long orderId);

}
