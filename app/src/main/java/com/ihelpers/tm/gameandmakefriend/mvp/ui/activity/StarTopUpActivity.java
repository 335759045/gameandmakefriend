package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.PayOrderTypeAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.StarTopUpAdapterGrid;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StarTopUpActivity extends BaseActivity {
    @BindView(R.id.act_star_top_up_num)
    TextView actStarTopUpNum;
    @BindView(R.id.act_star_top_up_recycler1)
    RecyclerView actStarTopUpRecycler1;
    @BindView(R.id.act_star_top_up_recycler2)
    RecyclerView actStarTopUpRecycler2;
    @BindView(R.id.act_star_top_up_sure)
    Button actStarTopUpSure;

    private PayOrderTypeAdapter adapter;
    private StarTopUpAdapterGrid starTopUpAdapter;
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
        return R.layout.act_star_top_up;
    }

    @Override
    protected void setUpView() {
        actStarTopUpRecycler1.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items=new ArrayList<>();
        items.add(new Item(R.mipmap.pay_alipay,"支付宝支付"));
        items.add(new Item(R.mipmap.pay_wechat,"微信支付"));
        adapter=new PayOrderTypeAdapter(this,R.layout.item_pay_order,items);
        actStarTopUpRecycler1.setAdapter(adapter);

        List<Item> list=new ArrayList<>();
        list.add(new Item(6,"600"));
        list.add(new Item(66,"6600"));
        list.add(new Item(166,"16600"));
        list.add(new Item(666,"66600"));
        list.add(new Item(1666,"166600"));
        list.add(new Item(3666,"366600"));
        actStarTopUpRecycler2.setLayoutManager(new GridLayoutManager(this,2));
        starTopUpAdapter=new StarTopUpAdapterGrid(this,R.layout.item_star_top_up_grid,list);
        actStarTopUpRecycler2.setAdapter(starTopUpAdapter);
        starTopUpAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                starTopUpAdapter.setItemPosition(position);
                starTopUpAdapter.notifyDataSetChanged();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
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

    @OnClick({R.id.act_star_top_up_num, R.id.act_star_top_up_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_star_top_up_sure:

                break;
        }
    }
}
