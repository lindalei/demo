package com.linda.demo.practice;

import com.linda.demo.detail.Pineapple;
import org.apache.tomcat.util.buf.StringUtils;

import java.io.*;
import java.text.MessageFormat;

public class SerializationTest {
    public static void serializePineapple() throws IOException {
        Pineapple a = new Pineapple("green", 120);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(
                "D:\\testSerialsize.txt")));
        out.writeObject(a);
        System.out.println("serialize successfully");
        out.close();

    }

    public static Pineapple deSerializePineapple() throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(
                "D:\\testSerialsize.txt")));
        return (Pineapple) in.readObject();


    }

    public static void main(String[] args) throws Exception {
        //serializePineapple();
        Pineapple p = deSerializePineapple();
        System.out.println(p.getWeight());
        System.out.println(MessageFormat.format("Color={0}s, Weight={1}",
                p.getColor(),p.getWeight()));
    }
}
