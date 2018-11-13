package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class OrderDetailActivity extends BaseActivity {
    @BindView(R.id.act_order_head)
    ImageView actOrderHead;
    @BindView(R.id.act_order_nicName)
    TextView actOrderNicName;
    @BindView(R.id.act_order_vip)
    TextView actOrderVip;
    @BindView(R.id.act_order_sex_ig)
    ImageView actOrderSexIg;
    @BindView(R.id.act_order_age)
    TextView actOrderAge;
    @BindView(R.id.act_order_info_L)
    LinearLayout actOrderInfoL;
    @BindView(R.id.act_order_name)
    TextView actOrderName;
    @BindView(R.id.act_order_num)
    TextView actOrderNum;
    @BindView(R.id.act_order_price)
    TextView actOrderPrice;
    @BindView(R.id.act_order_desc)
    TextView actOrderDesc;
    @BindView(R.id.act_order_id)
    TextView actOrderId;
    @BindView(R.id.act_order_xd_time)
    TextView actOrderXdTime;
    @BindView(R.id.act_order_zf_time)
    TextView actOrderZfTime;
    @BindView(R.id.act_order_jd_time)
    TextView actOrderJdTime;
    @BindView(R.id.act_order_qx_time)
    TextView actOrderQxTime;
    @BindView(R.id.act_order_qr_time)
    TextView actOrderQrTime;
    @BindView(R.id.act_order_service_L)
    LinearLayout actOrderServiceL;
    @BindView(R.id.act_order_call)
    TextView actOrderCall;

    private int orderType;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("订单详情");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_order_detail;
    }

    @Override
    protected void setUpView() {
        orderType=getIntent().getIntExtra(Constans.ORDERLIST_TO,0);
        switch (orderType){
            case 1:
                actOrderCall.setText("确认订单");
                break;
            case 2:
                actOrderCall.setText("联系TA");
                break;
            case 3:
                actOrderCall.setText("去支付");
                break;
            case 4:
                actOrderCall.setText("评价");
                break;
            case 5:
                actOrderCall.setText("取消订单");
                break;
        }
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

    @OnClick({R.id.act_order_info_L, R.id.act_order_service_L, R.id.act_order_call})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_order_info_L:
                break;
            case R.id.act_order_service_L:
                break;
            case R.id.act_order_call:
                switch (orderType){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        Intent intent=new Intent(this,EvaluateActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        break;
                }
                break;
        }
    }
}
