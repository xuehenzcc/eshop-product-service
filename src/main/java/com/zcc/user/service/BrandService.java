/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.BrandMapper;
import com.zcc.user.model.Brand;
import com.zcc.user.mq.RabbitMQSender;
import com.zcc.user.mq.RabbitQueue;

/**
 * @author c0z00k8
 *
 */
@Service
public class BrandService {

	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(Brand brand) {
		brandMapper.add(brand); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"brand\", \"id\": " + brand.getId() + "}");
	}

	public void update(Brand brand) {
		brandMapper.update(brand); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"brand\", \"id\": " + brand.getId() + "}");
	}

	public void delete(Long id) {
		brandMapper.delete(id); 
		rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"brand\", \"id\": " + id + "}");
	}

	public Brand findById(Long id) {
		return brandMapper.findById(id);
	}
	
	public List<Brand> findByIds(Brand brand) {
		return brandMapper.findByIds(brand);
	}
	
}
