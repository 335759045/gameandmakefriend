package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class PopGiftAdapter extends CommonAdapter<Item> {

    public PopGiftAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.setImageResource(R.id.fragment_main_gride1_item_icom,item.getIcon());
        holder.setText(R.id.fragment_main_gride1_item_name,item.getName());
        holder.setText(R.id.fragment_main_gride1_item_z,"1星光值");
        holder.setTextColor(R.id.fragment_main_gride1_item_name,mContext.getResources().getColor(R.color.white));
        holder.setTextColor(R.id.fragment_main_gride1_item_z,mContext.getResources().getColor(R.color.white));
    }
}
