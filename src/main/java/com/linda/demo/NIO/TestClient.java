package com.linda.demo.NIO;

import java.util.Scanner;

public class TestClient {
  public static void main(String[] args) throws Exception {
    ChatClient client = new ChatClient();

    //不清楚服务器何时发数据给客户端，需重启一个线程循环监测服务器的数据信息
    new Thread() {
      public void run() {
        try {
          while (true) {
            client.receiveMsg();
            Thread.sleep(2000);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }.start();

    Scanner scanner = new Scanner(System.in);
    System.out.print("输入数据：");
    String str = scanner.next();  // 接收数据
    System.out.println("输入的数据为：" + str);
    client.sendMsg(str);
    //    while (scanner.hasNextLine())
    //      client.sendMsg(str);
    //    }
  }
}

