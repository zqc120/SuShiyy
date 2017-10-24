package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.sushiyingyang.R;
import com.example.sushiyingyang.activity.ShiCaiDuiBiActivity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(ctx, R.layout.shicai_item,null);
        TextView tv_shicai = (TextView) convertView.findViewById(R.id.tv_shicai);
        tv_shicai.setText(list.get(position).getTitle());
        Button bt_jiaru = (Button) convertView.findViewById(R.id.bt_jiaruduibi);
        bt_jiaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, ShiCaiDuiBiActivity.class);
                intent.putExtra("right_id",list.get(position).getId());
                ctx.startActivity(intent);
            }
        });
        return convertView;
    }
}
