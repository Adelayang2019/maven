package com.testng;

import org.testng.annotations.*;

public class AnnotationDemo {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("run beforemethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("run aftermethod");
    }
    @Test
    public void test1() {
        System.out.println("run test1");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("run beforeclass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("run afterclass");
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("run beforetest");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("run aftertest");
    }
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("run beforesuite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("run Aftersuite");
    }

}
