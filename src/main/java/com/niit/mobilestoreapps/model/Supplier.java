package com.niit.mobilestoreapps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier {
	
	@Id
	@Column(name="supp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supp_id;
	
	@Column(name="supp_name")
	private String supp_name;
	
	@Column(name="supp_address")
	private String supp_address;
	
	@Column(name="supp_city")
	private String supp_city;
	
	@Column(name="supp_contact1")
	private int supp_contact1;
	
	@Column(name="supp_contact2")
	private int supp_contact2;
	
	@Column(name="supp_email")
	private String supp_email;
	
	public int getSupp_id() {
		return supp_id;
	}

	public void setSupp_id(int supp_id) {
		this.supp_id = supp_id;
	}

	public String getSupp_name() {
		return supp_name;
	}

	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}

	public String getSupp_address() {
		return supp_address;
	}

	public void setSupp_address(String supp_address) {
		this.supp_address = supp_address;
	}

	public String getSupp_city() {
		return supp_city;
	}

	public void setSupp_city(String supp_city) {
		this.supp_city = supp_city;
	}

	public int getSupp_contact1() {
		return supp_contact1;
	}

	public void setSupp_contact1(int supp_contact1) {
		this.supp_contact1 = supp_contact1;
	}

	public int getSupp_contact2() {
		return supp_contact2;
	}

	public void setSupp_contact2(int supp_contact2) {
		this.supp_contact2 = supp_contact2;
	}

	public String getSupp_email() {
		return supp_email;
	}

	public void setSupp_email(String supp_email) {
		this.supp_email = supp_email;
	}

	

}
