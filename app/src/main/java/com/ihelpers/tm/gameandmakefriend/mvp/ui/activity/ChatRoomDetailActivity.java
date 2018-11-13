package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ChatRoomDetailPeopleAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MorePop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.PopApply;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.PopUserInfo;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.RoomGiftPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.RoomHintPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.RoomMasterPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.SharePop;
import com.ihelpers.tm.gameandmakefriend.utils.SystemHelper;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatRoomDetailActivity extends BaseActivity {
    @BindView(R.id.act_chat_room_detail_main)
    LinearLayout actChatRoomDetailMain;
    @BindView(R.id.act_chat_room_title_left)
    ImageView actChatRoomTitleLeft;
    @BindView(R.id.act_chat_room_title_right)
    ImageView actChatRoomTitleRight;
    @BindView(R.id.act_chat_room_title_text)
    TextView actChatRoomTitleText;
    @BindView(R.id.act_chat_room_id)
    TextView actChatRoomId;
    @BindView(R.id.act_chat_room_number)
    TextView actChatRoomNumber;
    @BindView(R.id.act_chat_room_detail_rule)
    TextView actChatRoomDetailRule;
    @BindView(R.id.act_chat_room_detail_heard)
    ImageView actChatRoomDetailHeard;
    @BindView(R.id.act_chat_room_detail_name)
    TextView actChatRoomDetailName;
    @BindView(R.id.act_chat_room_detail_vip)
    TextView actChatRoomDetailVip;
    @BindView(R.id.act_chat_room_detail_status)
    TextView actChatRoomDetailStatus;
    @BindView(R.id.act_chat_room_detail_people_recycler)
    RecyclerView actChatRoomDetailPeopleRecycler;
    @BindView(R.id.act_chat_room_detail_people)
    TextView actChatRoomDetailPeople;
    @BindView(R.id.act_chat_room_detail_com_L)
    LinearLayout actChatRoomDetailComL;
    @BindView(R.id.act_chat_room_detail_message_recycler)
    RecyclerView actChatRoomDetailMessageRecycler;
    @BindView(R.id.act_chat_room_detail_join)
    TextView actChatRoomDetailJoin;
    @BindView(R.id.act_chat_room_detail_talk)
    ImageView actChatRoomDetailTalk;
    @BindView(R.id.act_chat_room_detail_gift)
    ImageView actChatRoomDetailGift;
    ChatRoomDetailPeopleAdapter peopleAdapter;
    CharRoomDetailTalksAdapter talksAdapter;
    @BindView(R.id.act_chat_room_detail_voice)
    ImageView actChatRoomDetailVoice;

    private RoomMasterPop roomMasterPop;
    private PopApply popApply;
    private PopUserInfo userInfoPop;
    private RoomHintPop hintPop;
    private MorePop morePop;
    private SharePop sharePop;
    private RoomGiftPop giftPop;

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
        return R.layout.act_chat_room_detail;
    }

    @Override
    protected void setUpView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemHelper.setMargins(actChatRoomDetailMain, 0, Constans.P_STATUSBAR_HEIGHT, 0, 0);
        }
        roomMasterPop = new RoomMasterPop(this, this);
        userInfoPop = new PopUserInfo(this, this);
        hintPop = new RoomHintPop(this, "抱用户上麦", "封闭座位", this);
        morePop = new MorePop(this, "分享房间", "退出房间", this);
        sharePop = new SharePop(this, this);
        giftPop = new RoomGiftPop(this, this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SystemHelper.setHideAnimation(actChatRoomDetailComL, 2000);
            }
        }, 3000);    //延时1s执行

        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "名字"));
        list.add(new Item(1, "名字"));
        list.add(new Item(1, "名字"));
        list.add(new Item(3, "名字"));
        list.add(new Item(2, "名字"));
        list.add(new Item(1, "名字"));
        list.add(new Item(3, "名字"));
        list.add(new Item(2, "名字"));
        peopleAdapter = new ChatRoomDetailPeopleAdapter(this, R.layout.fragment_main_grid1_item, list);
        actChatRoomDetailPeopleRecycler.setLayoutManager(new GridLayoutManager(this, 4));
        actChatRoomDetailPeopleRecycler.setAdapter(peopleAdapter);
        peopleAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (peopleAdapter.getDatas().get(position).getIcon() == 1) {
                    popApply = new PopApply(ChatRoomDetailActivity.this, "申请上麦", ChatRoomDetailActivity.this);
                    showPopView(popApply);
                } else if (peopleAdapter.getDatas().get(position).getIcon() == 2) {
                    showPopView(userInfoPop);
                } else if (peopleAdapter.getDatas().get(position).getIcon() == 3) {
                    showPopView(hintPop);
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "某某人"));
        items.add(new Item(1, "某某人"));
        items.add(new Item(1, "某某人"));
        items.add(new Item(1, "某某人"));
        items.add(new Item(2, "某某人"));
        talksAdapter = new CharRoomDetailTalksAdapter(this, R.layout.item_room_talks1, items);
        actChatRoomDetailMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        actChatRoomDetailMessageRecycler.setAdapter(talksAdapter);
        actChatRoomDetailMessageRecycler.scrollToPosition(talksAdapter.getDatas().size() - 1);
    }

    private void showPopView(PopupWindow popupWindow) {
        popupWindow.showAtLocation(ChatRoomDetailActivity.this.findViewById(R.id.act_room_detail_main),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, SystemHelper.getNavigationBarHeight(this)); //设置layout在PopupWindow中显示的位置
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

    @OnClick({R.id.act_chat_room_title_left, R.id.act_chat_room_title_right, R.id.act_chat_room_detail_rule, R.id.act_chat_room_detail_heard,
            R.id.act_chat_room_detail_join, R.id.act_chat_room_detail_talk, R.id.act_chat_room_detail_gift})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_chat_room_title_left:
                finish();
                break;
            case R.id.act_chat_room_title_right:
                showPopView(morePop);
                break;
            case R.id.act_chat_room_title_text:
                showPopView(roomMasterPop);
                break;
            case R.id.act_chat_room_detail_rule:
                Intent intent = new Intent(this, ChatRoomRuleActivity.class);
                startActivity(intent);
                break;
            case R.id.act_chat_room_detail_heard:
                break;
            case R.id.act_chat_room_detail_join:
                popApply = new PopApply(ChatRoomDetailActivity.this, "申请上麦", ChatRoomDetailActivity.this);
                showPopView(popApply);
                break;
            case R.id.act_chat_room_detail_talk:
                break;
            case R.id.act_chat_room_detail_gift:
                showPopView(giftPop);
                break;
            case R.id.pop_hint_title://抱用户上麦
                Intent intent1 = new Intent(this, ChooseUserActivity.class);
                startActivity(intent1);
                break;
            //右上角更多
            case R.id.pop_more_share:
                showPopView(sharePop);
                morePop.dismiss();
                break;
            case R.id.pop_more_exit:
                morePop.dismiss();
                finish();
                break;
            case R.id.pop_more_cancel:
                morePop.dismiss();
                break;
            //分享
            case R.id.pop_share_wechat:
                sharePop.dismiss();
                break;
            case R.id.pop_share_friend:
                sharePop.dismiss();
                break;
            case R.id.pop_share_qq:
                sharePop.dismiss();
                break;
            case R.id.pop_share_sina:
                sharePop.dismiss();
                break;
            //送礼物
            case R.id.pop_room_gift_ds:
                toastShow("打赏成功");
                giftPop.dismiss();
                break;
        }
    }
}
