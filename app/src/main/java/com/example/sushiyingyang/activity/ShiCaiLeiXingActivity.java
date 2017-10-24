package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sushiyingyang.R;
import com.example.sushiyingyang.adapter.Grid_leixing_adapter;
import com.example.sushiyingyang.info.gridleixingInfo;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.view.TopMiddlePopup;

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
 * Created by Administrator on 2017-10-23.
 */

public class ShiCaiLeiXingActivity extends Activity{

    private GridView gridView;
    private String type;
    public static int screenW, screenH;
    private TopMiddlePopup middlePopup;
    private LinearLayout urm_top_ll;
    private TextView topLineTv;
    private TextView topTv;
    private ImageButton urm_back_btn;
    private Map map;
    private List<gridleixingInfo.ResultBean.ListBean> list;
    LinearLayout ll_bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shicaileixing);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        initView();
    }

    /**
     * 设置弹窗内容
     *
     * @return
     */
    private ArrayList<String> getItemsName() {
        ArrayList<String> items = new ArrayList<String>();
        items.add("蔬菜");
        items.add("水果");
        items.add("干果");
        items.add("粮油");
        return items;
    }

    private void initView() {
        ll_bg = (LinearLayout) findViewById(R.id.ll_bg);
        gridView = (GridView) findViewById(R.id.gridView);
        urm_back_btn = (ImageButton) findViewById(R.id.urm_back_btn);
        urm_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        topTv = (TextView) findViewById(R.id.urm_top_tv);
        topLineTv = (TextView) findViewById(R.id.rule_line_tv);
        urm_top_ll = (LinearLayout) findViewById(R.id.urm_top_ll);
        urm_top_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPopup(0);
                middlePopup.show(topLineTv);
            }
        });
        if (type.equals("1")){
            topTv.setText("蔬菜");
            initOk("1");
        }
        if (type.equals("2")){
            topTv.setText("水果");
            initOk("2");
        }
        if (type.equals("3")){
            topTv.setText("干果");
            initOk("3");
        }
        if (type.equals("4")){
            topTv.setText("粮油");
            initOk("4");
        }
    }

    private void initOk(final String type){
        map = new HashMap();
        list = new ArrayList<>();
        map.put("type",type);
        OkUtils.UploadSJ("https://www.isuhuo.com/plainliving/index.php/Androidapi/Healthy/searchFood", map, new Callback() {
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
                                JSONArray result_list = result.getJSONArray("list");
                                for (int i = 0; i < result_list.length(); i++) {
                                    JSONObject jsonobj = result_list.getJSONObject(i);
                                    gridleixingInfo.ResultBean.ListBean info = new gridleixingInfo.ResultBean.ListBean();
                                    info.setTitle(jsonobj.getString("title"));
                                    info.setImg_url(jsonobj.getString("img_url"));
                                    info.setType(jsonobj.getString("type"));
                                    info.setId(jsonobj.getString("id"));
                                    list.add(info);
                                }
                                gridView.setAdapter(new Grid_leixing_adapter(list,ShiCaiLeiXingActivity.this));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    /**
     * 弹窗点击事件
     */
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if (position==0){//蔬菜
                type="1";
                topTv.setText("蔬菜");
                initOk("1");
            }
            if (position==1){//水果
                type="2";
                topTv.setText("水果");
                initOk("2");
            }
            if (position==2){//干果
                type="3";
                topTv.setText("干果");
                initOk("3");
            }
            if (position==3){//粮油
                type="4";
                topTv.setText("粮油");
                initOk("4");
            }
            middlePopup.dismiss();
        }
    };

    /**
     * 设置弹窗
     *
     * @param type
     */
    private void setPopup(int type) {
        middlePopup = new TopMiddlePopup(ShiCaiLeiXingActivity.this, screenW, screenH,
                onItemClickListener, getItemsName(), type);
    }

}
