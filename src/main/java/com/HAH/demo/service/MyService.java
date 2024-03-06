package com.HAH.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public void HelloMethod(String name, int number) {
        System.out.println("This message is from my service.");
    }
}

