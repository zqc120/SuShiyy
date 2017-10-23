package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.adapter.List_YyChaXun_adapter;
import com.example.sushiyingyang.info.YychaxunInfo;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.utils.SharedUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017-10-20.
 */

public class YingYangChaXunActivity extends Activity{
    private SharedUtils sharedUtils;
    private String year;
    private String sex;
    private Map<String,String> map;
    private List<YychaxunInfo.ResultBean.ListBean> list;
    private ListView ex_lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yychaxun);
        sharedUtils = new SharedUtils();
        year = sharedUtils.getString("year",getBaseContext());
        sex = sharedUtils.getString("sex",getBaseContext());
        initView();
        initOkHttp();
    }

    private void initOkHttp() {
        map = new HashMap<>();
        map.put("year",year);
        map.put("sex",sex);
        list = new ArrayList<>();
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
                        JSONObject jsono = null;
                        try {
                            jsono = new JSONObject(str);
                            if (jsono.getString("Code").equals("1")){
                                JSONObject result = jsono.getJSONObject("Result");
                                JSONArray result_list = result.getJSONArray("list");
                                for (int i =0;i<result_list.length();i++){
                                    JSONObject jsonobj = result_list.getJSONObject(i);
                                    YychaxunInfo.ResultBean.ListBean info = new YychaxunInfo.ResultBean.ListBean();
                                    info.setName(jsonobj.getString("name"));
                                    info.setRNI(jsonobj.getString("RNI"));
                                    list.add(info);
                                }
                                ex_lv.setAdapter(new List_YyChaXun_adapter(list,YingYangChaXunActivity.this));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void initView() {
        ex_lv = (ListView) findViewById(R.id.ex_lv);
    }
}
