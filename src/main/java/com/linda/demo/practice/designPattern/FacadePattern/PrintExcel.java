package com.linda.demo.practice.designPattern.FacadePattern;

import com.linda.demo.practice.designPattern.ProxyPattern.Customer;

public class PrintExcel {
  public void print(Customer customer) {
    System.out.println(customer.toString() + "you need to print this excel file");
  }

  public static PrintExcel getPrinter() {
    return new InnerPrint().getInstance();
  }

  private static class InnerPrint {
    PrintExcel printExcel;

    private PrintExcel getInstance() {
      if (printExcel == null) {
        return new PrintExcel();
      } else {
        return printExcel;
      }
    }
  }
}
