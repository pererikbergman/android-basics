package com.jayway.androidbasics.model;

import com.jayway.androidbasics.model.Data;

import java.util.ArrayList;

public class Model {

    private final ArrayList<Data> mDataList;

    public Model() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            mDataList.add(new Data(i, "Name: " + i, (int) (Math.random() * Integer.MAX_VALUE)));
        }
    }

    public ArrayList<Data> getDataList() {
        return mDataList;
    }

    public Data findById(int id){
        return  mDataList.get(id);
    }
}