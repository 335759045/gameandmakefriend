package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PopSXAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;

public class PXPop extends BasePop {
    private RecyclerView list;
    private PopSXAdapter adapter;
    public PXPop(Context context){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_px, null);
        list= (RecyclerView) mMenuView.findViewById(R.id.pop_px_recycler);
        //设置SelectPicPopupWindow的View
        List<String> s=new ArrayList<>();
        s.add("接单多");
        s.add("评分高");
        list.setLayoutManager(new LinearLayoutManager(context));
        adapter=new PopSXAdapter(context,R.layout.pop_text,s);
        list.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

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

                int top = mMenuView.findViewById(R.id.pop_px_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_px_L).getBottom();
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
