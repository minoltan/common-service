package com.amitech.springcommonservice.demos.java.features.garbageCollection;

/**
 * @author Minoltan Issack on 7/22/2022
 */
public class GarbageCollection {

    @Override
    protected void finalize()
    {
        System.out.println("finalize method called");
    }
}
