package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.utils.SharedUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by Administrator on 2017-10-19.
 */

public class SuShiYingYangActivity extends Activity{
    private ImageView tishiguanbi;
    private TextView tv_sousuo;
    private Button bt_chaxun,bt_shuguo,bt_duibi,bt_tiaozhan;
    private LinearLayout ll_tishi;
    private String year,sex;
    private String year_first,sex_first;
    SharedUtils sharedUtils;
    private Map map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushiyingyang);
        Intent intent = getIntent();
        year_first = intent.getStringExtra("year");
        sex_first = intent.getStringExtra("sex");
        sharedUtils = new SharedUtils();
        if (year_first==null)
            year = sharedUtils.getString("year",getBaseContext());
        if (sex_first==null)
            sex = sharedUtils.getString("sex",getBaseContext());
        Log.e("year",year);
        initView();
        initOkHttp();
    }

    private void initOkHttp(){
        if (year_first!=null){
            map = new HashMap();
            map.put("year",year_first);
            map.put("sex",sex_first);
            OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/getHealthyIndex", map, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String str_first = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            });
        }else {
            map = new HashMap();
            map.put("year",year);
            map.put("sex",sex);
            OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/getUserHealthy", map, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String str = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            });
        }


    }

    private void initView() {
        ll_tishi = (LinearLayout) findViewById(R.id.ll_tishi);
        tv_sousuo = (TextView) findViewById(R.id.tv_sousuo);
        bt_chaxun = (Button) findViewById(R.id.bt_chaxun);
        bt_shuguo = (Button) findViewById(R.id.bt_shuguo);
        bt_duibi = (Button) findViewById(R.id.bt_duibi);
        bt_tiaozhan = (Button) findViewById(R.id.bt_tiaozhan);
        tishiguanbi = (ImageView) findViewById(R.id.iv_tishiguanbi);

        tishiguanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_tishi.removeAllViews();
            }
        });


    }


}
