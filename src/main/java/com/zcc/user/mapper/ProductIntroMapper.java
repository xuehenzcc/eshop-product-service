package com.zcc.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zcc.user.model.ProductIntro;


@Mapper
public interface ProductIntroMapper {
	
	public void add(ProductIntro productIntro);
	
	public void update(ProductIntro productIntro);
	
	public void delete(Long id);
	
	public ProductIntro findById(Long id);
	
}
