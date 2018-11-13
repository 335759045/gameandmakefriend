package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ServiceManagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ServiceManagerActivity extends BaseActivity {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    @BindView(R.id.act_recycler_no_L)
    LinearLayout actRecyclerNoL;
    ServiceManagerAdapter adapter;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("服务管理");
        getbtn_right().setText("添加服务");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_recycler;
    }

    @Override
    protected void setUpView() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1, "王者荣耀"));
        itemList.add(new Item(1, "绝地求生"));
        adapter = new ServiceManagerAdapter(this, R.layout.item_service_manager, itemList);
        actRecyclerRv.setLayoutManager(new LinearLayoutManager(this));
        actRecyclerRv.setAdapter(adapter);
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

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == getbtn_left()) {
            finish();
        } else if (v == getbtn_right()) {
            Intent intent=new Intent(this,AllClassifyActivity.class);
            intent.putExtra(Constans.SERVICEMANAGER_TO,2);
            startActivity(intent);
        }
    }
}
