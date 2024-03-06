package com.HAH.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
		System.out.println("before invocation");
	}

	@After("myServiceBean()")
	public void afterInvocation() {
		System.out.println("after invocation");
	}

	@AfterReturning("myServiceBean()")
	public void afterReturning() {
		System.out.println("after returning");
	}

	@AfterThrowing("myServiceBean()")
	public void afterThrowing() {
		System.out.println("after throwing");
	}

	@Around("myServiceBean()")
	public Object aroundInvocation(ProceedingJoinPoint joinPoint) {

		Object result = null;

		try {
			System.out.println("Around Befoe Invocation");
			result = joinPoint.proceed();
			System.out.println("Around after returning Invocation");
		} catch (Throwable e) {
			System.out.println("Around after throwing Invocation");
			throw new RuntimeException(e);
		} finally {
			System.out.println("Around after Invocation");
		}
		return result;
	}
}
