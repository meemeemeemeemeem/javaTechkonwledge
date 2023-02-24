package org.example.outer;

/**
 * @Author mei
 * @create 2023/1/1 20:27
 */
public class OutClass {
    /**
     * 内部类
     */
    private static class InnerClass{
        public void doSomething(){
            System.out.println("我是内部类的doSomething()方法");
        }

    }

    public void todo(){
        System.out.println("我是外部类的todo()方法，调用内部类的doSomething()方法-----");
         new InnerClass().doSomething();
    }
}

