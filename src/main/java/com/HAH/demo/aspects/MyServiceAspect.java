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

import com.HAH.demo.dto.Student;

@Aspect
@Component
public class MyServiceAspect {

	// Define a pointcut for beans of type MyService
	@Pointcut("bean(myService)")
	void myServiceBean() {
	}

	// Advice to be executed before the target method is invoked
	@Before(value = "myServiceBean() && args(name,ageNo)", argNames = "name,ageNo")
	public void beforeInvocation(String name, Integer ageNo) {
		System.out.println("Before Invocation");
		System.out.println("Name is %s".formatted(name));
		System.out.println("Age is %s".formatted(ageNo));
	}

	@After(value = "myServiceBean() && args(*,roomNo)", argNames = "roomNo")
	public void afterInvocation(Integer roomNo) {
		System.out.println("after invocation");
		System.out.println("My room number is %s".formatted(roomNo));
	}

	@AfterReturning(pointcut = "myServiceBean() && execution(com.HAH..Student *(..)) && args(name,QRnumber)", argNames = "student,name,QRnumber", returning = "student")
	public void afterReturning(Student student, String name, Integer QRnumber) {
		System.out.println("after returning");
		System.out.println("Name is %s".formatted(name));
		System.out.println("QR number is %d".formatted(QRnumber));
		System.out.println(student);
	}

	@AfterThrowing(pointcut = "myServiceBean() && args(a,b)", throwing = "exception", argNames = "exception,a,b")
	public void afterThrowing(RuntimeException exception, int a, int b) {
		System.out.println("after throwing");
		System.out.println(exception.getClass().getSimpleName());
		System.out.println(exception.getMessage());
		System.out.println("Arg A :%d".formatted(a));
		System.out.println("Arg B :%d".formatted(b));
	}

	@Around("myServiceBean()")
	public Object aroundInvocation(ProceedingJoinPoint joinPoint) {

		Object result = null;

		try {
			System.out.println("Around Before Invocation");
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
