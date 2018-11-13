package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.AllClassifyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllClassifyActivity extends BaseActivity {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    AllClassifyAdapter adapter;
    private int intenType;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        intenType=getIntent().getIntExtra(Constans.SERVICEMANAGER_TO,0);
        if(intenType==1){
            setTitle("全部分类");
        }else if(intenType==2){
            setTitle("添加服务");
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_recycler;
    }

    @Override
    protected void setUpView() {
        List<Item> list=new ArrayList<>();
        list.add(new Item(getResources().getColor(R.color.red),"线上娱乐"));
        list.add(new Item(getResources().getColor(R.color.green),"线上游戏"));
        list.add(new Item(getResources().getColor(R.color.blue),"聊天室"));
        actRecyclerRv.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AllClassifyAdapter(this,R.layout.item_all_classify,list);
        actRecyclerRv.setAdapter(adapter);
        adapter.setGridItemLister(new AllClassifyAdapter.GridItemLister() {
            @Override
            public void onItemClick(int Gposition, int cposition) {
                if(intenType==1){
                }else if(intenType==2){
                    Intent intent=new Intent(AllClassifyActivity.this,ApplyCRoomActivity.class);
                    intent.putExtra(Constans.MAIN_TO,3);
                    startActivity(intent);
                }
            }
        });
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
        }
    }
}
