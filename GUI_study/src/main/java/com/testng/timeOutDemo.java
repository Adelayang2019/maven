package com.testng;

import org.testng.annotations.Test;

public class timeOutDemo {
    @Test(timeOut=300)
    public void timeOut1() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("3s run");
    }

    @Test(timeOut=300)
    public void timeOut2() throws InterruptedException {
        System.out.println("3s 内运行");
    }
}
