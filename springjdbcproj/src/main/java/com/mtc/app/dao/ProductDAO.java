package com.mtc.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mtc.app.vo.Product;

@Repository
public class ProductDAO implements IProductDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
	
	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product product) {
		
		int noOfRows = jdbcTemplate.update(insertQuery,product.getId(),product.getName(),product.getPrice(),product.getDescription(),product.getQuantity());
		
		if(noOfRows == 1)
			return true;
		
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean insertBatch(List<Product> products) {
		jdbcTemplate.batchUpdate(insertQuery, new BatchPreparedStatementSetter() {
			
	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		Product product = products.get(i);
		ps.setInt(1, product.getId());
		ps.setString(2, product.getName());
		ps.setFloat(3, product.getPrice());
		ps.setString(4, product.getDescription());
		ps.setInt(5, product.getQuantity());
	}

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return products.size();
	}
		});
		return true;
	}

}
