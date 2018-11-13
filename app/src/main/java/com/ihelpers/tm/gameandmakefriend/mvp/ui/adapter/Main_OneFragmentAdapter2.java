package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.wedget.MyGridView;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class Main_OneFragmentAdapter2 extends CommonAdapter<String> {
    private GridItemOnclicListner gridItemOnclicListner;

    public void setGridItemOnclicListner(GridItemOnclicListner gridItemOnclicListner) {
        this.gridItemOnclicListner = gridItemOnclicListner;
    }

    public Main_OneFragmentAdapter2(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, String s, int position) {
        if(position==0){
            holder.getView(R.id.fragment_main_recycler_item_view1).setVisibility(View.GONE);
            holder.getView(R.id.fragment_main_recycler_item_view2).setVisibility(View.GONE);
            TextView textView=holder.getView(R.id.fragment_main_recycler_item_title);
            Drawable drawableLeft = mContext.getResources().getDrawable(
                    R.mipmap.main_hot);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                    null, null, null);
            textView.setCompoundDrawablePadding(10);
        }else{
            holder.getView(R.id.fragment_main_recycler_item_view1).setVisibility(View.VISIBLE);
            holder.getView(R.id.fragment_main_recycler_item_view2).setVisibility(View.VISIBLE);
        }
        MyGridView gridView=holder.getView(R.id.fragment_main_recycler_item_grid);
        Main_OneFragmentAdapter2ItemAdapter adapter=new Main_OneFragmentAdapter2ItemAdapter(mContext);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gridItemOnclicListner.onItemClicl(position);
            }
        });
    }
    public interface GridItemOnclicListner{
        void onItemClicl(int position);
    }
}
