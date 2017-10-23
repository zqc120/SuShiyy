package com.example.sushiyingyang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

public class YingYangChaXunActivity extends Activity {
    private SharedUtils sharedUtils;
    private String year;
    private String sex;
    private Map<String, String> map;
    private List<YychaxunInfo.ResultBean.ListBean> list;
    private ListView ex_lv;
    public int clickPosition = -1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yychaxun);
        sharedUtils = new SharedUtils();
        year = sharedUtils.getString("year", getBaseContext());
        sex = sharedUtils.getString("sex", getBaseContext());
        initView();
        initOkHttp();
    }

    private void initOkHttp() {
        map = new HashMap<>();
        map.put("year", year);
        map.put("sex", sex);
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
                            if (jsono.getString("Code").equals("1")) {
                                JSONObject result = jsono.getJSONObject("Result");
                                JSONArray result_list = result.getJSONArray("list");
                                for (int i = 0; i < result_list.length(); i++) {
                                    JSONObject jsonobj = result_list.getJSONObject(i);
                                    YychaxunInfo.ResultBean.ListBean info = new YychaxunInfo.ResultBean.ListBean();
                                    info.setName(jsonobj.getString("name"));
                                    info.setRNI(jsonobj.getString("RNI"));
                                    info.setContent(jsonobj.getString("content"));
                                    list.add(info);
                                }
                                ex_lv.setAdapter(new MyAdapter());
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

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final MyViewHolder vh;
            if (convertView==null){
                convertView = View.inflate(getBaseContext(), R.layout.group_yycx_item, null);
                vh = new MyViewHolder(convertView);
                convertView.setTag(vh);
            }else {
                vh = (MyViewHolder) convertView.getTag();
            }
            vh.name.setText(list.get(position).getName());
            vh.RNI.setText(list.get(position).getRNI());
            vh.content.setText(list.get(position).getContent());
            if (clickPosition == position) {//当条目为刚才点击的条目时
                if (vh.selectorImg.isSelected()){//当条目状态图标为选中时，说明该条目处于展开状态，此时让它隐藏，并切换状态图标的状态。
                    vh.selectorImg.setSelected(false);
                    vh.ll_hide.setVisibility(View.GONE);
                    clickPosition=-1;//隐藏布局后需要把标记的position去除掉，否则，滑动listview让该条目划出屏幕范围，
                }else {//当状态条目处于未选中时，说明条目处于未展开状态，此时让他展开。同时切换状态图标的状态。
                    vh.selectorImg.setSelected(true);
                    vh.ll_hide.setVisibility(View.VISIBLE);
                }
            }else {//当填充的条目position不是刚才点击所标记的position时，让其隐藏，状态图标为false。
                vh.ll_hide.setVisibility(View.GONE);
                vh.selectorImg.setSelected(false);
            }
            vh.selectorImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickPosition = position;//记录点击的position
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }

    class MyViewHolder {
        View itemView;
        LinearLayout ll_hide;
        TextView name, RNI,content;
        ImageView selectorImg;


        public MyViewHolder(View itemView) {
            this.itemView = itemView;
            ll_hide = (LinearLayout) itemView.findViewById(R.id.ll_hide);
            name = (TextView) itemView.findViewById(R.id.name);
            RNI = (TextView) itemView.findViewById(R.id.RNI);
            selectorImg = (ImageView) itemView.findViewById(R.id.iv_jiantou);
            content = (TextView) itemView.findViewById(R.id.tv_child_yycx);
        }
    }
}
