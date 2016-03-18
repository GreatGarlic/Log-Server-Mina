package org.server.log.mina;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 */

public class StartProgram {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// 启动程序关闭钩子,用来阻塞主线程.
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//				super.run();
//			}
//		});

	}

}
