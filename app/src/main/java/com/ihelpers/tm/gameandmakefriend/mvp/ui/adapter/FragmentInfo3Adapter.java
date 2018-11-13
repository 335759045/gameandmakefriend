package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.wedget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class FragmentInfo3Adapter extends CommonAdapter<Item> {
    public FragmentInfo3Adapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        MyGridView gridView=holder.getView(R.id.item_fragment_info3_gride);
        DTGridAdapter imageGridAdapter = new DTGridAdapter(mContext);
        gridView.setAdapter(imageGridAdapter);
    }
}
