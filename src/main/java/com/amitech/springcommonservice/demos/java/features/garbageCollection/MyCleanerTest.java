package com.amitech.springcommonservice.demos.java.features.garbageCollection;

import com.amitech.springcommonservice.service.JavaFeatureService;
import org.springframework.stereotype.Component;

import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author Minoltan Issack on 7/22/2022
 */
@Component
public class MyCleanerTest {


    public void test() {
        System.out.println("Start MyCleanerTest...");
        Cleaner cleaner = Cleaner.create();
        MyCleanerTest myObject = new MyCleanerTest();
        cleaner.register(myObject, new MyCleanerRunnable());
        /**
         * This for loop is to force JVM to garbage collect myObject initialization.
         **/
        for (int i = 1; i <= 100000; i++) {
            String[] dummyString = new String[1000];
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Execution Finished...");
    }

    private static class MyCleanerRunnable implements Runnable {
        public void run() {
            System.out.println("MyCleanerTest cleaning action executed...");
        }
    }

    public void test2(){
        String value = new String("My String");
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
        PhantomReference<String> phantomReference = new PhantomReference<String>(value, referenceQueue);

        System.out.println("The value object Data : "+ value);
        System.out.println("Reference Poll Value: "+referenceQueue.poll());
        value = null;
        System.out.println("The value object made to null");
        //This for loop is for forcing the value object to garbage collected
        for (int i = 1; i <= 10000; i++) {
            String[] dummyString = new String[1000];
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The value object Data : "+ value);
        //Now value is available on the referenceObject
        Object referenceObject = referenceQueue.poll();
        System.out.println("Reference Poll Value: "+referenceObject);
        if (referenceObject != null && phantomReference == referenceObject) {
            System.out.println("Our Object Is Garbage Collected ....");
        }
    }

}
