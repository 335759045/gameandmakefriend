package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PosOrderActivity extends BaseActivity {
    @BindView(R.id.avt_jnfw_image_heard)
    ImageView avtJnfwImageHeard;
    @BindView(R.id.avt_jnfw_name)
    TextView avtJnfwName;
    @BindView(R.id.avt_jnfw_vip_num)
    TextView avtJnfwVipNum;
    @BindView(R.id.avt_jnfw_hy_num)
    TextView avtJnfwHyNum;
    @BindView(R.id.include_user_address_L)
    LinearLayout includeUserAddressL;
    @BindView(R.id.avt_jnfw_sex_ig)
    ImageView avtJnfwSexIg;
    @BindView(R.id.avt_jnfw_age)
    TextView avtJnfwAge;
    @BindView(R.id.avt_jnfw_address)
    TextView avtJnfwAddress;
    @BindView(R.id.avt_jnfw_status)
    TextView avtJnfwStatus;
    @BindView(R.id.avt_jnfw_add)
    TextView avtJnfwAdd;
    @BindView(R.id.act_post_fw)
    TextView actPostFw;
    @BindView(R.id.act_post_sub)
    TextView actPostSub;
    @BindView(R.id.act_post_num)
    EditText actPostNum;
    @BindView(R.id.act_post_add)
    TextView actPostAdd;
    @BindView(R.id.act_post_price)
    TextView actPostPrice;
    @BindView(R.id.act_post_QQ)
    EditText actPostQQ;
    @BindView(R.id.act_post_phone)
    EditText actPostPhone;
    @BindView(R.id.act_post_wechat)
    EditText actPostWechat;
    @BindView(R.id.act_post_order_desc)
    EditText actPostOrderDesc;
    @BindView(R.id.act_post_order_desc_num)
    TextView actPostOrderDescNum;
    @BindView(R.id.act_post_order_post)
    Button actPostOrderPost;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("下单");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_post_order;
    }

    @Override
    protected void setUpView() {
        includeUserAddressL.setVisibility(View.GONE);
        avtJnfwAdd.setVisibility(View.GONE);
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

    @OnClick({R.id.act_post_fw, R.id.act_post_sub, R.id.act_post_add, R.id.act_post_order_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_post_fw:
                break;
            case R.id.act_post_sub:
                break;
            case R.id.act_post_add:
                break;
            case R.id.act_post_order_post:
                Intent intent = new Intent(this, PayOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
