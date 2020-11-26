package com.linda.demo.myspringboot;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MyTomcat {
  public static void run() {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(9999);
    //addWebApp, tomcat才会认为这是一个web项目，才会调用WebApplicationInitializer中的onStartup方法
    tomcat.addWebapp("/app", "C:\\repo\\app\\");

    // tomcat.addContext("/app","C:\\repo\\app\\");
    //tomcat.getServer().await();
    try {
      tomcat.start();
      tomcat.getServer().await();
    } catch (LifecycleException e) {
      e.printStackTrace();
    }
  }
}
