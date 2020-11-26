package com.linda.demo.myspringboot;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*
这个类可取代spring mvc的xml配置
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    /*
    初始化springcontext, 并扫描业务类
     */
    System.out.println("================web context servlet===============");
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(SpringAppConfig.class);
    //ac.refresh();

    /*
    注册servlet
     */
    //需要将servlet和compnentscan配置类关联，因为很早之前的spring-mvc.xml中配置有servelet, 是相关联的
    DispatcherServlet webServlet = new DispatcherServlet(ac);
    ServletRegistration.Dynamic registration = servletContext.addServlet("app", webServlet);
    registration.setLoadOnStartup(1);
    registration.addMapping("/app/*");
  }
}
