package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.adapter.List_shicai_adapter;
import com.example.sushiyingyang.info.ShiCaiInfo;
import com.example.sushiyingyang.utils.OkUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.bCallBack;

/**
 * Created by Administrator on 2017-10-23.
 */

public class SouSuoShiCaiActivity extends Activity implements View.OnClickListener {

    private Button bt_shucai,bt_shuiguo,bt_liangyou,bt_ganguo;
    private Map<String,String> map;
    private android.widget.SearchView searchView;
    private LinearLayout linear;
    private List<ShiCaiInfo.ResultBean.ListBean> list;
    private ListView lv_shicai;
    private TextView tv_quxiao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuoshicai);
        initView();
    }

    private void initView() {
        bt_shucai = (Button) findViewById(R.id.bt_shucai);
        bt_shuiguo = (Button) findViewById(R.id.bt_shuiguo);
        bt_liangyou = (Button) findViewById(R.id.bt_liangyou);
        bt_ganguo = (Button) findViewById(R.id.bt_ganguo);
        bt_shucai.setOnClickListener(this);
        bt_shuiguo.setOnClickListener(this);
        bt_liangyou.setOnClickListener(this);
        bt_ganguo.setOnClickListener(this);
        tv_quxiao = (TextView) findViewById(R.id.tv_quxiao);
        tv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv_shicai = (ListView) findViewById(R.id.lv_shicai);
        linear = (LinearLayout) findViewById(R.id.linear);
        searchView = (android.widget.SearchView) findViewById(R.id.search);
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                linear.removeAllViews();
                Log.e("text",newText);
                map = new HashMap<String, String>();
                map.put("keyword",newText);
                list = new ArrayList<ShiCaiInfo.ResultBean.ListBean>();
                OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/searchFood", map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        final String str = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject json = new JSONObject(str);
                                    if (json.getString("Code").equals("1")){
                                        JSONObject result = json.getJSONObject("Result");
                                        JSONArray list_shicai = result.getJSONArray("list");
                                        for (int i = 0;i<list_shicai.length();i++){
                                            JSONObject jsonobj = list_shicai.getJSONObject(i);
                                            ShiCaiInfo.ResultBean.ListBean info = new ShiCaiInfo.ResultBean.ListBean();
                                            info.setTitle(jsonobj.getString("title"));
                                            list.add(info);
                                        }
                                        lv_shicai.setAdapter(new List_shicai_adapter(list,SouSuoShiCaiActivity.this));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_shucai:

                break;
            case R.id.bt_shuiguo:

                break;
            case R.id.bt_liangyou:

                break;
            case R.id.bt_ganguo:

                break;
        }
    }
}
