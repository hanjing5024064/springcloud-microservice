package cn.mldn.mldncloud.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import cn.mldn.mldncloud.channel.DefaultProcess;
import cn.mldn.mldncloud.dto.DeptDTO;

@Component
@EnableBinding(DefaultProcess.class)
public class MessageListener { 
	@StreamListener(DefaultProcess.INPUT)
	public void input(Message<DeptDTO> message) {
		System.err.println("【*** 消息接收 ***】" + message.getPayload()); 
	}
}
