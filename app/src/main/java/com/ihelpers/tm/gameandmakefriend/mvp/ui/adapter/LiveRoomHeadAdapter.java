package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.utils.GlideUtil;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class LiveRoomHeadAdapter extends CommonAdapter<Item> {
    public LiveRoomHeadAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        GlideUtil.loadCircleImage(mContext, R.mipmap.ix_tx,(ImageView) holder.getView(R.id.item_image_40_ig));
    }
}
