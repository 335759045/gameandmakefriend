package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class SafetySetActivity extends BaseActivity {
    @BindView(R.id.act_safety_set_phone)
    TextView actSafetySetPhone;
    @BindView(R.id.act_safety_set_phone_L)
    LinearLayout actSafetySetPhoneL;
    @BindView(R.id.act_safety_set_pwd_L)
    LinearLayout actSafetySetPwdL;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("安全设置");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_safety_set;
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

    @OnClick({R.id.act_safety_set_phone_L, R.id.act_safety_set_pwd_L})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_safety_set_phone_L:
                Intent intentPhone=new Intent(this,ChangePhoneActivity.class);
                startActivity(intentPhone);
                break;
            case R.id.act_safety_set_pwd_L:
                Intent intentPwd=new Intent(this,ChangePwdActivity.class);
                startActivity(intentPwd);
                break;
        }
    }
}
