package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.utils.SharedUtils;
import com.qindachang.widget.RulerView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017-10-19.
 */

public class SexAgeActivity extends Activity {
    private RadioGroup radioGroup;
    private RadioButton rb_nan, rb_nv;
    private TextView tv_xiayibu;
    private RulerView rulerView;
    private String year;
    private TextView tv;
    private String sex;
    private SharedUtils sharedUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexandage);
        initView();
    }

    private void initView() {
        sharedUtils = new SharedUtils();
        rulerView = (RulerView) findViewById(R.id.ruler);//刻度尺年龄选择器
        tv = (TextView) findViewById(R.id.tv);
        initRuler();
        //设置刻度尺年龄选择器
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        rb_nan = (RadioButton) findViewById(R.id.rb_nan);
        rb_nv = (RadioButton) findViewById(R.id.rb_nv);
            tv_xiayibu = (TextView) findViewById(R.id.tv_xiayibu);
            tv_xiayibu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sex == null) {
                        Toast.makeText(getBaseContext(), "请选择性别！", Toast.LENGTH_SHORT).show();
                    }else if(year == null){
                        Toast.makeText(getBaseContext(),"请选择年份！",Toast.LENGTH_SHORT).show();
                    } else {
                        sharedUtils.saveString("sex", sex, getBaseContext());
                        sharedUtils.saveString("year", year, getBaseContext());
                        Intent intent = new Intent(SexAgeActivity.this, SuShiYingYangActivity.class);
                        intent.putExtra("sex", sex);
                        intent.putExtra("year", year);
                        startActivity(intent);
                    }
                }
            });

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if (checkedId == R.id.rb_nan) {
                        sex = "2";//男2
                    } else {
                        sex = "1";//女1
                    }
                }
            });
        }

        /**
         * 刻度尺年龄选择器
         */

    private void initRuler() {
        rulerView.setValue(1990, 1930, 2010, 1);//设置选中值、最小值、最大值、单位值
        rulerView.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float v) {
                String str = String.valueOf(v);
                int idx = str.lastIndexOf(".");
                year = str.substring(0, idx);
                tv.setText(year + "年");
            }
        });
    }
}
