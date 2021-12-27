package com.weishen.java8learning;

import org.junit.Test;

public class DefaultStaticMethodInterfaceTest {

    @Test
    public void test(){
        DefaultStaticMethodInterfaceImpl obj = new DefaultStaticMethodInterfaceImpl();
        System.out.println(obj.getName());
        DefaultStaticMethodInterface.show();
    }
}
