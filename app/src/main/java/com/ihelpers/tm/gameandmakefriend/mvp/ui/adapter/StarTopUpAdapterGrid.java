package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class StarTopUpAdapterGrid extends CommonAdapter<Item> {
    private int itemPosition=-1;

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public StarTopUpAdapterGrid(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.setText(R.id.item_star_top_up_tex,item.getName()+"星光值/"+item.getIcon()+"元");
        if(itemPosition==position){
            holder.setBackgroundRes(R.id.item_star_top_up_tex,R.drawable.shape_r);
        }else{
            holder.setBackgroundRes(R.id.item_star_top_up_tex,R.drawable.shape_g);
        }
    }
}
