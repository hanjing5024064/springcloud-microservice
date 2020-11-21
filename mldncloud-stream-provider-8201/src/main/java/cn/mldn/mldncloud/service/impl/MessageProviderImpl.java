package cn.mldn.mldncloud.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import cn.mldn.mldncloud.channel.DefaultProcess;
import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IMessageProvider;

@EnableBinding(DefaultProcess.class) // 消息发送管道的定义
public class MessageProviderImpl implements IMessageProvider {
	@Qualifier(DefaultProcess.OUTPUT)	// 设置一个标记，避免类型重复 
	@Resource
	private MessageChannel output; // 消息的发送管道

	@Override
	public void send(DeptDTO dto) {
		this.output.send(MessageBuilder.withPayload(dto).build()); // 创建并发送消息
	}
}
