package com.amitech.springcommonservice.demos.java.features.lambdaFunction;

@FunctionalInterface
public interface IFunctionalInterface {
    public abstract int cal(int num1, int num2);

    default String defaultMethod(int num1, int num2){
        return "Hi My numbers are: " + num1 + " & " + num2;
    }

    static String staticMethod(int num1, int num2){
        return "Hi My numbers are: " + num1 + " & " + num2;
    }
}
