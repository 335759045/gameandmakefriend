package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.wedget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class AllClassifyAdapter extends CommonAdapter<Item> {
    GridItemLister gridItemLister;

    public void setGridItemLister(GridItemLister gridItemLister) {
        this.gridItemLister = gridItemLister;
    }

    public AllClassifyAdapter(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, final int gposition) {
        holder.setBackgroundColor(R.id.item_all_classify_color,item.getIcon());
        holder.setText(R.id.item_all_classify_name,item.getName());
        List<Item> names = new ArrayList<>();
        names.add(new Item(R.mipmap.ic_sy,"item1"));
        names.add(new Item(R.mipmap.ic_sj,"名字"));
        names.add(new Item(R.mipmap.ic_jd,"绝地求生"));
        names.add(new Item(R.mipmap.ic_wz,"王者荣耀"));
        names.add(new Item(R.mipmap.ic_hx,"穿越火线"));
        names.add(new Item(R.mipmap.ic_cg,"唱歌"));
        names.add(new Item(R.mipmap.id_yx,"英雄联盟"));
        MyGridView gridView=holder.getView(R.id.item_all_classify_grid);
        AllClassifyGridItemAdapter adapter=new AllClassifyGridItemAdapter(mContext,names);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int cposition, long id) {
                gridItemLister.onItemClick(gposition,cposition);
            }
        });
    }
    public interface GridItemLister{
        void onItemClick(int Gposition ,int cposition);
    }
}
