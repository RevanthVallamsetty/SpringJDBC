package com.mtc.app.dao;

import java.util.List;

import com.mtc.app.vo.Product;

public interface IProductDAO {
	
	
	Product findById(int id);
	List<Product> findAll();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(int id);
	boolean insertBatch(List<Product> products);

}
