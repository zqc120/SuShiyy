package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.info.ShiCaiInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 */

public class List_shicai_adapter extends BaseAdapter{
    private List<ShiCaiInfo.ResultBean.ListBean> list;
    private Context ctx;

    public List_shicai_adapter(List<ShiCaiInfo.ResultBean.ListBean> list,Context ctx){
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
        convertView = View.inflate(ctx, R.layout.shicai_item,null);
        TextView tv_shicai = (TextView) convertView.findViewById(R.id.tv_shicai);
        tv_shicai.setText(list.get(position).getTitle());
        return convertView;
    }
}
