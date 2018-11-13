package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class BaseOrderAdapter extends CommonAdapter<Item> {
    public BaseOrderAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(item.getIcon()==1){
            holder.setText(R.id.item_order_list_status,"待确认");
            holder.setText(R.id.item_order_list_btn,"确认订单");
        }else if(item.getIcon()==2){
            holder.setText(R.id.item_order_list_status,"已取消");
            holder.getView(R.id.item_order_list_status).setVisibility(View.GONE);
        }else if(item.getIcon()==3){
            holder.setText(R.id.item_order_list_status,"待支付");
            holder.setText(R.id.item_order_list_btn,"去支付");
        }else if(item.getIcon()==4){
            holder.setText(R.id.item_order_list_status,"待评价");
            holder.setText(R.id.item_order_list_btn,"评价");
        }else if(item.getIcon()==5){
            holder.setText(R.id.item_order_list_status,"待接单");
            holder.setText(R.id.item_order_list_btn,"取消订单");
        }
    }
}
