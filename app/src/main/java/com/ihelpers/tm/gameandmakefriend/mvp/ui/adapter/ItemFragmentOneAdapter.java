package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.wedget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class ItemFragmentOneAdapter extends CommonAdapter<Item> {
    public ItemFragmentOneAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, int position) {
        holder.getView(R.id.include_user_address_L).setVisibility(View.GONE);
        holder.getView(R.id.avt_jnfw_add).setVisibility(View.GONE);
        List<Item> image=new ArrayList<>();
        image.add(new Item(R.mipmap.ic_content,""));
        image.add(new Item(R.mipmap.ic_content,""));
        MyGridView gridView=holder.getView(R.id.item_fragment_one_MyGridView);
        ItemImageAdapter adapter=new ItemImageAdapter(mContext,image);
        gridView.setAdapter(adapter);
    }
}
