package org.server.log.mina.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DispatchHandler extends IoHandlerAdapter {
	private final static Logger LOGGER = LoggerFactory.getLogger(DispatchHandler.class);

	@Override
	public void sessionCreated(IoSession session) {
		LOGGER.debug("创建连接,客户端地址:"+session.getRemoteAddress());
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		LOGGER.debug("打开连接");
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		String msg=((String)message).toLowerCase();
		int state=msg.indexOf("error");
		if(state==-1){
			LOGGER.debug("收到日志数据:"+(String)message);
		}else {
			LOGGER.error("收到报错数据:"+(String)message);
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		
		LOGGER.debug("关闭连接");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		LOGGER.error("通讯异常:", cause);
		session.close(true);
	}

}
