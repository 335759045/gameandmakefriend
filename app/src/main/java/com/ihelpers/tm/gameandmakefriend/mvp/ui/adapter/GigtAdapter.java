package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class GigtAdapter extends CommonAdapter<Item> {
    private int itemPosition=-1;
    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }
    public GigtAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.setText(R.id.item_pop_gift_number,item.getIcon()+"");
        holder.setText(R.id.item_pop_gift_name,item.getName());
        if(itemPosition==position){
            holder.setBackgroundRes(R.id.item_pop_gift_L,R.drawable.shape_some_one_bg);
        }else{
            holder.setBackgroundColor(R.id.item_pop_gift_L,mContext.getResources().getColor(R.color.transparent));
        }
    }
}
