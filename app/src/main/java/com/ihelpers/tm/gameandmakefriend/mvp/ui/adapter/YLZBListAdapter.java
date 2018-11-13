package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class YLZBListAdapter extends CommonAdapter<Item> {
    public YLZBListAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.setImageResource(R.id.item_threefragment_image,R.mipmap.ic_content);
        holder.setBackgroundColor(R.id.item_threefragment_de,R.drawable.shape_oval_blue);
    }
}
