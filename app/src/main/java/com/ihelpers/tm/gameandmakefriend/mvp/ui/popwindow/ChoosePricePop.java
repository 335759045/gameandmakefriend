package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ChoosePriceAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;

public class ChoosePricePop extends BasePop {
    private RecyclerView recyclerView;
    private TextView sure;
    private ChoosePriceAdapter adapter;
    OnPopItemListner listner;

    public void setListner(OnPopItemListner listner) {
        this.listner = listner;
    }

    public ChoosePricePop(Context context, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_choose_price, null);

        recyclerView= (RecyclerView) mMenuView.findViewById(R.id.pop_choose_price_recycler);
        sure= (TextView) mMenuView.findViewById(R.id.pop_choose_price_sure);

        sure.setOnClickListener(onClick);

        recyclerView.setLayoutManager(new GridLayoutManager(context,5));
        List<Item> itemList=new ArrayList<>();
        for(int i=0;i<10;i++){
            itemList.add(new Item((i+1),""));
        }
        adapter=new ChoosePriceAdapter(context,R.layout.item_pop_choose_price,itemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                adapter.setItemPosition(position);
                adapter.notifyDataSetChanged();
                listner.onItemClick(position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_choose_price_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_choose_price_L).getBottom();
                int y=(int) event.getY();
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(y<top){
                        dismiss();
                    }
                    if(y>btom){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }
    public interface OnPopItemListner{
        void onItemClick(int position);
    }
}
