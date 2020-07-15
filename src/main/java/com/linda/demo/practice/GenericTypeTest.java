package com.linda.demo.practice;

import com.linda.demo.practice.designPattern.StrategyPattern.BikeStrategy;
import com.linda.demo.practice.designPattern.StrategyPattern.BikeStrategyChild;
import com.linda.demo.practice.designPattern.StrategyPattern.BikeStrategyChild2;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeTest {

  public static void main(String[] args) {
    List<BikeStrategy> children= new ArrayList<>();
    List<? super BikeStrategyChild> queues = new ArrayList<>();
    //queues=children;
    queues.add(new BikeStrategyChild2());
    System.out.println(queues);
  }


}
