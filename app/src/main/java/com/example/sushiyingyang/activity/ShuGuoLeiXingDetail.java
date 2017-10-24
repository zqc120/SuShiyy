package com.example.sushiyingyang.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sushiyingyang.R;
import com.example.sushiyingyang.info.ShuguoYYInfo;
import com.example.sushiyingyang.info.gridleixingInfo;
import com.example.sushiyingyang.utils.OkUtils;
import com.example.sushiyingyang.utils.SharedUtils;
import com.example.sushiyingyang.utils.StatusBarUtil;
import com.example.sushiyingyang.view.MyListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017-10-24.
 */

public class ShuGuoLeiXingDetail extends Activity {
    private List<ShuguoYYInfo> list;
    private ImageView ima;
    private List<Drawable> list_ima;
    private ScrollView scrollView;
    // 记录首次按下位置
    private float mFirstPosition = 0;
    // 是否正在放大
    private Boolean mScaling = false;
    private DisplayMetrics metric;
    private String id;
    private Button bt_duibi;
    private SharedUtils shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuguoleixing);
        shared = new SharedUtils();
        Intent intent1 = getIntent();
        id = intent1.getStringExtra("ids");
        StatusBarUtil.setColorDiff(this, 0xff00aff0);
        list = new ArrayList<>();
        list_ima = new ArrayList<>();
        list_ima.add(getResources().getDrawable(R.mipmap.veg1));
        list_ima.add(getResources().getDrawable(R.mipmap.veg2));
        list_ima.add(getResources().getDrawable(R.mipmap.veg3));
        list_ima.add(getResources().getDrawable(R.mipmap.veg4));
        list_ima.add(getResources().getDrawable(R.mipmap.veg5));
        list_ima.add(getResources().getDrawable(R.mipmap.vegx));
        list_ima.add(getResources().getDrawable(R.mipmap.vegy));
        ima = (ImageView) findViewById(R.id.shuguo_detial_imag);
        scrollView = (ScrollView) findViewById(R.id.shuguo_scroll);
        getData();
        LinearLayout fanhui = (LinearLayout) findViewById(R.id.shuguo_detial_fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setScroll();
        initView();
    }

    private void initView() {
        bt_duibi = (Button) findViewById(R.id.bt_duibi);
        bt_duibi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared.saveString("left_id",id,ShuGuoLeiXingDetail.this);
                Intent intent = new Intent(ShuGuoLeiXingDetail.this,ShiCaiDuiBiActivity.class);
                intent.putExtra("idd",id);
                startActivity(intent);
            }
        });
    }

    public void getData() {
        OkUtils.getSJ("http://www.isuhuo.com/plainLiving/Androidapi/Healthy/hea_one/sp_id/"+id, new Callback() {
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
                            TextView tvname = (TextView) findViewById(R.id.shuguo_detial_name);
                            tvname.setText(name);
                            String pic = js2.getString("pic");
                            Glide.with(ShuGuoLeiXingDetail.this)
                                    .load("http://www.isuhuo.com/plainLiving/" + "" + pic)
                                    .into(ima);
                            String content = js2.getString("content");
                            final TextView tvcontent = (TextView) findViewById(R.id.shuguo_detial_content);
                            final LinearLayout moreline = (LinearLayout) findViewById(R.id.shuguo_detial_contentline);
                            tvcontent.setText(content);
                            final int max_line = tvcontent.getLineCount();
                            if (tvcontent.getLineCount() > 4) {
                                tvcontent.setMaxLines(4);
                                tvcontent.setEllipsize(TextUtils.TruncateAt.END);
                                final TextView zhankai = new TextView(getBaseContext());
                                zhankai.setText("展开");
                                zhankai.setTextSize(12);
                                zhankai.setTextColor(0xff00aff0);
                                zhankai.setGravity(Gravity.RIGHT);
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                params.setMargins(0, 0, 45, 30);
                                zhankai.setLayoutParams(params);
                                zhankai.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        tvcontent.setMaxLines(max_line);
                                        moreline.removeView(zhankai);
                                    }
                                });
                                moreline.addView(zhankai);
                            }
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
                            ListView listView = (MyListView) findViewById(R.id.shuguo_detial_list);
                            listView.setFocusable(false);
                            listView.setAdapter(new SGYYAdapter(list, ShuGuoLeiXingDetail.this));
                            //相关菜谱
                            if (!js2.isNull("dish")) {
                                View view = getLayoutInflater().inflate(R.layout.shuguo_detial_relative, null);
                                LinearLayout line = (LinearLayout) view.findViewById(R.id.relative_addline);
                                JSONObject js4 = js2.getJSONObject("dish");
                                JSONArray jaa = js4.getJSONArray("list");
                                if (jaa.length() > 0) {
                                    for (int j = 0; j < jaa.length(); j++) {
                                        if (j < 6) {
                                            JSONObject joo = jaa.getJSONObject(j);
                                            View vv = getLayoutInflater().inflate(R.layout.caipu_relative_item, null);
                                            TextView tv1 = (TextView) vv.findViewById(R.id.relative_item_title);
                                            TextView tv2 = (TextView) vv.findViewById(R.id.relative_item_content);
                                            tv1.setText(joo.getString("title"));
                                            tv2.setText(joo.getString("content"));
                                            ImageView imas = (ImageView) vv.findViewById(R.id.relative_item_ima);
                                            Glide.with(ShuGuoLeiXingDetail.this)
                                                    .load("http://www.isuhuo.com/plainLiving/" + "" + joo.getString("pic"))
                                                    .into(imas);
                                            final String cpid = joo.getString("id");
//                                    vv.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View view) {
//                                            Intent intent1 = new Intent(ShuGuoLeiXingDetail.this, CaipuDetail.class);
//                                            intent1.putExtra("id", cpid);
//                                            JKshuguoDetial.this.startActivity(intent1);
//                                        }
//                                    });
                                            line.addView(vv);
                                        } else {
                                            TextView tv = new TextView(getBaseContext());
                                            tv.setText("查看更多");
                                            tv.setTextSize(12);
                                            tv.setTextColor(0xffa0a0a0);
                                            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
                                            tv.setLayoutParams(params);
                                            tv.setGravity(Gravity.CENTER);
//                                    tv.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View view) {
//                                            Intent intent2=new Intent(JKshuguoDetial.this,JKshuguoDetialMore.class);
//                                            intent2.putExtra("url",URLMannager.ShuGuo_Detial + id);
//                                            JKshuguoDetial.this.startActivity(intent2);
//                                        }
//                                    });
                                            line.addView(tv);
                                            break;
                                        }
                                    }
                                    listView.addFooterView(view);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }

    public class SGYYAdapter extends BaseAdapter {
        private List<ShuguoYYInfo> mydata;
        private Context context;

        public SGYYAdapter(List<ShuguoYYInfo> mydata, Context context) {
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
            view = LayoutInflater.from(context).inflate(R.layout.shuguo_yy_item, null);
            TextView t1 = (TextView) view.findViewById(R.id.shuguo_yy_title);
            TextView t2 = (TextView) view.findViewById(R.id.shuguo_yy_num);
            ImageView imas = (ImageView) view.findViewById(R.id.shuguo_yy_ima);
            imas.setImageDrawable(list_ima.get(position % 7));
            t1.setText(mydata.get(position).getTitle());
            t2.setText(mydata.get(position).getNum());
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent=new Intent(JKshuguoDetial.this,JKPaihangDetial.class);
//                    intent.putExtra("id",mydata.get(x).getId());
//                    intent.putExtra("title","");
//                    JKshuguoDetial.this.startActivity(intent);
//                }
//            });
            return view;
        }
    }

    public void setScroll() {
        metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        ViewGroup.LayoutParams lp = ima.getLayoutParams();
        lp.width = metric.widthPixels;
        lp.height = metric.widthPixels * 12 / 16;
        ima.setLayoutParams(lp);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility", "NewApi"})
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ViewGroup.LayoutParams lp = ima.getLayoutParams();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        //手指离开后恢复图片
                        mScaling = false;
                        replyImage();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (!mScaling) {
                            if (scrollView.getScrollY() == 0) {
                                mFirstPosition = event.getY();// 滚动到顶部时记录位置，否则正常返回
                            } else {
                                break;
                            }
                        }
                        int distance = (int) ((event.getY() - mFirstPosition) * 0.6); // 滚动距离乘以一个系数
                        if (distance < 0) { // 当前位置比记录位置要小，正常返回
                            break;
                        }
                        // 处理放大
                        mScaling = true;
                        lp.width = metric.widthPixels + distance;
                        lp.height = (metric.widthPixels + distance) * 12 / 16;
                        ima.setLayoutParams(lp);
                        return true; // 返回true表示已经完成触摸事件，不再处理
                }
                return false;
            }
        });
    }

    @SuppressLint("NewApi")
    public void replyImage() {
        final ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) ima.getLayoutParams();
        final float w = ima.getLayoutParams().width;// 图片当前宽度
        final float h = ima.getLayoutParams().height;// 图片当前高度
        final float newW = metric.widthPixels;// 图片原宽度
        final float newH = metric.widthPixels * 12 / 16;// 图片原高度

        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration(200);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                lp.width = (int) (w - (w - newW) * cVal);
                lp.height = (int) (h - (h - newH) * cVal);
                ima.setLayoutParams(lp);
            }
        });
        anim.start();
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        StatService.onResume(this);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        StatService.onPause(this);
//    }
}
