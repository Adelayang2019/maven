package com.testng;

import org.testng.annotations.Test;

public class ingnoredTestDemo {
    @Test(enabled=false)
    public void ingnoredDemo1() {
        System.out.println("ignoreddemo11111");
    }

    @Test(enabled=true)
    public void ingnoredDemo2() {
        System.out.println("ignoreddemo222222");
    }

    @Test(enabled=true)
    public void ingnoredDemo3() {
        System.out.println("ignoreddemo33333");
    }
}
