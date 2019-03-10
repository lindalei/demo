package com.linda.demo.practice;

public class Outer {
    private class Inner {
    }


    public static void staticGetInner() {
        new Outer().new Inner(); //静态方法没有this引用，需要new Outer()
    }

    public void getInner() {
        this.new Inner();
        new Inner();
    }
}
