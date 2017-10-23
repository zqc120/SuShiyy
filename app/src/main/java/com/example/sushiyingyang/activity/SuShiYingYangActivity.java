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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.adapter.List_Knowledge_adapter;
import com.example.sushiyingyang.adapter.List_help_adapter;
import com.example.sushiyingyang.info.SsyyInfo;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.utils.SharedUtils;
import com.example.sushiyingyang.view.MyListView;
import com.google.gson.Gson;

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
 * Created by Administrator on 2017-10-19.
 */

public class SuShiYingYangActivity extends Activity{
    private ImageView tishiguanbi;
    private TextView tv_sousuo;
    private Button bt_chaxun,bt_shuguo,bt_duibi,bt_tiaozhan;
    private LinearLayout ll_tishi;
    private String year,sex;
    private String year_first,sex_first;
    private SharedUtils sharedUtils;
    private Map<String,String> map;
    private TextView tips_one,tips_two;
    private List<SsyyInfo.ResultBean.HelpListBean> list_help;
    private List<SsyyInfo.ResultBean.KnowledgeListBean> list_knowledge;
    private MyListView lv_bangzhu,lv_knowledge;


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
        //通过性别年份选择进入的请求
        if (year_first!=null){
            map = new HashMap();
            map.put("year",year_first);
            map.put("sex",sex_first);
            list_help = new ArrayList<>();
            list_knowledge = new ArrayList<>();
            OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/getHealthyIndex", map, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }
                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    final String str_first = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject json = new JSONObject(str_first);
                                if (json.getString("Code").equals("1")){
                                    JSONObject result = json.getJSONObject("Result");
                                    JSONArray tips = result.getJSONArray("tips_list");
                                    if (tips.length()==1){
                                        tips_one.setText(tips.getString(0));
                                    }
                                    if (tips.length()==2){
                                        tips_two.setVisibility(View.VISIBLE);
                                        tips_one.setText(tips.getString(0));
                                        tips_two.setText(tips.getString(1));
                                    }
                                    JSONArray helps = result.getJSONArray("help_list");
                                    for (int i =0;i<helps.length();i++){
                                        JSONObject help_o = helps.getJSONObject(i);
                                        SsyyInfo.ResultBean.HelpListBean help_list_info = new SsyyInfo.ResultBean.HelpListBean();
                                        help_list_info.setImg_url_1(help_o.getString("img_url_1"));
                                        help_list_info.setTitle(help_o.getString("title"));
                                        help_list_info.setContent(help_o.getString("content"));
                                        list_help.add(help_list_info);
                                    }
                                    lv_bangzhu.setAdapter(new List_help_adapter(list_help,SuShiYingYangActivity.this));
                                    JSONArray knowledge = result.getJSONArray("knowledge_list");
                                    for (int i =0;i<knowledge.length();i++){
                                        JSONObject knowledge_o = knowledge.getJSONObject(i);
                                        SsyyInfo.ResultBean.KnowledgeListBean know_list_info = new SsyyInfo.ResultBean.KnowledgeListBean();
                                        know_list_info.setImg_url_1(knowledge_o.getString("img_url_1"));
                                        know_list_info.setTitle(knowledge_o.getString("title"));
                                        know_list_info.setTime(knowledge_o.getString("time"));
                                        list_knowledge.add(know_list_info);
                                    }
                                    lv_knowledge.setAdapter(new List_Knowledge_adapter(list_knowledge,SuShiYingYangActivity.this));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }else {
            //通过本地缓存进入的请求
            map = new HashMap();
            map.put("year",year);
            map.put("sex",sex);
            list_help = new ArrayList<>();
            list_knowledge = new ArrayList<>();
            OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/getHealthyIndex", map, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String str = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject json = new JSONObject(str);
                                if (json.getString("Code").equals("1")){
                                    JSONObject result = json.getJSONObject("Result");
                                    JSONArray tips = result.getJSONArray("tips_list");
                                    if (tips.length()==1){
                                        tips_one.setText(tips.getString(0));
                                    }
                                    if (tips.length()==2){
                                        tips_two.setVisibility(View.VISIBLE);
                                        tips_one.setText(tips.getString(0));
                                        tips_two.setText(tips.getString(1));
                                    }
                                    JSONArray helps = result.getJSONArray("help_list");
                                    for (int i =0;i<helps.length();i++){
                                        JSONObject help_o = helps.getJSONObject(i);
                                        SsyyInfo.ResultBean.HelpListBean help_list_info = new SsyyInfo.ResultBean.HelpListBean();
                                        help_list_info.setImg_url_1(help_o.getString("img_url_1"));
                                        help_list_info.setTitle(help_o.getString("title"));
                                        help_list_info.setContent(help_o.getString("content"));
                                        list_help.add(help_list_info);
                                    }
                                    lv_bangzhu.setAdapter(new List_help_adapter(list_help,SuShiYingYangActivity.this));
                                    JSONArray knowledge = result.getJSONArray("knowledge_list");
                                    for (int i =0;i<knowledge.length();i++){
                                        JSONObject knowledge_o = knowledge.getJSONObject(i);
                                        SsyyInfo.ResultBean.KnowledgeListBean know_list_info = new SsyyInfo.ResultBean.KnowledgeListBean();
                                        know_list_info.setImg_url_1(knowledge_o.getString("img_url_1"));
                                        know_list_info.setTitle(knowledge_o.getString("title"));
                                        know_list_info.setTime(knowledge_o.getString("time"));
                                        list_knowledge.add(know_list_info);
                                    }
                                    lv_knowledge.setAdapter(new List_Knowledge_adapter(list_knowledge,SuShiYingYangActivity.this));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
        tips_one = (TextView) findViewById(R.id.tv_tips_one);
        tips_two = (TextView) findViewById(R.id.tv_tips_two);
        lv_bangzhu = (MyListView) findViewById(R.id.lv_bangzhu);
        lv_knowledge = (MyListView) findViewById(R.id.lv_knowledge);
        tv_sousuo = (TextView) findViewById(R.id.tv_sousuo);
        tv_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tishiguanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_tishi.removeAllViews();
            }
        });

        bt_chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuShiYingYangActivity.this,YingYangChaXunActivity.class));
            }
        });
    }
}
