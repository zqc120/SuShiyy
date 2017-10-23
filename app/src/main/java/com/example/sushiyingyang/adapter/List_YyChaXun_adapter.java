package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.info.YychaxunInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-10-20.
 */

public class List_YyChaXun_adapter extends BaseAdapter{
    private List<YychaxunInfo.ResultBean.ListBean> list;
    private Context ctx;

    public List_YyChaXun_adapter(List<YychaxunInfo.ResultBean.ListBean> list,Context ctx){
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
        convertView = View.inflate(ctx, R.layout.group_yycx_item,null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView RNI = (TextView) convertView.findViewById(R.id.RNI);
        name.setText(list.get(position).getName());
        RNI.setText(list.get(position).getRNI());
        return convertView;
    }
}
