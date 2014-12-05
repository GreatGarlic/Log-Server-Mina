package org.server.log.mina;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *启动类
 */

public class StartProgram {


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

}
