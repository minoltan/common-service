package com.amitech.springcommonservice.demos.java.features.lambdaFunction;

public class Test implements IFunctionalInterface{
    @Override
    public int cal(int num1, int num2) {
        return 0;
    }

    @Override
    public String defaultMethod(int num1, int num2) {
        return IFunctionalInterface.super.defaultMethod(num1, num2);
    }
}
