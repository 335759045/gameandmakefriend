package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.DTDetailPLAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.DTGridAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.LiveRoomHeadAdapter;
import com.ihelpers.tm.gameandmakefriend.wedget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DTDetailActivity extends BaseActivity {
    @BindView(R.id.act_dt_detail_image)
    ImageView actDtDetailImage;
    @BindView(R.id.act_dt_detail_name)
    TextView actDtDetailName;
    @BindView(R.id.act_dt_detail_vip)
    TextView actDtDetailVip;
    @BindView(R.id.act_dt_detail_vip_L)
    LinearLayout actDtDetailVipL;
    @BindView(R.id.act_dt_detail_hy_num)
    TextView actDtDetailHyNum;
    @BindView(R.id.act_dt_detail_hy_L)
    LinearLayout actDtDetailHyL;
    @BindView(R.id.act_dt_detail_sex)
    ImageView actDtDetailSex;
    @BindView(R.id.act_dt_detail_age)
    TextView actDtDetailAge;
    @BindView(R.id.act_dt_detail_sex_L)
    LinearLayout actDtDetailSexL;
    @BindView(R.id.act_dt_detail_desc)
    TextView actDtDetailDesc;
    @BindView(R.id.act_dt_detail_grid)
    MyGridView actDtDetailGrid;
    @BindView(R.id.act_dt_detail_date)
    TextView actDtDetailDate;
    @BindView(R.id.act_dt_detail_zan_num)
    TextView actDtDetailZanNum;
    @BindView(R.id.act_dt_detail_content)
    EditText actDtDetailContent;
    @BindView(R.id.act_dt_detail_post)
    TextView actDtDetailPost;
    @BindView(R.id.act_dt_detail_recy_head)
    RecyclerView actDtDetailRecyHead;
    @BindView(R.id.act_dt_detail_recy_pl)
    RecyclerView actDtDetailRecyPl;
    private DTGridAdapter imageGridAdapter;
    private LiveRoomHeadAdapter headAdapter;
    private DTDetailPLAdapter plAdapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("动态详情");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_dt_detail;
    }

    @Override
    protected void setUpView() {
        imageGridAdapter = new DTGridAdapter(this);
        actDtDetailGrid.setAdapter(imageGridAdapter);

        LinearLayoutManager ms = new LinearLayoutManager(this);
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        actDtDetailRecyHead.setLayoutManager(ms);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Item(1, ""));
        }
        headAdapter = new LiveRoomHeadAdapter(this, R.layout.item_image_40, list);
        actDtDetailRecyHead.setAdapter(headAdapter);

        actDtDetailRecyPl.setLayoutManager(new LinearLayoutManager(this));
        plAdapter=new DTDetailPLAdapter(this,R.layout.item_pl,list);
        actDtDetailRecyPl.setAdapter(plAdapter);
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

    @OnClick({R.id.act_dt_detail_zan_num, R.id.act_dt_detail_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_dt_detail_zan_num:
                break;
            case R.id.act_dt_detail_post:
                break;
        }
    }
}
