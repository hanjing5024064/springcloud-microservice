package cn.mldn.mldncloud.service.impl;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IMessageProvider;

@EnableBinding(Source.class) // 消息发送管道的定义
public class MessageProviderImpl implements IMessageProvider {
	@Resource
	private MessageChannel output; // 消息的发送管道

	@Override
	public void send(DeptDTO dto) {
		this.output.send(MessageBuilder.withPayload(dto).build()); // 创建并发送消息
	}
}
