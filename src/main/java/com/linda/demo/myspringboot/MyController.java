package com.linda.demo.myspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {
  @RequestMapping("/linda")
  public String welcome(){
    System.out.println("controller");
    return "welcome";
  }

  /*
  需要引入FastJsonHttpMessageConverter, 配置文件中需要实现WebApplicationConfigurer
   */
  @RequestMapping("/map")
  @ResponseBody
  public Map<String, String> welcomeMap(){
    System.out.println("controller map");
    Map<String, String> map= new HashMap<>();
    map.put("today","Saturday");
    return map;
  }
}
