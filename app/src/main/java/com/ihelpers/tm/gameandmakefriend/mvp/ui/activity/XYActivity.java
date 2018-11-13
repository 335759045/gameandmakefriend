package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;

public class XYActivity extends BaseActivity {
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("用户协议");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_web;
    }

    @Override
    protected void setUpView() {

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
