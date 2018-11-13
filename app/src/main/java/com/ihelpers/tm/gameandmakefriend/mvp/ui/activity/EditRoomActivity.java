package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditRoomActivity extends BaseActivity {
    @BindView(R.id.act_edit_room_name)
    TextView actEditRoomName;
    @BindView(R.id.act_edit_room_open)
    TextView actEditRoomOpen;
    @BindView(R.id.act_edit_room_change)
    TextView actEditRoomChange;
    @BindView(R.id.act_edit_room_ig)
    ImageView actEditRoomIg;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        if (getIntent().getIntExtra(Constans.MAIN_TO, 0) == 1) {//表示聊天室
            setTitle("聊天室");
        } else {
            setTitle("直播");
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_edit_room;
    }

    @Override
    protected void setUpView() {
        if (getIntent().getIntExtra(Constans.MAIN_TO, 0) == 1) {//表示聊天室
            actEditRoomOpen.setText("开启房间");
            actEditRoomName.setText("聊天室分类");
        } else {
            actEditRoomOpen.setText("开启直播");
            actEditRoomName.setText("直播分类");
        }
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

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v==getbtn_left()){
            finish();
        }
    }
}
