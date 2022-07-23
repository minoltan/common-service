package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.demos.java.features.garbageCollection.Employee;
import com.amitech.springcommonservice.demos.java.features.garbageCollection.GarbageTest;
import com.amitech.springcommonservice.demos.java.features.garbageCollection.MyCleanerTest;
import com.amitech.springcommonservice.demos.java.features.lambdaFunction.IFunctionalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

@Service
public class JavaFeatureService {

    @Autowired
    MyCleanerTest myCleanerTest;

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

    // Deprecated after java 8
    public void garbageCollectionFinalize(){
        GarbageTest t = new GarbageTest();
        System.out.println(t.hashCode());

        t = null;

        // calling garbage collector
        System.gc();

        System.out.println("end");
    }

    // Alternate for finalize
    public void garbageCollectionCleanerTest() {
        myCleanerTest.test();
    }

    public void withoutGarbageCollection(){
        Employee E = new Employee("GFG1", 56);
        Employee F = new Employee("GFG2", 45);
        Employee G = new Employee("GFG3", 25);
        E.show();
        F.show();
        G.show();
        E.showNextId();
        F.showNextId();
        G.showNextId();

        { // It is sub block to keep
            // all those interns.
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);
            X.show();
            Y.show();
            X.showNextId();
            Y.showNextId();
        }
        // After countering this brace, X and Y
        // will be removed.Therefore,
        // now it should show nextId as 4.

        // Output of this line
        E.showNextId();
        // should be 4 but it will give 6 as output.
    }

    public void withGarbageCollection(){
        Employee E = new Employee("GFG1", 56);
        Employee F = new Employee("GFG2", 45);
        Employee G = new Employee("GFG3", 25);
        E.show();
        F.show();
        G.show();
        E.showNextId();
        F.showNextId();
        G.showNextId();

        { // It is sub block to keep
            // all those interns.
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);
            X.show();
            Y.show();
            X.showNextId();
            Y.showNextId();
            X = Y = null;
            System.gc();
            System.runFinalization();
        }
        // After countering this brace, X and Y
        // will be removed.Therefore,
        // now it should show nextId as 4.

        // Output of this line
        E.showNextId();
        // should be 4 but it will give 6 as output.
    }



}
