/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.CategoryMapper;
import com.zcc.user.model.Category;
import com.zcc.user.mq.RabbitMQSender;
import com.zcc.user.mq.RabbitQueue;

/**
 * @author c0z00k8
 *
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(Category category) {
		categoryMapper.add(category); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"category\", \"id\": " + category.getId() + "}");
	}

	public void update(Category category) {
		categoryMapper.update(category); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"category\", \"id\": " + category.getId() + "}");
	}

	public void delete(Long id) {
		categoryMapper.delete(id); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"category\", \"id\": " + id + "}");
	}

	public Category findById(Long id) {
		return categoryMapper.findById(id);
	}
}
