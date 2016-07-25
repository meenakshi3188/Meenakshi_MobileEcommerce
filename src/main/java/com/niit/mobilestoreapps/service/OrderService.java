package com.niit.mobilestoreapps.service;

import java.util.List;

import com.niit.mobilestoreapps.model.CartInfo;
import com.niit.mobilestoreapps.model.OrderDetailInfo;
import com.niit.mobilestoreapps.model.OrderInfo;

public interface  OrderService {
	public void saveOrder(CartInfo cartInfo);
	 
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}
