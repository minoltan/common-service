package com.amitech.springcommonservice.demos.java.designPatterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class MsisdnList {
    private static MsisdnList instance;
    private List<String> msisdnList;
    private MsisdnList(){
        initList();
    }

    public static MsisdnList getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new MsisdnList();
            return instance;
        }
    }

    private void initList(){
        msisdnList = new ArrayList<>();
        msisdnList.add("94773118437");
        msisdnList.add("94771234567");
    }

    public List<String> getMsisdnList(){
        return msisdnList;
    }

}