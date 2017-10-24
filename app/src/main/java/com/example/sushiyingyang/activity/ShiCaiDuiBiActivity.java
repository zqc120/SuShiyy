package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sushiyingyang.R;
import com.example.sushiyingyang.adapter.List_Duibi_adapter;
import com.example.sushiyingyang.info.DuiBiInfo;
import com.example.sushiyingyang.info.ShuguoYYInfo;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.utils.SharedUtils;
import com.example.sushiyingyang.view.MyListView;

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
 * Created by Administrator on 2017-10-24.
 */

public class ShiCaiDuiBiActivity extends Activity {
    private TextView tv_duibi_zuo,tv_duibi_you;
    private ImageView iv_duibi_zuo,iv_duibi_you;
    private List<ShuguoYYInfo> list;
    private List<DuiBiInfo.ResultBean.ListBean> list_duibi;
    private String left_id;
    private ListView lv_duibi;
    private ImageView iv_cha_zuo;
    private String right_id;
    private Map map;
    private SharedUtils shared;
    private String left_idid;
    private LinearLayout ll_fanhui;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_duibi);
        shared = new SharedUtils();
        left_idid = shared.getString("left_id",ShiCaiDuiBiActivity.this);
        Intent intent = getIntent();
        left_id = intent.getStringExtra("idd");
        right_id = intent.getStringExtra("right_id");
        initView();
        if (right_id==null||right_id==""){
            initOk();
        }else {
            initOk2();
        }
    }

    private void initOk2(){
        map = new HashMap<>();
        list_duibi = new ArrayList<>();
        if (left_idid!=null&&right_id!=null){
            map.put("left_id",left_idid);
            map.put("right_id",right_id);
        }
        OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/foodCompare", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject json = new JSONObject(res);
                            JSONObject result = json.getJSONObject("Result");
                            JSONObject left = result.getJSONObject("left");
                            String left_title = left.getString("title");
                            String left_pic = left.getString("pic");
                            tv_duibi_zuo.setText(left_title);
                            Glide.with(ShiCaiDuiBiActivity.this)
                                    .load("http://www.isuhuo.com/plainLiving/Uploads/Vege/" + left_pic)
                                    .into(iv_duibi_zuo);
                            JSONObject right = result.getJSONObject("right");
                            String right_title = right.getString("title");
                            String right_pic = right.getString("pic");
                            tv_duibi_you.setText(right_title);
                            Glide.with(ShiCaiDuiBiActivity.this)
                                    .load("http://www.isuhuo.com/plainLiving/Uploads/Vege/" + right_pic)
                                    .into(iv_duibi_you);
                            JSONArray jsonarr = result.getJSONArray("list");
                            for (int i =0;i<jsonarr.length();i++){
                                JSONObject jo = jsonarr.getJSONObject(i);
                                DuiBiInfo.ResultBean.ListBean info = new DuiBiInfo.ResultBean.ListBean();
                                info.setLeft_value(jo.getString("left_value"));
                                info.setKey_name(jo.getString("key_name"));
                                info.setRight_value(jo.getString("right_value"));
                                info.setCompare_res(jo.getString("compare_res"));
                                list_duibi.add(info);
                            }
                            lv_duibi.setAdapter(new List_Duibi_adapter(list_duibi,ShiCaiDuiBiActivity.this));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void initOk() {
        list = new ArrayList<>();
        iv_cha_zuo.setVisibility(View.VISIBLE);
        OkUtils.getSJ("http://www.isuhuo.com/plainLiving/Androidapi/Healthy/hea_one/sp_id/" + left_id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject js1 = new JSONObject(s);
                            JSONObject js2 = js1.getJSONObject("Result");
                            String name = js2.getString("title");
                            tv_duibi_zuo.setText(name);
                            Glide.with(ShiCaiDuiBiActivity.this)
                                    .load("http://www.isuhuo.com/plainLiving/" + "" + js2.getString("pic"))
                                    .into(iv_duibi_zuo);
                            //营养成分列表
                            JSONArray ja = js2.getJSONArray("list");
                            for (int i = 0; i < ja.length(); i++) {
                                JSONObject jo = ja.getJSONObject(i);
                                ShuguoYYInfo yy = new ShuguoYYInfo();
                                yy.setTitle(jo.getString("title"));
                                yy.setNum(jo.getString("num"));
                                yy.setId(jo.getString("id"));
                                list.add(yy);
                            }
                            lv_duibi.setFocusable(false);
                            lv_duibi.setAdapter(new SGAdapter(list, ShiCaiDuiBiActivity.this));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }

    public class SGAdapter extends BaseAdapter {
        private List<ShuguoYYInfo> mydata;
        private Context context;

        public SGAdapter(List<ShuguoYYInfo> mydata, Context context) {
            this.mydata = mydata;
            this.context = context;
        }

        @Override
        public int getCount() {
            return mydata.size();
        }

        @Override
        public Object getItem(int i) {
            return mydata.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.duibi_item, null);
            TextView t1 = (TextView) view.findViewById(R.id.tv_zuo_list);
            TextView t2 = (TextView) view.findViewById(R.id.tv_zhong_list);
            t1.setText(mydata.get(position).getNum());
            t2.setText(mydata.get(position).getTitle());
            return view;
        }
    }

    private void initView() {
        tv_duibi_zuo = (TextView) findViewById(R.id.tv_duibi_zuo);
        tv_duibi_you = (TextView) findViewById(R.id.tv_duibi_you);
        iv_duibi_zuo = (ImageView) findViewById(R.id.iv_duibi_zuo);
        lv_duibi = (ListView) findViewById(R.id.lv_duibi);
        iv_cha_zuo = (ImageView) findViewById(R.id.iv_cha_zuo);
        iv_cha_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 左边的取消×号
            }
        });
        iv_duibi_you = (ImageView) findViewById(R.id.iv_duibi_you);
        iv_duibi_you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShiCaiDuiBiActivity.this,SouSuoShiCaiActivity.class);
                String str= "1";
                intent.putExtra("1",str);
                startActivity(intent);
                finish();
            }
        });
        ll_fanhui = (LinearLayout) findViewById(R.id.ll_fanhui);
        ll_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
