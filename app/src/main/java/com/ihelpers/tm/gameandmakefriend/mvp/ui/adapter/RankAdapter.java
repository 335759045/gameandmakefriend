package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class RankAdapter extends CommonAdapter<Item> {
    public RankAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.setText(R.id.item_rank_position,item.getIcon()+"");
    }
}
