package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.demos.java.features.lambdaFunction.IFunctionalInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaFeatureService {

    public List<Integer> getLambdaOutput(int numX, int numY){
        List<Integer> calResult = new ArrayList<>();
        IFunctionalInterface addFunction =  (int num1, int num2) -> {return (num1+num2);};
        IFunctionalInterface subFunction =  (int num1, int num2) -> {return (num2 - num1);};
        IFunctionalInterface mulFunction =  (int num1, int num2) -> {return (num2 * num1);};
        calResult.add(addFunction.cal(numX,numY));
        calResult.add(subFunction.cal(numX, numY));
        calResult.add(mulFunction.cal(numX, numY));
        addFunction.defaultMethod(numX, numY);
        IFunctionalInterface.staticMethod(numX, numY);
        return calResult;
    }


}
