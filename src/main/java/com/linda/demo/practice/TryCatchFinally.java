package com.linda.demo.practice;

public class TryCatchFinally {
    private static int y=5;
    public static double divide (int a, int b){
        int x;
        try{
            x=a/b;
            System.out.println(a); //在上一步捕获到异常，这里不会输出
            return x;
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            x=9;
            System.out.println(x);
            return x+5;
        }
    }

    public static void throwTest(int a) throws Exception{
        if(a<0){
           throw new Exception("negative value");
        }
        System.out.println("input is " +a); //throw后的语句不会执行了
    }
    public static void main (String[] args) throws Exception {
        System.out.println(divide(12,4));
        System.out.println(divide(12,0));
        try{
            throwTest(-2);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("perfect catch, but still need handle");
        }
        System.out.println("after catch"); //catch后的语句还会执行
    }

}
