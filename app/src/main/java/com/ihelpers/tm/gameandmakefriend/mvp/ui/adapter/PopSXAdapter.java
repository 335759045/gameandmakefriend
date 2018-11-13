package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;


import com.ihelpers.tm.gameandmakefriend.R;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class PopSXAdapter extends CommonAdapter<String> {
    public PopSXAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, String s, int position) {
        holder.setText(R.id.pop_text_name,s);
    }
}
