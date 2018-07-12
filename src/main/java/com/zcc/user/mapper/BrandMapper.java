/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.mapper;

import java.util.List;

import com.zcc.user.model.Brand;

/**
 * @author c0z00k8
 *
 */
public interface BrandMapper {

	public void add(Brand brand);
	
	public void update(Brand brand);
	
	public void delete(Long id);
	
	public Brand findById(Long id);
	
	public List<Brand> findByIds(Brand brand);
	
	
}
