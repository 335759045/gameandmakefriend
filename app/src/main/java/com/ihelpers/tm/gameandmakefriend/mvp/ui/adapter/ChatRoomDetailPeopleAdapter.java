package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class ChatRoomDetailPeopleAdapter extends CommonAdapter<Item> {
    public ChatRoomDetailPeopleAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(item.getIcon()==1){
            Glide.with(mContext).load(R.mipmap.room_add).into((ImageView) holder.getView(R.id.fragment_main_gride1_item_icom));
        }else if(item.getIcon()==2){
            Glide.with(mContext).load(R.mipmap.ix_tx).into((ImageView) holder.getView(R.id.fragment_main_gride1_item_icom));
        }else if(item.getIcon()==3){
            Glide.with(mContext).load(R.mipmap.room_lock).into((ImageView) holder.getView(R.id.fragment_main_gride1_item_icom));
        }
    }
}
