/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.ProductIntroMapper;
import com.zcc.user.model.ProductIntro;
import com.zcc.user.mq.RabbitMQSender;
import com.zcc.user.mq.RabbitQueue;

/**
 * @author c0z00k8
 *
 */
@Service
public class ProductIntroService {

	@Autowired
	private ProductIntroMapper productIntroMapper;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(ProductIntro productIntro) {
		productIntroMapper.add(productIntro); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product_intro\", \"id\": " + productIntro.getId() + 
				", \"product_id\": " + productIntro.getProductId() +"}");
	}

	public void update(ProductIntro productIntro) {
		productIntroMapper.update(productIntro); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product_intro\", \"id\": " + productIntro.getId() + 
				", \"product_id\": " + productIntro.getProductId() +"}");
	}

	public void delete(Long id) {
		ProductIntro productIntro = findById(id);
		productIntroMapper.delete(id); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product_intro\", \"id\": " + id + 
				", \"product_id\": " + productIntro.getProductId() +"}");
	}

	public ProductIntro findById(Long id) {
		return productIntroMapper.findById(id);
	}
	
}
