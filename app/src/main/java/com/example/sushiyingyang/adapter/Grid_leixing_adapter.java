package com.example.sushiyingyang.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sushiyingyang.R;
import com.example.sushiyingyang.activity.ShuGuoLeiXingDetail;
import com.example.sushiyingyang.activity.SouSuoShiCaiActivity;
import com.example.sushiyingyang.info.ShiCaiInfo;
import com.example.sushiyingyang.info.gridleixingInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 */

public class Grid_leixing_adapter extends BaseAdapter {
    private List<gridleixingInfo.ResultBean.ListBean> list;
    private Context ctx;

    public Grid_leixing_adapter(List<gridleixingInfo.ResultBean.ListBean> list, Context ctx) {
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
        convertView = View.inflate(ctx, R.layout.grid_shicai_item, null);
        ImageView iv_grid = (ImageView) convertView.findViewById(R.id.iv_grid);
        TextView tv_grid = (TextView) convertView.findViewById(R.id.tv_grid);
        tv_grid.setText(list.get(position).getTitle());
        if (list.get(position).getType().equals("1")){
            tv_grid.setBackgroundColor(Color.parseColor("#ADFF2F"));
        }
        if (list.get(position).getType().equals("2")){
            tv_grid.setBackgroundColor(Color.parseColor("#97FFFF"));
        }
        if (list.get(position).getType().equals("3")){
            tv_grid.setBackgroundColor(Color.parseColor("#EE2C2C"));
        }
        if (list.get(position).getType().equals("4")){
            tv_grid.setBackgroundColor(Color.parseColor("#FFB90F"));
        }
        Glide.with(ctx)
                .load("http://www.isuhuo.com/plainLiving/" + list.get(position).getImg_url())
                .into(iv_grid);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,ShuGuoLeiXingDetail.class);
                intent.putExtra("ids",list.get(position).getId());
                ctx.startActivity(intent);
            }
        });
        return convertView;
    }
}
