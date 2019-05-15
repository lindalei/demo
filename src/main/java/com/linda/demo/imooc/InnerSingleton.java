package com.linda.demo.imooc;

import java.lang.reflect.Constructor;

public class InnerSingleton {
    private static class Inner{
        private static InnerSingleton innerSingleton = new InnerSingleton();
    }
    public static InnerSingleton getInstance(){
        System.out.println("get instance");
        return Inner.innerSingleton;
    }
    private InnerSingleton() {
        System.out.println("before constructor");
        if(Inner.innerSingleton!=null){ //此时会加载静态内部类，避免通过反射再次实例化
            throw new RuntimeException("can't create from反射");
        }
        System.out.println("after constructor");
    };

    public static void main(String[] args) throws Exception{
        Class object = InnerSingleton.class;
        Constructor constructor = object.getDeclaredConstructor();
        constructor.setAccessible(true);
        InnerSingleton newInstance = (InnerSingleton) constructor.newInstance();
        System.out.println(newInstance);
       // InnerSingleton instance = InnerSingleton.getInstance();
        //System.out.println(instance==newInstance);
    }
}
