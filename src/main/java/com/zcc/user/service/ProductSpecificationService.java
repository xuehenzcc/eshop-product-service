/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.ProductSpecificationMapper;
import com.zcc.user.model.ProductSpecification;
import com.zcc.user.mq.RabbitMQSender;
import com.zcc.user.mq.RabbitQueue;

/**
 * @author c0z00k8
 *
 */
@Service
public class ProductSpecificationService {

	@Autowired
	private ProductSpecificationMapper productSpecificationMapper;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(ProductSpecification productSpecification) {
		productSpecificationMapper.add(productSpecification); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product_specification\", \"id\": " + productSpecification.getId() + 
				", \"product_id\": " + productSpecification.getProductId() +"}");
	}

	public void update(ProductSpecification productSpecification) {
		productSpecificationMapper.update(productSpecification); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product_specification\", \"id\": " + productSpecification.getId() + 
				", \"product_id\": " + productSpecification.getProductId() +"}");
	}

	public void delete(Long id) {
		ProductSpecification productSpecification = findById(id);
		productSpecificationMapper.delete(id); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product_specification\", \"id\": " + id + 
				", \"product_id\": " + productSpecification.getProductId() +"}");
	}

	public ProductSpecification findById(Long id) {
		return productSpecificationMapper.findById(id);
	}
	public ProductSpecification findByProductId(Long productId) {
		return productSpecificationMapper.findByProductId(productId);
	}
}
