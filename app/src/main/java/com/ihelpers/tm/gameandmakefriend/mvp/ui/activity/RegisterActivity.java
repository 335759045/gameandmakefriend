package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.codeutils.utils.RegexUtils;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.wedget.CountDownTimerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.act_change_pwd_phone)
    EditText actChangePwdPhone;
    @BindView(R.id.act_change_pwd_pwd_L)
    LinearLayout actChangePwdPwdL;
    @BindView(R.id.act_change_pwd_code)
    EditText actChangePwdCode;
    @BindView(R.id.act_change_pwd_get_code)
    CountDownTimerView actChangePwdGetCode;
    @BindView(R.id.act_change_pwd_pwd)
    EditText actChangePwdPwd;
    @BindView(R.id.act_change_pwd_again_L)
    LinearLayout actChangePwdAgainL;
    @BindView(R.id.act_change_pwd_sure)
    Button actChangePwdSure;
    @BindView(R.id.act_change_pwd_xy)
    TextView actChangePwdXy;
    @BindView(R.id.act_change_pwd_L)
    LinearLayout actChangePwdL;

    private String phoneStr;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("注册");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_change_pwd;
    }

    @Override
    protected void setUpView() {
        actChangePwdAgainL.setVisibility(View.GONE);
        actChangePwdPwdL.setVisibility(View.VISIBLE);
        actChangePwdL.setVisibility(View.VISIBLE);
        actChangePwdSure.setText("注册");
        actChangePwdPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneStr = actChangePwdPhone.getText().toString();
                if (RegexUtils.isMobileSimple(phoneStr)) {
                    actChangePwdGetCode.setBackgroundColor(getResources().getColor(R.color.fen2));
                    actChangePwdGetCode.setTextColor(getResources().getColor(R.color.red));
                    actChangePwdGetCode.setEnabled(true);
                } else {
                    actChangePwdGetCode.setBackgroundResource(R.drawable.shape_galy_bk2);
                    actChangePwdGetCode.setTextColor(getResources().getColor(R.color.gray_text));
                    actChangePwdGetCode.setEnabled(false);
                }
            }
        });
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

    @OnClick({R.id.act_change_pwd_get_code, R.id.act_change_pwd_sure, R.id.act_change_pwd_xy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_change_pwd_get_code:
                actChangePwdGetCode.startCountDown(60000);
                break;
            case R.id.act_change_pwd_sure:
                break;
            case R.id.act_change_pwd_xy:
                Intent intent = new Intent(this, XYActivity.class);
                startActivity(intent);
                break;
        }
    }
}