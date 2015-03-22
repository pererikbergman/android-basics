package com.jayway.androidbasics.model;

public class Data {
    private final int    mId;
    private final String mName;
    private final int    mValue;

    public Data(int id, String name, int value) {
        mId = id;
        mName = name;
        mValue = value;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return "Data{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mValue=" + mValue +
                '}';
    }
}