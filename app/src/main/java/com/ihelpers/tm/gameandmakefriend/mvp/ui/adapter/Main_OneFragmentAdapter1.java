package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class Main_OneFragmentAdapter1 extends CommonAdapter<Item> {


    public Main_OneFragmentAdapter1(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item s, int position) {
        holder.setText(R.id.fragment_main_gride1_item_name,s.getName());
        holder.setImageResource(R.id.fragment_main_gride1_item_icom,s.getIcon());
    }
}
