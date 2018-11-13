package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class GrowthTaskAdapter extends CommonAdapter<Item> {

    public GrowthTaskAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(item.getIcon()==1){
            holder.setBackgroundRes(R.id.item_growth_task_L,R.drawable.shape_jianbian_orange);
        }else if(item.getIcon()==2){
            holder.setBackgroundRes(R.id.item_growth_task_L,R.drawable.shape_jianbian_red2);
        }else if(item.getIcon()==3){
            holder.setBackgroundRes(R.id.item_growth_task_L,R.drawable.shape_jianbian_blue);
        }
    }
}
