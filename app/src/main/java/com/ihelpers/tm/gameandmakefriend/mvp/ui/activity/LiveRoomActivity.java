package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.CharRoomDetailTalksAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.LiveRoomHeadAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.LiveRoomAudiencePop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.LiveRoomGiftPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.LiveRoomInfoPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MessagePop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.RoomGiftPop;
import com.ihelpers.tm.gameandmakefriend.utils.SystemHelper;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.OnClick;

public class LiveRoomActivity extends BaseActivity implements MultiItemTypeAdapter.OnItemClickListener{
    @BindView(R.id.act_live_room_L)
    LinearLayout actLiveRoomL;
    @BindView(R.id.act_live_room_recycler)
    RecyclerView actLiveRoomRecycler;
    @BindView(R.id.act_live_room_heard)
    ImageView actLiveRoomHeard;
    @BindView(R.id.act_live_room_name)
    TextView actLiveRoomName;
    @BindView(R.id.act_live_room_id)
    TextView actLiveRoomId;
    @BindView(R.id.act_live_room_add)
    TextView actLiveRoomAdd;
    @BindView(R.id.act_live_room_people_num)
    TextView actLiveRoomPeopleNum;
    @BindView(R.id.act_live_room_star_num)
    TextView actLiveRoomStarNum;
    @BindView(R.id.act_live_room_join_recycler)
    RecyclerView actLiveRoomJoinRecycler;
    @BindView(R.id.act_live_room_people)
    TextView actLiveRoomPeople;
    @BindView(R.id.act_live_room_join_L)
    LinearLayout actLiveRoomJoinL;
    @BindView(R.id.act_live_room_talk)
    ImageView actLiveRoomTalk;
    @BindView(R.id.act_live_room_camara)
    ImageView actLiveRoomCamara;
    @BindView(R.id.act_live_room_gift)
    ImageView actLiveRoomGift;
    @BindView(R.id.act_live_room_share)
    ImageView actLiveRoomShare;
    @BindView(R.id.act_live_room_exit)
    ImageView actLiveRoomExit;

    private LiveRoomHeadAdapter headAdapter;
    CharRoomDetailTalksAdapter talksAdapter;

    LiveRoomAudiencePop audiencePop;
    LiveRoomInfoPop infoPop;
    private LiveRoomGiftPop giftPop;
    MessagePop messagePop;
    private int infoType;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        hideTitleView();
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_live_room;
    }

    @Override
    protected void setUpView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemHelper.setMargins(actLiveRoomL, 0, Constans.P_STATUSBAR_HEIGHT, 0, 0);
        }
        audiencePop=new LiveRoomAudiencePop(this,this,this);
        giftPop = new LiveRoomGiftPop(this, this);
        messagePop=new MessagePop(this,"确定结束直播？","确定","取消",this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SystemHelper.setHideAnimation(actLiveRoomJoinL,2000);
            }
        }, 3000);    //延时1s执行
        LinearLayoutManager ms = new LinearLayoutManager(this);
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        actLiveRoomRecycler.setLayoutManager(ms);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Item(1, ""));
        }
        headAdapter = new LiveRoomHeadAdapter(this, R.layout.item_image_40, list);
        actLiveRoomRecycler.setAdapter(headAdapter);

        List<Item> items=new ArrayList<>();
        items.add(new Item(1,"某某人"));
        items.add(new Item(1,"某某人"));
        items.add(new Item(1,"某某人"));
        items.add(new Item(1,"某某人"));
        items.add(new Item(2,"某某人"));
        items.add(new Item(2,"某某人"));
        items.add(new Item(2,"某某人"));
        talksAdapter=new CharRoomDetailTalksAdapter(this,R.layout.item_room_talks1,items);
        actLiveRoomJoinRecycler.setLayoutManager(new LinearLayoutManager(this));
        actLiveRoomJoinRecycler.setAdapter(talksAdapter);
        actLiveRoomJoinRecycler.scrollToPosition(talksAdapter.getDatas().size()-1);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected boolean getretunData() {
        return true;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void reFreshData() {

    }
    private void showPopView(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.findViewById(R.id.act_live_room_main),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, SystemHelper.getNavigationBarHeight(this)); //设置layout在PopupWindow中显示的位置
    }
    @OnClick({R.id.act_live_room_add, R.id.act_live_room_talk, R.id.act_live_room_camara, R.id.act_live_room_gift,
            R.id.act_live_room_share, R.id.act_live_room_exit,R.id.act_live_room_people_num,R.id.act_live_room_zb_info})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_live_room_add:
                break;
            case R.id.act_live_room_talk:
                break;
            case R.id.act_live_room_camara:
                break;
            case R.id.act_live_room_gift:
                showPopView(giftPop);
                break;
            case R.id.act_live_room_share:
                break;
            case R.id.act_live_room_exit:
                showPopView(messagePop);
                break;
            case R.id.act_live_room_people_num:
                showPopView(audiencePop);
                break;
            case R.id.act_live_room_zb_info:
                infoType=3;
                infoPop=new LiveRoomInfoPop(this,infoType,this);
                showPopView(infoPop);
                break;
            case R.id.pop_live_room_info_cancel:
                infoPop.dismiss();
                if(infoType==3){//主播直播间管理
                    Intent intent=new Intent(this,LiveRoomManagerActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                audiencePop.dismiss();
                infoType=2;
                infoPop=new LiveRoomInfoPop(this,infoType,this);
                showPopView(infoPop);
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
