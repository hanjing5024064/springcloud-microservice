package cn.mldn.mldncloud.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldncloud.StartStreamApplication8201;
import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IMessageProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StartStreamApplication8201.class)
@WebAppConfiguration
public class TestMessageProvider {
	@Resource
	private IMessageProvider messageProvider ;	// 注入业务接口实例
	@Test
	public void testSend() {
		DeptDTO dto = new DeptDTO() ;		// 实例化DTO对象
		dto.setDeptno(99L);
		dto.setDname("魔乐科技教学研发部");
		dto.setLoc("北京-天安门");
		this.messageProvider.send(dto);	// 消息发送 
	}
}

