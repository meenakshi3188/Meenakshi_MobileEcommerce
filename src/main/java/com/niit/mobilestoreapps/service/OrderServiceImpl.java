package com.niit.mobilestoreapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.OrderDAO;
import com.niit.mobilestoreapps.model.CartInfo;
import com.niit.mobilestoreapps.model.OrderDetailInfo;
import com.niit.mobilestoreapps.model.OrderInfo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired  
	OrderDAO orderDAO; 
	
	@Transactional
	public void saveOrder(CartInfo cartInfo) {
		orderDAO.saveOrder(cartInfo);
		
	}

	@Transactional
	public OrderInfo getOrderInfo(String orderId) {
		return orderDAO.getOrderInfo(orderId);
				
	}

	@Transactional
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		List<OrderDetailInfo> lsts = orderDAO.listOrderDetailInfos(orderId);
		return lsts;
	}

}
