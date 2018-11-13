package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.view.TimePickerView;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.IncomeDetailAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MonthPop;
import com.ihelpers.tm.gameandmakefriend.utils.PikerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IncomeDetailActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,PikerUtils.PikerCaseTime {
    @BindView(R.id.act_income_detail_rb1)
    RadioButton actIncomeDetailRb1;
    @BindView(R.id.act_income_detail_rb2)
    RadioButton actIncomeDetailRb2;
    @BindView(R.id.act_income_detail_rg)
    RadioGroup actIncomeDetailRg;
    @BindView(R.id.act_income_detail_month)
    TextView actIncomeDetailMonth;
    @BindView(R.id.act_income_detail_recycler)
    RecyclerView actIncomeDetailRecycler;

    private IncomeDetailAdapter adapter;
//    MonthPop monthPop;
    private int intentType;//1=收入2=支出3=充值

    PikerUtils pikerUtils;
    private TimePickerView timePickerView;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        intentType=getIntent().getIntExtra(Constans.WALLET_TO2,0);
        if(intentType==1){
            setTitle("收入明细");
        }else if(intentType==2){
            setTitle("支出明细");
        }else if(intentType==3){
            setTitle("充值明细");
        }else if(intentType==4){
            setTitle("提现明细");
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_income_detail;
    }

    @Override
    protected void setUpView() {
        pikerUtils=new PikerUtils(this);
        timePickerView=pikerUtils.initTimePicker(actIncomeDetailMonth,1);
        pikerUtils.setPikerCaseTime(this);

        if(intentType==1){
            actIncomeDetailRb1.setText("3821.15\n收入金额");
            actIncomeDetailRb2.setText("3821.15\n收入星光值");
        }else if(intentType==2){
            actIncomeDetailRb1.setText("3821.15\n支出金额");
            actIncomeDetailRb2.setText("3821.15\n支出星光值");
        }else if(intentType==3){
            actIncomeDetailRb1.setText("3821.15\n充值金额");
            actIncomeDetailRb2.setText("3821.15\n充值星光值");
        }else if(intentType==4){
            actIncomeDetailRb1.setText("3821.15\n提现金额");
            actIncomeDetailRb2.setText("3821.15\n提现星光值");
        }
//        monthPop=new MonthPop(this);

        List<Item> itemList=new ArrayList<>();
        itemList.add(new Item(1,"这是列表标题"));
        itemList.add(new Item(1,"这是列表标题"));
        itemList.add(new Item(1,"这是列表标题"));
        itemList.add(new Item(1,"这是列表标题"));
        actIncomeDetailRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter=new IncomeDetailAdapter(this,R.layout.item_income_detail,itemList,intentType);
        actIncomeDetailRecycler.setAdapter(adapter);

        actIncomeDetailRg.setOnCheckedChangeListener(this);
        pikerUtils.setPikerCaseTime(this);
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

    @OnClick({R.id.act_income_detail_month})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_income_detail_month:
//                monthPop.showAsDropDown(view);
                timePickerView.show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.act_income_detail_rb1:
                break;
            case R.id.act_income_detail_rb2:
                break;
        }
    }

    @Override
    public void caseTime(String time) {

    }
}
