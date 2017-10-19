package com.example.sushiyingyang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sushiyingyang.activity.SexAgeActivity;
import com.example.sushiyingyang.activity.SuShiYingYangActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //TODO 第一次进入设置界面 以后就不进入了
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences("guideActivity", MODE_PRIVATE);
                if (preferences.getBoolean("firstStart", true)) {
                    editor = preferences.edit();
                    editor.putBoolean("firstStart", false);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, SexAgeActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, SuShiYingYangActivity.class));
                }
            }
        });
    }
}
