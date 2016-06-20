package com.niit.mobilestoreapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.ProductBrandDAO;
import com.niit.mobilestoreapps.model.ProductBrand;

@Service
@Transactional
public class BrandServiceImpl implements BrandService
{
	@Autowired
	ProductBrandDAO pbDao;
	
	@Transactional
	public List<ProductBrand> showBrand() {
		return pbDao.showBrand();
	}

	@Transactional
	public ProductBrand getNameById(int id) {
		return pbDao.getNameById(id);
	}

	@Transactional
	public void savebrand(ProductBrand obj) {
		pbDao.savebrand(obj);
		
	}
	
}