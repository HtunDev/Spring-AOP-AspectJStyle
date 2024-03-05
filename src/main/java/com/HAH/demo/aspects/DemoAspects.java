package com.HAH.demo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspects {

	@Pointcut("bean(myService)")
	void myServiceBean() {

	}

	@Before("myServiceBean()")
	public void beforeInvocation() {
		System.out.println("This is message of Techinal Concerns");
	}

	@After("myServiceBean()")
	public void afterInvocation() {
		System.out.println("This is message of Techinal Concerns");
	}
	
}
