/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月5日
 */
package com.zcc.user.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author c0z00k8
 *
 */
@Component
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(String queue, String message) {  
        this.amqpTemplate.convertAndSend(queue, message);  
    }  
}
