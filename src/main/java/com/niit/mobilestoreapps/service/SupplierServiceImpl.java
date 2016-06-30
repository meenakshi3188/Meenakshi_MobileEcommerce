package com.niit.mobilestoreapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.SupplierDAO;
import com.niit.mobilestoreapps.model.Supplier;
@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierDAO sdao;
	@Transactional
	public List<Supplier> showSupplier() {
		
		return sdao.showSupplier();
	}

	@Transactional
	public Supplier getNameById(int id) {
		return sdao.getNameById(id);
	}

	@Transactional
	public void saveSupplier(Supplier obj) {
		sdao.saveSupplier(obj);
	}

	@Transactional
	public void updateSupplier(Supplier sup) {
		sdao.updateSupplier(sup);
		
	}
	@Transactional
	public void delete(int id) {
		sdao.delete(id);
		
	}

}
