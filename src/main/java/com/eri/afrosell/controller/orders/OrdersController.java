package com.eri.afrosell.controller.orders;

import com.eri.afrosell.controller.APINames;
import com.eri.afrosell.database.model.OrderDetail;
import com.eri.afrosell.exceptions.ApplicationException;
import com.eri.afrosell.model.Product;
import com.eri.afrosell.model.orders.Orders;
import com.eri.afrosell.model.orders.OrdersRequestModel;
import com.eri.afrosell.response.APIResponse;
import com.eri.afrosell.response.util.APIStatus;
import com.eri.afrosell.response.util.ResponseUtil;
import com.eri.afrosell.service.orders.OrderDetailService;
import com.eri.afrosell.service.orders.OrdersService;
import com.eri.util.Constant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping (value = APINames.ORDERS)
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrderDetailService orderDetailService;

   // @Autowired
   // ProductService productService;

    @Autowired
    protected ResponseUtil responseUtil;

    @RequestMapping (path = APINames.ORDERS_BY_COMPANY, method = RequestMethod.POST)
    @ApiOperation(value="get orders by company id", notes="")
    public ResponseEntity<APIResponse> getPagingOrders(@PathVariable ("company_id") Long companyId,
                                                       @RequestBody OrdersRequestModel ordersRequestModel){
        /*OrdersRequestModel ordersRequestModel = new OrdersRequestModel();
        ordersRequestModel.setAscSort(true);
        ordersRequestModel.setPageNumber(1);
        ordersRequestModel.setPageSize(1);
        ordersRequestModel.setStatus(0);*/

        try{
            Page<Orders> listOrders = ordersService.doPagingOrders(ordersRequestModel, companyId);
            return responseUtil.successResponse(listOrders);
        } catch (Exception ex) {
            throw new ApplicationException(APIStatus.ERR_GET_LIST_ORDERS);
        }

    }

/*    @RequestMapping (path = APINames.ORDER_DETAILS, method = RequestMethod.GET)
    @ApiOperation(value="get orders by company id and order id", notes="")
    public ResponseEntity<APIResponse> getDetailOrders(@PathVariable ("company_id") Long companyId,
                                                       @PathVariable ("order_id") Long orderId){

       Map<String, Object> resultOrders = new HashMap<String, Object>();

       try {
           Orders order =ordersService.getOrderByOrderIdAndCompanyID(orderId, companyId);

           if (order !=null){
               resultOrders.put("orders", order);
           }


           List<OrderDetail> orderDetail = orderDetailService.getListOrderDetail(orderId);

           List<Map<String, Object>> listOrdersDetail = new ArrayList<Map<String, Object>>();

           if (orderDetail != null && !orderDetail.isEmpty()){
               for (OrderDetail orderDetail_e : orderDetail){
                   Map<String, Object> detail = new HashMap<String, Object>();

                 *//*  Product product = productService.getProductById(companyId, orderDetail_e.getProductId());
                   Payment payment = paymentRepository.findByPaymentId(order.getPaymentId());
                   if (product != null && payment != null) {
                       detail.put("product", product);
                       detail.put("payment", payment);
                       detail.put("ordersDetail", orderDetail);
                       listOrdersDetail.add(detail);*//*
                   }
               }
           }

           return responseUtil.successResponse(orderDetail);

        }
        catch (Exception ex) {
            throw new ApplicationException(APIStatus.ERR_GET_DETAIL_ORDERS);
        }

    }*/



    @RequestMapping (path = APINames.CHANGE_STATUS_ORDERS_BY_COMPANY, method = RequestMethod.GET)
    public ResponseEntity<APIResponse> changeOrders( @PathVariable ("company_id") Long companyId,
                                                     @PathVariable ("order_id") Long orderId,
                                                     @PathVariable ("status") Integer status) {

        try {
            if (companyId != null) {
                if (orderId != null) {
                    Orders order_to_be_Updated = ordersService.getOrderByOrderIdAndCompanyID(orderId, companyId);

                    if (order_to_be_Updated != null) {

                        switch (status) {
                            case 0:
                                order_to_be_Updated.setStatus(Constant.ORDER_STATUS.PENDING.getStatus());
                                break;
                            case 1:
                                order_to_be_Updated.setStatus(Constant.ORDER_STATUS.SHIPPING.getStatus());
                                break;
                            case 2:
                                order_to_be_Updated.setStatus(Constant.ORDER_STATUS.COMPLETED.getStatus());
                                break;
                            default:
                                order_to_be_Updated.setStatus(Constant.ORDER_STATUS.PENDING.getStatus());
                                break;
                        }
                        ordersService.updateStatusOrder(order_to_be_Updated);

                    } else {
                        throw new ApplicationException(APIStatus.ERR_ORDER_ID_NOT_FOUND);

                    }
                    return responseUtil.successResponse("Change status order successfully");

                } else {
                    throw new ApplicationException(APIStatus.ERR_ORDER_ID_EMPTY);
                }


            } else {
                throw new ApplicationException(APIStatus.ERR_COMPANY_ID_EMPTY);

            }

        }
        catch (Exception e) {
            throw new ApplicationException(APIStatus.ERR_DELETE_ORDER);
        }

        }


}
