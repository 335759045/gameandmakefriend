package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PayOrderTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TiXianActivity extends BaseActivity {
    @BindView(R.id.act_tixian_star)
    TextView actTixianStar;
    @BindView(R.id.act_tixian_number)
    EditText actTixianNumber;
    @BindView(R.id.act_tixian_max)
    TextView actTixianMax;
    @BindView(R.id.act_tixian_rmb)
    TextView actTixianRmb;
    @BindView(R.id.act_tixian_recycler)
    RecyclerView actTixianRecycler;
    @BindView(R.id.act_tixian_sure)
    Button actTixianSure;

    private PayOrderTypeAdapter adapter;
    private int intentType=0;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("提现");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_tixian;
    }

    @Override
    protected void setUpView() {
        intentType=getIntent().getIntExtra(Constans.WALLET_TO1,0);
        actTixianRecycler.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items=new ArrayList<>();
        items.add(new Item(R.mipmap.pay_alipay,"支付宝支付"));
        items.add(new Item(R.mipmap.pay_wechat,"微信支付"));
        if(intentType==1){
            actTixianStar.setText("可提现金额：100");
            actTixianRmb.setVisibility(View.GONE);
        }else if(intentType==2){
            actTixianStar.setText("拥有星光值：100");
            items.add(new Item(R.mipmap.pay_alipay,"平台支付"));
        }
        adapter=new PayOrderTypeAdapter(this,R.layout.item_pay_order,items);
        actTixianRecycler.setAdapter(adapter);
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

    @OnClick({R.id.act_tixian_max, R.id.act_tixian_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_tixian_max:
                break;
            case R.id.act_tixian_sure:
                break;
        }
    }
}
