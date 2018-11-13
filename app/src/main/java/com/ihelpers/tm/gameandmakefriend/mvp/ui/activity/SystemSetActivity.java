package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MessagePop;
import com.ihelpers.tm.gameandmakefriend.utils.SystemHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class SystemSetActivity extends BaseActivity {
    @BindView(R.id.act_system_set_safety_L)
    LinearLayout actSystemSetSafetyL;
    @BindView(R.id.act_system_set_kf_L)
    LinearLayout actSystemSetKfL;
    @BindView(R.id.act_system_set_suggest_L)
    LinearLayout actSystemSetSuggestL;
    @BindView(R.id.act_system_set_clean_L)
    LinearLayout actSystemSetCleanL;
    @BindView(R.id.act_system_set_bb_L)
    LinearLayout actSystemSetBbL;
    @BindView(R.id.act_system_set_exit)
    Button actSystemSetExit;
    MessagePop messagePop;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("系统设置");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_system_set;
    }

    @Override
    protected void setUpView() {
        messagePop=new MessagePop(this,"是否确认清除","取消","确认",this);
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

    @OnClick({R.id.act_system_set_safety_L, R.id.act_system_set_kf_L, R.id.act_system_set_suggest_L, R.id.act_system_set_clean_L, R.id.act_system_set_bb_L, R.id.act_system_set_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_system_set_safety_L:
                Intent intent=new Intent(this,SafetySetActivity.class);
                startActivity(intent);
                break;
            case R.id.act_system_set_kf_L:
                break;
            case R.id.act_system_set_suggest_L:
                Intent intentSuggest=new Intent(this,SuggestActivity.class);
                startActivity(intentSuggest);
                break;
            case R.id.act_system_set_clean_L:
                messagePop.showAtLocation(this.findViewById(R.id.act_system_set_main),
                        Gravity.CENTER , 0, 0); //设置layout在PopupWindow中显示的位置
                break;
            case R.id.act_system_set_bb_L:
                Intent intentVerson=new Intent(this,VersionsActivity.class);
                startActivity(intentVerson);
                break;
            case R.id.act_system_set_exit:
                break;
        }
    }
}
