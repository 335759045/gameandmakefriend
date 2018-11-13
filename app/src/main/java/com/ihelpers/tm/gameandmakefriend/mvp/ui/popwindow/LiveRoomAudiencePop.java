package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.LiveRoomAudiencePopAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;

public class LiveRoomAudiencePop extends BasePop {
    private ImageView close;
    private RecyclerView recycler;
    private LiveRoomAudiencePopAdapter adapter;
    public LiveRoomAudiencePop(Context context,  View.OnClickListener onClick,MultiItemTypeAdapter.OnItemClickListener itemClickListener){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_live_room_audience, null);
        close= (ImageView) mMenuView.findViewById(R.id.pop_live_room_audience_close);
        recycler= (RecyclerView) mMenuView.findViewById(R.id.pop_live_room_audience_recycler);

        close.setOnClickListener(onClick);
        List<Item> list=new ArrayList<>();
        list.add(new Item(1,""));
        list.add(new Item(1,""));
        adapter=new LiveRoomAudiencePopAdapter(context,R.layout.item_pop_audience,list);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(itemClickListener);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_live_room_audience_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_live_room_audience_L).getBottom();
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
