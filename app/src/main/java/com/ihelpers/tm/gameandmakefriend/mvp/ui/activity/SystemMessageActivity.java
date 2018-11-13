package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.FourFragmentAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.SystemMessageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SystemMessageActivity extends BaseActivity {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    @BindView(R.id.act_recycler_no_L)
    LinearLayout actRecyclerNoL;
    SystemMessageAdapter adapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("系统消息");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_recycler;
    }

    @Override
    protected void setUpView() {
        List<Item> list=new ArrayList<>();
        list.add(new Item(1,""));
        list.add(new Item(2,""));
        list.add(new Item(3,""));
        list.add(new Item(4,""));
        adapter=new SystemMessageAdapter(this,R.layout.item_fragment_message,list);
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
        if(v==getbtn_left()){
            finish();
        }
    }
}
