package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class FourFragmentAdapter extends CommonAdapter<Item> {
    public FourFragmentAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(item.getIcon()==2){
            holder.setText(R.id.item_fragment_message,"这是普通消息");
        }else if(item.getIcon()==3){
            holder.setText(R.id.item_fragment_message,"[语音]");
        }else if(item.getIcon()==4){
            holder.setText(R.id.item_fragment_message,"[视频]");
        }
    }
}
