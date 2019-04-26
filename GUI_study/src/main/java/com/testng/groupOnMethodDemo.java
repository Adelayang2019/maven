package com.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupOnMethodDemo {
    @Test(groups="grouponmethoddemo11")
    public void groupOnMethodDemo1() {
        System.out.println("group on methode demo1111111");
    }
    @Test(groups="grouponmethoddemo11")
    public void groupOnMethodDemo2() {
        System.out.println("group on methode demo2222222");
    }
    @Test(groups="grouponmethoddemo33")
    public void groupOnMethodDemo3() {
        System.out.println("group on methode demo333333333");
    }
    @Test(groups="grouponmethoddemo33")
    public void groupOnMethodDemo4() {
        System.out.println("group on methode demo4444444444");
    }
    @BeforeGroups("grouponmethoddemo11")
    public void beforegroup() {
        System.out.println("beforegroup grouponnethoddemo11");
    }
    @AfterGroups("grouponmethoddemo11")
    public void aftergroup() {
        System.out.println("aftergroup grouponnethoddemo11");
    }
}
