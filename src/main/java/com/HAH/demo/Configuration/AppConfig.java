package com.HAH.demo.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
    "com.HAH.demo.aspects",
    "com.HAH.demo.service"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {}
