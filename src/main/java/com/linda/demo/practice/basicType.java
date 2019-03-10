package com.linda.demo.practice;

public class basicType {
    public static void main(String[] args){
        byte a=4,b=64;
        byte c=127; //不超过127就可以，超过语法就报错
        byte n='a';
        byte h='h';
        byte z='z';
        byte A='A';
        byte Z='Z';
       // byte e=128; //直接报错
        double d=56.123456789012739567890; //虽然不会报错，但输出只有小数点后14位,最后一位会四舍五入
        double max=1.79E+308;
        float transDouble = (float) max;
        float m=(float)d;
        long l=(long)m; //直接把小数点后的去掉
        System.out.println(d);
        System.out.println(m);
        System.out.println(n); //103
        System.out.println(h);//104
        System.out.println(z);//122
        System.out.println(A); //65
        System.out.println((byte)'a');//97
        System.out.println(Z); //90
        System.out.println(l);
        System.out.println(max);
        System.out.println(transDouble); //infinity，浮点数保存有小数点，不能直接砍掉多余的位数
    }
}
