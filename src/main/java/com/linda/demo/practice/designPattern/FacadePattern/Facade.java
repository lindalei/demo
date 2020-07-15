package com.linda.demo.practice.designPattern.FacadePattern;

import com.linda.demo.practice.designPattern.ProxyPattern.Customer;

public class Facade {
  private PrintExcel printExcel=new PrintExcel();
  private TakePhoto takePhoto = new TakePhoto();

  public void service(Customer customer){
    printExcel.print(customer);
    takePhoto.takePhoto(customer);
    System.out.println("you have been served");
  }
}
