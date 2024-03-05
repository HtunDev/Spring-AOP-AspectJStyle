package com.HAH.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.HAH.demo.Configuration.AppConfig;
import com.HAH.demo.service.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class AspectJStyleTest {

	@Autowired
	private MyService myService;
	
	@Test
	void demoTest() {
		myService.HelloMethod();
	}
}
