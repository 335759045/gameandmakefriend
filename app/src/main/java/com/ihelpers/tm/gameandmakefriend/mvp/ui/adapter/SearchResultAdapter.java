package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class SearchResultAdapter extends CommonAdapter<Item> {

    public SearchResultAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.getView(R.id.avt_jnfw_add).setVisibility(View.GONE);
        holder.getView(R.id.include_user_address_L).setVisibility(View.GONE);
        holder.getView(R.id.include_user_id).setVisibility(View.VISIBLE);
        holder.setText(R.id.include_user_id,"ID123123");
    }
}
