/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.mapper;

import com.zcc.user.model.Category;

/**
 * @author c0z00k8
 *
 */
public interface CategoryMapper {

	public void add(Category category);
	
	public void update(Category category);
	
	public void delete(Long id);
	
	public Category findById(Long id);
}
