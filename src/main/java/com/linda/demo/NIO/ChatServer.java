package com.linda.demo.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class ChatServer {
  private ServerSocketChannel serverSocketChannel;    //监听通道
  private Selector selector;                          //选择器
  private static final int PORT = 9999;               //服务器端口

  public ChatServer() {
    try {
      //1. 得到监听通道
      serverSocketChannel = ServerSocketChannel.open();
      //2. 得到选择器
      selector = Selector.open();
      //3. 绑定端口
      serverSocketChannel.bind(new InetSocketAddress(PORT));
      //4. 设置非阻塞模式
      serverSocketChannel.configureBlocking(false);
      //5. 将监听通道注册到选择器并监听accept事件
      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
      printInfo("Chat Server is ready......");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    try {
      while (true) {                  //不停监控
        if (selector.select(2000) == 0) {
          System.out.println("Server:没有客户端找我，我就干别的事");
          continue;
        }

        //一旦监听到有客户端请求事件发生,使用选择器获取所有selectedKeys的迭代器对象,挨个判断事件类型
        Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
        while (keyIterator.hasNext()) {
          SelectionKey selectionKey = keyIterator.next();
          //连接请求事件
          if (selectionKey.isAcceptable()) {
            //获取通道
            SocketChannel socketChannel = serverSocketChannel.accept();
            //设置非阻塞模式
            socketChannel.configureBlocking(false);
            //将该通道注册到选择器中
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println(socketChannel.getRemoteAddress().toString().substring(1) + "上线了...");
          }

          //读取数据事件
          if (selectionKey.isReadable()) {
            readMsg(selectionKey);
          }

          //一定要把当前key删掉，防止重复处理
          keyIterator.remove();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void printInfo(String msg) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("[" + dateFormat.format(new Date()) + "] ->" + msg);
  }

  //读取客户端发来的消息并广播出去
  private void readMsg(SelectionKey selectionKey) throws Exception {
    //从selectionKey中获取通道
    SocketChannel channel = (SocketChannel) selectionKey.channel();
    //设置缓冲区对象
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    //将通道中的数据读取到缓冲区
    int count = channel.read(byteBuffer);
    if (count > 0) {
      String msg = new String(byteBuffer.array());
      printInfo(msg);
      //发广播给其他客户端
      //broadCast(channel, msg);
    }
  }

  //给所有客户端发送广播
  private void broadCast(SocketChannel except, String msg) throws Exception {
    System.out.println("服务器发送了广播...");
    for (SelectionKey key : selector.keys()) {
      //从selectionKey中获取通道
      Channel targetChannel = key.channel();
      //判断该通道是否为SocketChannel类型
      if (targetChannel instanceof SocketChannel && targetChannel != except) {
        SocketChannel destChannel = (SocketChannel) key.channel();
        //将数据放入缓冲区
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
        //将缓冲区中的数据写入到目标通道中
        destChannel.write(byteBuffer);
      }
    }
  }

  public static void main(String[] args) {
    ChatServer server = new ChatServer();
    server.start();
  }
}
