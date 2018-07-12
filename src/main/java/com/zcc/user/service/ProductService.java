/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.ProductMapper;
import com.zcc.user.model.Product;
import com.zcc.user.mq.RabbitMQSender;
import com.zcc.user.mq.RabbitQueue;

/**
 * @author c0z00k8
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(Product product) {
		productMapper.add(product); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
	}

	public void update(Product product) {
		productMapper.update(product); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
	}

	public void delete(Long id) {
		productMapper.delete(id); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product\", \"id\": " + id + "}");
	}

	public Product findById(Long id) {
		return productMapper.findById(id);
	}
}
