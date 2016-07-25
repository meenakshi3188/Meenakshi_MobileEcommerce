package com.niit.mobilestoreapps.dao;


import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.CartInfo;
import com.niit.mobilestoreapps.model.CartLineInfo;
import com.niit.mobilestoreapps.model.CustomerInfo;
import com.niit.mobilestoreapps.model.Order;
import com.niit.mobilestoreapps.model.OrderDetail;
import com.niit.mobilestoreapps.model.OrderDetailInfo;
import com.niit.mobilestoreapps.model.OrderInfo;
import com.niit.mobilestoreapps.model.Product;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Autowired
    private SessionFactory sessionFactory;
 
    @Autowired
    private ProductDAO productDAO;
    
    
    private int getMaxOrderNum() {
      	String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
          Session session = sessionFactory.getCurrentSession();
          Query query = session.createQuery(sql);
          Integer value = (Integer) query.uniqueResult();
          if (value == null) {
              return 0;
          }
          return value;    	
      }
    
    
    
	@Override
	public void saveOrder(CartInfo cartInfo) {
		int orderNum = this.getMaxOrderNum() + 1;
        System.out.println(orderNum);
    	
        Order order = new Order();
 
        order.setId(UUID.randomUUID().toString());
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date());
        order.setAmount(cartInfo.getAmountTotal());
 
        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        order.setCustomerName(customerInfo.getName());
        order.setCustomerEmail(customerInfo.getEmail());
        order.setCustomerPhone(customerInfo.getPhone());
        order.setCustomerAddress(customerInfo.getAddress());
 
        sessionFactory.getCurrentSession().save(order);
 
        List<CartLineInfo> lines = cartInfo.getCartLines();
 
        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setId(UUID.randomUUID().toString());
            detail.setOrder(order);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getProductInfo().getPrice());
            detail.setQuanity(line.getQuantity());
 
            int code = line.getProductInfo().getCode();
            Product product = this.productDAO.getNameById(code);
            detail.setProduct(product);
 
            sessionFactory.getCurrentSession().save(detail);
        }
 
        cartInfo.setOrderNum(orderNum);
		
	}
	 public Order findOrder(String orderId) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Order.class);
	        crit.add(Restrictions.eq("id", orderId));
	        return (Order) crit.uniqueResult();
	    }
	@Override
	public OrderInfo getOrderInfo(String orderId) {
		 Order order = this.findOrder(orderId);
	        if (order == null) {
	            return null;
	        }
	        OrderInfo info = new OrderInfo(order.getId(), (java.sql.Date) order.getOrderDate(), order.getOrderNum(), order.getAmount(), order.getCustomerName(), //
	        		order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
			return info;
	}

	@Override
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		String sql = "Select new " + OrderDetailInfo.class.getName() //
                + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
                + " from " + OrderDetail.class.getName() + " d "//
                + " where d.order.id = " + orderId;
        
        @SuppressWarnings("unchecked")
		List<OrderDetailInfo> temp = sessionFactory.getCurrentSession().createQuery(sql).list();
        
        return temp;
	}
	

}
