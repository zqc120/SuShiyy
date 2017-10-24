package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.info.DuiBiInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-10-24.
 */

public class List_Duibi_adapter extends BaseAdapter{
    private List<DuiBiInfo.ResultBean.ListBean> list;
    private Context ctx;

    public List_Duibi_adapter(List<DuiBiInfo.ResultBean.ListBean> list,Context ctx){
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
        convertView = LayoutInflater.from(ctx).inflate(R.layout.duibi_item, null);
        TextView left_tv = (TextView) convertView.findViewById(R.id.tv_zuo_list);
        TextView zhong_tv = (TextView) convertView.findViewById(R.id.tv_zhong_list);
        TextView right_tv = (TextView) convertView.findViewById(R.id.tv_you_list);
        left_tv.setText(list.get(position).getLeft_value());
        zhong_tv.setText(list.get(position).getKey_name());
        right_tv.setText(list.get(position).getRight_value());
        if (list.get(position).getCompare_res().equals("left")){
            left_tv.setTextColor(Color.RED);
        }else {
            right_tv.setTextColor(Color.RED);
        }
        return convertView;
    }
}
