package com.niit.mobilestoreapps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Orders", uniqueConstraints = { @UniqueConstraint(columnNames = "Order_Num") })
public class Order implements Serializable{
private static final long serialVersionUID = -2576670215015463100L;
    
    private String id;
    private Date orderDate;
    private int orderNum;
    private double amount;
 
    @Length(max=50)
    @NotEmpty(message="Customer name should not be null")
    private String customerName;
    
    @Length(max=100)
    @NotEmpty(message="Customer Address should not be null")
    private String customerAddress;
    
    @Length(max=50)
	@NotEmpty(message="Email should not be null")
	@Email
    private String customerEmail;
    
    @Length(max=20)
    @NotEmpty(message="Customer phone should not be null")
    private String customerPhone;
 
    @Id
    @Column(name = "ID", length = 50)
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
  
    @Column(name = "Order_Date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }
 
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
 
    @Column(name = "Order_Num", nullable = false)
    public int getOrderNum() {
        return orderNum;
    }
 
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
 
    @Column(name = "Amount", nullable = false)
    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }
 
    @Column(name = "Customer_Name", length = 255, nullable = false)
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    @Column(name = "Customer_Address", length = 255, nullable = false)
    public String getCustomerAddress() {
        return customerAddress;
    }
 
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
 
    @Column(name = "Customer_Email", length = 128, nullable = false)
    public String getCustomerEmail() {
        return customerEmail;
    }
 
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
 
    @Column(name = "Customer_Phone", length = 128, nullable = false)
    public String getCustomerPhone() {
        return customerPhone;
    }
 
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
