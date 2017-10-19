package com.example.sushiyingyang.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017-10-17.
 */

public class SharedUtils {
    private String strs = "";

    public void saveString(String key, String value, Context ctx){
        SharedPreferences shared = ctx.getSharedPreferences(strs, 0);
        SharedPreferences.Editor edit = shared.edit();
        edit.putString(key,value);
        edit.commit();
    }

    public String getString(String key,Context ctx){
        String str=null;
        SharedPreferences shared = ctx.getSharedPreferences(strs, 0);
        str = shared.getString(key,"");
        return str;
    }

}
