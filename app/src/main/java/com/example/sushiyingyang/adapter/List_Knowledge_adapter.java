package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sushiyingyang.R;
import com.example.sushiyingyang.activity.SuShiYingYangActivity;
import com.example.sushiyingyang.info.SsyyInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-10-20.
 */

public class List_Knowledge_adapter extends BaseAdapter{
    private List<SsyyInfo.ResultBean.KnowledgeListBean> list;
    private Context ctx;

    public List_Knowledge_adapter(List<SsyyInfo.ResultBean.KnowledgeListBean> list, Context ctx){
        this.list = list;
        this.ctx = ctx;
    }

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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(R.layout.zhishi_item,null);
        ImageView img_url = (ImageView) convertView.findViewById(R.id.zhishi_item_iv);
        TextView tv_title = (TextView) convertView.findViewById(R.id.zhishi_item_tv_title);
        TextView tv_time = (TextView) convertView.findViewById(R.id.zhishi_item_tv_time);
        tv_title.setText(list.get(position).getTitle());
        tv_time.setText(list.get(position).getTime());
        Glide.with(ctx)
                .load("http://www.isuhuo.com/plainLiving/"+list.get(position).getImg_url_1())
                .into(img_url);

        return convertView;
    }
}
