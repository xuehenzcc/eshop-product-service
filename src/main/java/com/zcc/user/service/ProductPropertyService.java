/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.ProductPropertyMapper;
import com.zcc.user.model.ProductProperty;
import com.zcc.user.mq.RabbitMQSender;
import com.zcc.user.mq.RabbitQueue;

/**
 * @author c0z00k8
 *
 */
@Service
public class ProductPropertyService {

	@Autowired
	private ProductPropertyMapper productPropertyMapper;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(ProductProperty productProperty) {
		productPropertyMapper.add(productProperty); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product_property\", \"id\": " + productProperty.getId() + 
				", \"product_id\": " + productProperty.getProductId() +"}");
	}

	public void update(ProductProperty productProperty) {
		productPropertyMapper.update(productProperty); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product_property\", \"id\": " + productProperty.getId() + 
				", \"product_id\": " + productProperty.getProductId() +"}");
	}

	public void delete(Long id) {
		ProductProperty productProperty = findById(id);
		productPropertyMapper.delete(id); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product_property\", \"id\": " + id + 
				", \"product_id\": " + productProperty.getProductId() +"}");
	}

	public ProductProperty findById(Long id) {
		return productPropertyMapper.findById(id);
	}
	
	public ProductProperty findByProductId(Long productId) {
		return productPropertyMapper.findByProductId(productId);
	}
}
