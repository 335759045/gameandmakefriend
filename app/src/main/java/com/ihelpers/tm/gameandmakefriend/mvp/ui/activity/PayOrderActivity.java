package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PayOrderTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayOrderActivity extends BaseActivity {
    @BindView(R.id.avt_jnfw_image_heard)
    ImageView avtJnfwImageHeard;
    @BindView(R.id.avt_jnfw_name)
    TextView avtJnfwName;
    @BindView(R.id.avt_jnfw_vip_num)
    TextView avtJnfwVipNum;
    @BindView(R.id.avt_jnfw_hy_num)
    TextView avtJnfwHyNum;
    @BindView(R.id.avt_jnfw_sex_ig)
    ImageView avtJnfwSexIg;
    @BindView(R.id.avt_jnfw_age)
    TextView avtJnfwAge;
    @BindView(R.id.avt_jnfw_address)
    TextView avtJnfwAddress;
    @BindView(R.id.avt_jnfw_status)
    TextView avtJnfwStatus;
    @BindView(R.id.include_user_address_L)
    LinearLayout includeUserAddressL;
    @BindView(R.id.avt_jnfw_add)
    TextView avtJnfwAdd;
    @BindView(R.id.act_pay_order_type)
    TextView actPayOrderType;
    @BindView(R.id.act_pay_order_price)
    TextView actPayOrderPrice;
    @BindView(R.id.act_pay_order_money)
    TextView actPayOrderMoney;
    @BindView(R.id.act_pay_order_recycler)
    RecyclerView actPayOrderRecycler;
    @BindView(R.id.act_pay_order_pay)
    Button actPayOrderPay;

    private PayOrderTypeAdapter adapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("支付订单");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_pay_order;
    }

    @Override
    protected void setUpView() {
        includeUserAddressL.setVisibility(View.GONE);
        avtJnfwAdd.setVisibility(View.GONE);
        actPayOrderRecycler.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items=new ArrayList<>();
        items.add(new Item(R.mipmap.pay_alipay,"支付宝支付"));
        items.add(new Item(R.mipmap.pay_wechat,"微信支付"));
        items.add(new Item(R.mipmap.pay_alipay,"平台支付"));
        adapter=new PayOrderTypeAdapter(this,R.layout.item_pay_order,items);
        actPayOrderRecycler.setAdapter(adapter);
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

    @OnClick({ R.id.act_pay_order_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_pay_order_pay:
                break;
        }
    }
}
