package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class CharRoomDetailTalksAdapter extends CommonAdapter<Item> {
    public CharRoomDetailTalksAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(mDatas.get(position).getIcon()==1){
            TextView sftext=holder.getView(R.id.item_room_talks_sf);
             if(position==2){
                sftext.setText("房主");
                sftext.setTextColor(mContext.getResources().getColor(R.color.red));
            }else if(position==3){
                 sftext.setText("房管");
                 sftext.setTextColor(mContext.getResources().getColor(R.color.blue));
             }
        }else{

        }
    }
    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getIcon()/*==1?ITEM_TYPE.ITEM_TYPE_1.ordinal() : ITEM_TYPE.ITEM_TYPE_2.ordinal()*/;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder;
        if (viewType == 1) {
            holder = ViewHolder.createViewHolder(mContext, parent, R.layout.item_room_talks1);
        } else {
            holder = ViewHolder.createViewHolder(mContext, parent, R.layout.item_room_talks2);
        }
        setListener(parent, holder, viewType);
        return holder;

    }
//    public static enum ITEM_TYPE{
//        ITEM_TYPE_1,
//        ITEM_TYPE_2;
//    }
}
