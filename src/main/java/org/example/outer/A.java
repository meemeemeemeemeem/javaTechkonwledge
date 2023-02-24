package org.example.outer;

/**
 * @Author mei
 * @create 2023/1/2 14:35
 */

public class A{
    private static class B
    {
        private static final String high;  //提供一个静态常量high
        static
        {
            high="这是B的high"+Math.random();;     //完成初始化功能，因为是static块，所以只会执行一次。
            System.out.println("static块："+high);
        }
        private void privatesoutB(){
            System.out.println("private"+high);
        }
        public void publicsoutB(){
            System.out.println("public"+high);
        }
    }
    public void c()
    {
        B b = new B();
        b.privatesoutB();
        b.publicsoutB();
        System.out.println("c()方法："+B.high);
    }
}


class E{
    public static void main(String[] args) {

        A a_1=new A();       //这一步还不会执行私有静态内部类
        a_1.c();             //调用c()方法。
        a_1.c();
        A a_2=new A();
        a_2.c();             //调用c()方法。
    }
}


