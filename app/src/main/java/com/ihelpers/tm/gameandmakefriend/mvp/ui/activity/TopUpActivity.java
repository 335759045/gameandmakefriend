package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PayOrderTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TopUpActivity extends BaseActivity {
    @BindView(R.id.act_top_up_price)
    EditText actTopUpPrice;
    @BindView(R.id.act_top_up_recycler)
    RecyclerView actTopUpRecycler;
    @BindView(R.id.act_top_up_sure)
    Button actTopUpSure;
    private PayOrderTypeAdapter adapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("充值");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_top_up;
    }

    @Override
    protected void setUpView() {
        actTopUpRecycler.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items=new ArrayList<>();
        items.add(new Item(R.mipmap.pay_alipay,"支付宝支付"));
        items.add(new Item(R.mipmap.pay_wechat,"微信支付"));
        adapter=new PayOrderTypeAdapter(this,R.layout.item_pay_order,items);
        actTopUpRecycler.setAdapter(adapter);
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

    @OnClick({ R.id.act_top_up_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_top_up_sure:
                break;
        }
    }
}
