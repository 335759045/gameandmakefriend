package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ChooseUserAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChooseUserActivity extends BaseActivity {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;

    ChooseUserAdapter adapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("选择要抱上麦的用户");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_recycler;
    }

    @Override
    protected void setUpView() {
        actRecyclerRv.setLayoutManager(new LinearLayoutManager(this));
        List<Item> list=new ArrayList<>();
        list.add(new Item(1,"用户1"));
        list.add(new Item(1,"用户2"));
        list.add(new Item(1,"用户3"));
        adapter=new ChooseUserAdapter(this,R.layout.include_user,list);
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
        if(v==getbtn_left()){
            finish();
        }
    }
}
