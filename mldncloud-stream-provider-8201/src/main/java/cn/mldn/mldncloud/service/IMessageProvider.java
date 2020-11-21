package cn.mldn.mldncloud.service;

import cn.mldn.mldncloud.dto.DeptDTO;

public interface IMessageProvider {
	/**
	 * 实现消息的发送，本次发送的消息是一个对象（自动变为json）
	 * @param dto DTO对象，该对象不为null
	 */
	public void send(DeptDTO dto) ;
}
