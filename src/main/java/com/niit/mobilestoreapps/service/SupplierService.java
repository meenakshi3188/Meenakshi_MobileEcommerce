package com.niit.mobilestoreapps.service;

import java.util.List;

import com.niit.mobilestoreapps.model.Supplier;

public interface SupplierService {
	public List<Supplier> showSupplier();
	public Supplier getNameById(int id); 
	public void saveSupplier(Supplier obj);	
	public void updateSupplier(Supplier sup);
	public void delete(int id);

}
