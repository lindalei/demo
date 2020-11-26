package com.linda.demo.reoccurance;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@ComponentScan("com.linda.demo.reoccurance")
@ProcessorAnnotation
//@Import(IndexPostProcessorRegistar.class)
//@EnableAspectJAutoProxy
public class AppConfig {
}
