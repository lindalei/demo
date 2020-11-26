//package com.linda.demo.myspringboot;
//
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.Wrapper;
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletRegistration;
//
//public class MyTomcatSpring {
//  public static void run() {
//    Tomcat tomcat = new Tomcat();
//    tomcat.setPort(6000);
//    // 如果使用addContext,则不会调用到WebApplicationInitializer中的onStartUp方法，但是tomcat也有servlet context
//    tomcat.addContext("/", "C:\\repo\\");
//    //tomcat.getServer().await();
//
//    System.out.println("================spring tomcat start===============");
//    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//    ac.register(SpringAppConfig.class);
//    //ac.refresh(); //如果启用了@EnableWebMvc,需要注释掉这个方法，因为DispatchServlet中也会调用到refresh方法
//
//    //需要将servlet和compnentscan配置类关联，因为很早之前的spring-mvc.xml中配置有servelet, 是相关联的
//    DispatcherServlet webServlet = new DispatcherServlet(ac);
//    //tomcat有servlet context
//    Wrapper registration = tomcat.addServlet("/", "mvc", webServlet);
//    registration.setLoadOnStartup(1);
//    registration.addMapping("*.do");
//    System.out.println("============spring tomcat finished");
//    try {
//      tomcat.start();
//    } catch (LifecycleException e) {
//      e.printStackTrace();
//    }
//  }
//}
