package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class IncomeDetailAdapter extends CommonAdapter<Item> {
    private int type;
    public IncomeDetailAdapter(Context context, int layoutId, List<Item> datas, int intentType) {
        super(context, layoutId, datas);
        this.type=intentType;
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        if(type==1){
            holder.setText(R.id.item_income_detail_number,"+15.00元");
        }else if(type==2){
            holder.setText(R.id.item_income_detail_number,"-15.00元");
        }else if(type==3){
            holder.getView(R.id.item_income_detail_number).setVisibility(View.GONE);
        }else if(type==4){
            holder.getView(R.id.item_income_detail_number).setVisibility(View.GONE);
        }
    }
}
