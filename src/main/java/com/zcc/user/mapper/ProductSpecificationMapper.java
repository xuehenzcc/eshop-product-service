package com.zcc.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zcc.user.model.ProductSpecification;

@Mapper
public interface ProductSpecificationMapper {
	
	public void add(ProductSpecification productSpecification);
	
	public void update(ProductSpecification productSpecification);
	
	public void delete(Long id);
	
	public ProductSpecification findById(Long id);
	
	public ProductSpecification findByProductId(Long productId);
}
