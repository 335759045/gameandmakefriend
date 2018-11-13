package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class ChatRoomAdapter extends CommonAdapter<Item> {
    public ChatRoomAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        TextView textView=holder.getView(R.id.item_chat_room_type);
        switch (item.getIcon()){
            case 1:
                textView.setBackgroundResource(R.drawable.shape_room_red);
                break;
            case 2:
                textView.setBackgroundResource(R.drawable.shape_room_orange);
                break;
            case 3:
                textView.setBackgroundResource(R.drawable.shape_room_blue);
                break;
            case 4:
                textView.setBackgroundResource(R.drawable.shape_room_green);
                break;
        }
    }
}
