package com.example.sushiyingyang;

import android.app.Application;

import com.example.sushiyingyang.utils.SharedUtils;

/**
 * Created by Administrator on 2017-10-19.
 */

public class MyApplication extends Application{
    SharedUtils shared;
    @Override
    public void onCreate() {
        super.onCreate();
        shared = new SharedUtils();


    }
}
