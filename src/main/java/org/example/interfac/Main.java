package org.example.interfac;

import org.example.interfac.impl.FatherImpl;
import org.example.interfac.impl.SonImpl;

/**
 * @Author mei
 * @create 2023/1/3 10:53
 */
public class Main {
    public static void main(String[] args) {
        FatherInterface fatherInterface=new FatherImpl();
        SonExtendInterface sonExtendInterface = new SonImpl();
        sonExtendInterface.fun();
    }
}
