package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.lang.reflect.Method;


public class parameterDemo {
    @Test
    @Parameters({"name","age"})
    public void paraTest1(String name,int age) {
        System.out.println("name="+name+";age="+age);
    }

    @Test(dataProvider="provider1")
    public void paraTest2(String name,int age) {
        System.out.println("name="+name+";age="+age);
    }

    @Test(dataProvider="provider1")
    public void paraTest3(String name,int age) {
        System.out.println("name="+name+";age="+age);
    }


    @DataProvider(name="provider1")
    public Object[][] pro(Method method){
        Object[][] o=null;
        if(method.getName().equals("paraTest2")) {
            o = new Object[][] {
                    {"dfdfdf",20},
                    {"ffffff",19}

            };
        }
        else if(method.getName().equals("paraTest3")){
            o = new Object[][] {
                    {"Adela",30},
                    {"yangyang",25}
            };
        }
        return o;
    }
}
