package com.niit.mobilestoreapps.dao;

import java.util.List;

import com.niit.mobilestoreapps.model.CartInfo;
import com.niit.mobilestoreapps.model.OrderDetailInfo;
import com.niit.mobilestoreapps.model.OrderInfo;

public interface OrderDAO {
	public void saveOrder(CartInfo cartInfo);
	 
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}
