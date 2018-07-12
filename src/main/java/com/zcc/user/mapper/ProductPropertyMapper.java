package com.zcc.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zcc.user.model.ProductProperty;


@Mapper
public interface ProductPropertyMapper {
	
	public void add(ProductProperty productProperty);
	
	public void update(ProductProperty productProperty);
	
	public void delete(Long id);
	
	public ProductProperty findById(Long id);
	
	public ProductProperty findByProductId(Long productId);
}
