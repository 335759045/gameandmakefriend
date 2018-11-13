package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class SuggestActivity extends BaseActivity {
    @BindView(R.id.act_suggest_content)
    EditText actSuggestContent;
    @BindView(R.id.act_suggest_num)
    TextView actSuggestNum;
    @BindView(R.id.act_suggest_post)
    Button actSuggestPost;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("意见反馈");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_suggest;
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

    @OnClick({R.id.act_suggest_num, R.id.act_suggest_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_suggest_num:
                break;
            case R.id.act_suggest_post:
                break;
        }
    }
}
