package com.linda.demo.myspringboot;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@ComponentScan("com.linda.demo.myspringboot")
@EnableWebMvc
public class SpringAppConfig implements WebMvcConfigurer {
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    System.out.println("fastjson converter");
    converters.add(new FastJsonHttpMessageConverter());
  }
}
//public class SpringAppConfig  {
//}
