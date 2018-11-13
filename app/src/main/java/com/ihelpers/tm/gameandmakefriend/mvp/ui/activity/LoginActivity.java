package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.act_login_logo)
    ImageView actLoginLogo;
    @BindView(R.id.act_login_phone)
    EditText actLoginPhone;
    @BindView(R.id.act_login_pwd)
    EditText actLoginPwd;
    @BindView(R.id.act_login_btn)
    Button actLoginBtn;
    @BindView(R.id.act_login_register)
    TextView actLoginRegister;
    @BindView(R.id.act_login_forget)
    TextView actLoginForget;
    @BindView(R.id.act_login_code)
    LinearLayout actLoginCode;
    @BindView(R.id.act_login_qq)
    LinearLayout actLoginQq;
    @BindView(R.id.act_login_wechat)
    LinearLayout actLoginWechat;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("登录");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_login;
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

    @OnClick({R.id.act_login_btn, R.id.act_login_register, R.id.act_login_forget, R.id.act_login_code, R.id.act_login_qq, R.id.act_login_wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_login_btn:
                break;
            case R.id.act_login_register:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.act_login_forget:
                Intent intent1=new Intent(this,ForgetActivity.class);
                startActivity(intent1);
                break;
            case R.id.act_login_code:
                Intent intent2=new Intent(this,UsePhoneActivity.class);
                intent2.putExtra(Constans.LOGIN_TO,1);
                startActivity(intent2);
                break;
            case R.id.act_login_qq:
                Intent intent3=new Intent(this,UsePhoneActivity.class);
                intent3.putExtra(Constans.LOGIN_TO,2);
                startActivity(intent3);
                break;
            case R.id.act_login_wechat:
                Intent intent4=new Intent(this,UsePhoneActivity.class);
                intent4.putExtra(Constans.LOGIN_TO,2);
                startActivity(intent4);
                break;
        }
    }
}
