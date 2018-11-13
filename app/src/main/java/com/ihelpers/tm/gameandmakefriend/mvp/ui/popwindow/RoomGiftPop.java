package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.GigtAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PopGiftAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.SomeOneAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;

public class RoomGiftPop extends BasePop {
    private TextView xgz;
    private TextView cz;
    private TextView someOne;
    private TextView number;
    private TextView ds;
    private RecyclerView gifts;
    private LinearLayout giveL;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private PopGiftAdapter adapter;
    private SomeOneAdapter someOneAdapter;
    private GigtAdapter giftAdapter;
    List<Item> someOneList=new ArrayList<>();
    private int ap1=0;
    List<Item> giftList=new ArrayList<>();
    private int ap2=0;
    public RoomGiftPop(final Context context, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_room_gift, null);
        xgz= (TextView) mMenuView.findViewById(R.id.pop_room_gift_xgz);
        cz= (TextView) mMenuView.findViewById(R.id.pop_room_gift_cz);
        someOne= (TextView) mMenuView.findViewById(R.id.pop_room_gift_give_so);
        number= (TextView) mMenuView.findViewById(R.id.pop_room_gift_number);
        ds= (TextView) mMenuView.findViewById(R.id.pop_room_gift_ds);
        gifts=(RecyclerView) mMenuView.findViewById(R.id.pop_room_gift_recycler);
        giveL=(LinearLayout) mMenuView.findViewById(R.id.pop_room_gift_give_L);
        recyclerView1=(RecyclerView) mMenuView.findViewById(R.id.pop_room_gift_some_one_recycler);
        recyclerView2=(RecyclerView) mMenuView.findViewById(R.id.pop_room_gift_number_recycler);

        cz.setOnClickListener(onClick);
        giveL.setOnClickListener(onClick);
        number.setOnClickListener(onClick);
        ds.setOnClickListener(onClick);
        ///打赏某人
        someOneAdapter=new SomeOneAdapter(context,R.layout.item_pop_some_one,someOneList);
        recyclerView1.setLayoutManager(new LinearLayoutManager(context));
        recyclerView1.setAdapter(someOneAdapter);
        someOneAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                someOneAdapter.setItemPosition(position);
                someOneAdapter.notifyDataSetChanged();
                recyclerView1.setVisibility(View.INVISIBLE);
                ap1=0;
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        giveL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                someOneList.clear();
                ap1++;
                if(ap1==1){
                    for(int i=0;i<10;i++){
                        someOneList.add(new Item(1,"某某人"));
                    }
                    someOneAdapter.refresh(someOneList);
                    recyclerView1.setVisibility(View.VISIBLE);
                }else{
                    recyclerView1.setVisibility(View.INVISIBLE);
                    ap1=0;
                }
            }
        });
        ///选择礼物数量
        giftAdapter=new GigtAdapter(context,R.layout.item_pop_gift,giftList);
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setAdapter(giftAdapter);
        giftAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                giftAdapter.setItemPosition(position);
                giftAdapter.notifyDataSetChanged();
                recyclerView2.setVisibility(View.INVISIBLE);
                ap2=0;
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giftList.clear();
                ap2++;
                if(ap2==1){
                    giftList.add(new Item(1,"一心一意"));
                    giftList.add(new Item(10,"十全十美"));
                    giftList.add(new Item(66,"一切顺利"));
                    giftList.add(new Item(99,"长长久久"));
                    giftList.add(new Item(188,"要抱抱"));
                    giftList.add(new Item(520,"我爱你"));
                    giftList.add(new Item(1314,"一生一世"));
                    giftAdapter.refresh(giftList);
                    recyclerView2.setVisibility(View.VISIBLE);
                }else{
                    recyclerView2.setVisibility(View.INVISIBLE);
                    ap2=0;
                }
            }
        });

        List<Item> itemList=new ArrayList<>();
        for(int i=0;i<10;i++){
            itemList.add(new Item(R.mipmap.room_gift,"礼物名字"));
        }
        adapter=new PopGiftAdapter(context,R.layout.fragment_main_grid1_item,itemList);
        gifts.setLayoutManager(new GridLayoutManager(context,5));
        gifts.setAdapter(adapter);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_room_gift_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_room_gift_L).getBottom();
                int R1right=mMenuView.findViewById(R.id.pop_room_gift_some_one_recycler).getRight();
                int R1top=mMenuView.findViewById(R.id.pop_room_gift_some_one_recycler).getRight();
                int y=(int) event.getY();
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(y<top){
                        dismiss();
                    }else if(y>btom){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

}
