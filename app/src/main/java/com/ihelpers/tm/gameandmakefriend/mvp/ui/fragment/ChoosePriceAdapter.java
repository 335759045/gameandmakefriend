package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class ChoosePriceAdapter extends CommonAdapter<Item> {
    private int itemPosition;

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public ChoosePriceAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.setText(R.id.item_pop_choose_price_text,item.getIcon()+"0元");
        if(position==itemPosition){
            holder.setBackgroundRes(R.id.item_pop_choose_price_text,R.drawable.shape_red_bk);
        }else{
            holder.setBackgroundRes(R.id.item_pop_choose_price_text,R.drawable.shape_galy_bk);
        }
    }
}
