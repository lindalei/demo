package com.linda.demo.practice.designPattern.FacadePattern;

import com.linda.demo.practice.designPattern.ProxyPattern.Customer;

public class TakePhoto {
  public void takePhoto(Customer customer) {
    System.out.println(customer.toString() + "please smile to take a photo");
  }
}
