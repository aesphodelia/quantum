package com.example.quantum;

import android.graphics.drawable.Drawable;

import java.io.File;

public class Item {
    private int mImg;
    private String mName;

    public Item(int mImg, String mName) {
        this.mImg = mImg;
        this.mName = mName;
    }

    public int getImg(){
        return mImg;
    }
    public void setImg(int mImg){
        this.mImg = mImg;
    }

    public String getName(){
        return mName;
    }
    public void setName(String mName){
        this.mName = mName;
    }
}
