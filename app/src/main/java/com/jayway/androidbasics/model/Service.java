package com.jayway.androidbasics.model;

public class Service {

    private static Model sModel;

    public static Model getModel() {
        if(sModel==null){
            sModel = new Model();
        }

        return sModel;
    }
}
