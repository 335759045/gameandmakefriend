package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class LiveRoomManagerFragmentAdapter extends CommonAdapter<Item> {
    private int type;
    public LiveRoomManagerFragmentAdapter(Context context,  int type,int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
        this.type=type;
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(type==1){
            holder.setText(R.id.item_live_room_manager_remove,"移除");
        }else if(type==2){
            holder.setText(R.id.item_live_room_manager_remove,"解除禁言");
        }
    }
}
