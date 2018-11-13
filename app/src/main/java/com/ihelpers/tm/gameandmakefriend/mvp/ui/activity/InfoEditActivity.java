package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.utils.PikerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoEditActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,PikerUtils.PikerCaseData,PikerUtils.PikerCaseTime{
    @BindView(R.id.act_info_edit_head)
    ImageView actInfoEditHead;
    @BindView(R.id.act_info_edit_name)
    EditText actInfoEditName;
    @BindView(R.id.act_info_edit_rb1)
    RadioButton actInfoEditRb1;
    @BindView(R.id.act_info_edit_rb2)
    RadioButton actInfoEditRb2;
    @BindView(R.id.act_info_edit_rg)
    RadioGroup actInfoEditRg;
    @BindView(R.id.act_info_edit_home)
    TextView actInfoEditHome;
    @BindView(R.id.act_info_edit_city)
    TextView actInfoEditCity;
    @BindView(R.id.act_info_edit_xz)
    TextView actInfoEditXz;
    @BindView(R.id.act_info_edit_zy)
    TextView actInfoEditZy;
    @BindView(R.id.act_info_edit_birthday)
    TextView actInfoEditBirthday;
    @BindView(R.id.act_info_edit_content)
    EditText actInfoEditContent;
    @BindView(R.id.act_info_edit_change)
    Button actInfoEditChange;
    PikerUtils pikerUtils;
    private TimePickerView timePickerView;
    private OptionsPickerView pickerXZ;//星座
    private List<String> xzList=new ArrayList<>();
    InputMethodManager imm;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("编辑资料");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_info_edit;
    }

    @Override
    protected void setUpView() {
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        pikerUtils=new PikerUtils(this);
        timePickerView=pikerUtils.initTimePicker(actInfoEditBirthday,2);
        xzList= Arrays.asList(this.getResources().getStringArray(R.array.xingzuo_list));
        pickerXZ=pikerUtils.initPiker(actInfoEditXz,xzList,R.id.act_info_edit_xz);

        pikerUtils.setPikerCaseTime(this);
        pikerUtils.setPikerCaseData(this);
        actInfoEditRg.setOnCheckedChangeListener(this);
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

    @OnClick({R.id.act_info_edit_home, R.id.act_info_edit_city, R.id.act_info_edit_xz, R.id.act_info_edit_zy, R.id.act_info_edit_birthday, R.id.act_info_edit_change})
    public void onClick(View view) {
        if (imm != null && imm.isActive()) {
            //如果开启
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
        }
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_info_edit_home:
                break;
            case R.id.act_info_edit_city:
                break;
            case R.id.act_info_edit_xz:
                pickerXZ.show();
                break;
            case R.id.act_info_edit_zy:
                break;
            case R.id.act_info_edit_birthday:
                timePickerView.show();
                break;
            case R.id.act_info_edit_change:
                break;
        }
    }

    @Override
    public void caseData(int viewId, int position) {

    }

    @Override
    public void caseTime(String time) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.act_info_edit_rb1:
                break;
            case R.id.act_info_edit_rb2:
                break;
        }
    }
}
