package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.codeutils.utils.RegexUtils;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.wedget.CountDownTimerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePhoneActivity extends BaseActivity {
    @BindView(R.id.act_change_phone_phone)
    EditText actChangePhonePhone;
    @BindView(R.id.act_change_phone_code)
    EditText actChangePhoneCode;
    @BindView(R.id.act_change_phone_get_code)
    CountDownTimerView actChangePhoneGetCode;
    @BindView(R.id.act_change_phone_sure)
    Button actChangePhoneSure;

    private String phoneStr;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("更换手机号");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_change_phone;
    }

    @Override
    protected void setUpView() {
        actChangePhonePhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneStr = actChangePhonePhone.getText().toString();
                if (RegexUtils.isMobileSimple(phoneStr)) {
                    actChangePhoneGetCode.setBackgroundColor(getResources().getColor(R.color.fen2));
                    actChangePhoneGetCode.setTextColor(getResources().getColor(R.color.red));
                    actChangePhoneGetCode.setEnabled(true);
                } else {
                    actChangePhoneGetCode.setBackgroundResource(R.drawable.shape_galy_bk2);
                    actChangePhoneGetCode.setTextColor(getResources().getColor(R.color.gray_text));
                    actChangePhoneGetCode.setEnabled(false);
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

    @OnClick({R.id.act_change_phone_get_code, R.id.act_change_phone_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_change_phone_get_code:
                actChangePhoneGetCode.startCountDown(60000);
                break;
            case R.id.act_change_phone_sure:
                break;
        }
    }
}
