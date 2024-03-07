package com.HAH.demo.service;

import org.springframework.stereotype.Component;

import com.HAH.demo.dto.Student;

@Component
public class MyService {

	public Student HelloMethod(String name, int number) {
		System.out.println("This message is from my service.");
		return new Student(name, number);
	}

	public int divided(int num1, int num2) {
		return num1 / num2;
	}
}
