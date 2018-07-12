package com.zcc.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zcc.user.model.Product;


@Mapper
public interface ProductMapper {
	
	public void add(Product product);
	
	public void update(Product product);
	
	public void delete(Long id);
	
	public Product findById(Long id);
	
}
