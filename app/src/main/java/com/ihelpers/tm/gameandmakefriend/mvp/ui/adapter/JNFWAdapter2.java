package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.hedgehog.ratingbar.RatingBar;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import app.my.br.com.baserecyclerview.adapter.CommonAdapter;
import app.my.br.com.baserecyclerview.adapter.base.ViewHolder;

public class JNFWAdapter2 extends CommonAdapter<Item> {
    private  ItemTalKListner itemTalKListner;

    public void setItemTalKListner(ItemTalKListner itemTalKListner) {
        this.itemTalKListner = itemTalKListner;
    }

    public JNFWAdapter2(Context context, int layoutId, List<Item> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convertView(ViewHolder holder, Item item, final int position) {
        RatingBar bar=holder.getView(R.id.item_comment_star);
        if(position==1){
            holder.getView(R.id.item_comment_hf_L).setVisibility(View.GONE);
            bar.setStar(3);
        }else{
            bar.setStar(1);
        }
        LinearLayout layout=holder.getView(R.id.item_comment_L);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemTalKListner.itemTotalk(position);
            }
        });
    }
    public interface ItemTalKListner{
        void itemTotalk(int position);
    }
}
