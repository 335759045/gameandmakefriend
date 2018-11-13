package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PopMonthAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;

public class MonthPop extends BasePop {
    private RecyclerView recyclerView;
    PopMonthAdapter adapter;
    public MonthPop(Context context) {
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_month, null);
        recyclerView= (RecyclerView) mMenuView.findViewById(R.id.pop_month_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        List<Item> s=new ArrayList<>();
        for(int i=0;i<12;i++){
            s.add(new Item(i+1,""));
        }
        adapter=new PopMonthAdapter(context,R.layout.pop_text,s);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_month_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_month_L).getBottom();
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
}
