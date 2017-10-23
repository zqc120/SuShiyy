package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.info.SsyyInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-10-20.
 */

public class List_help_adapter extends BaseAdapter{
    private List<SsyyInfo.ResultBean.HelpListBean> list;
    private Context ctx;

    public List_help_adapter(List<SsyyInfo.ResultBean.HelpListBean> list,Context ctx){
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
        convertView = LayoutInflater.from(ctx).inflate(R.layout.bangzhu_item,null);
        ImageView img_url = (ImageView) convertView.findViewById(R.id.bangzhu_item_iv);
        TextView tv_title = (TextView) convertView.findViewById(R.id.bangzhu_item_tv_title);
        TextView tv_content = (TextView) convertView.findViewById(R.id.bangzhu_item_tv_zhengwen);
        tv_title.setText(list.get(position).getTitle());
        tv_content.setText(list.get(position).getContent());
        return convertView;
    }
}
