package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.SystemMessageActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.FourFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.Unbinder;

public class FourFragment extends BaseMainFragment {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    @BindView(R.id.act_recycler_no_L)
    LinearLayout actRecyclerNoL;
    Unbinder unbinder;
    FourFragmentAdapter adapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
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
        adapter=new FourFragmentAdapter(getActivity(),R.layout.item_fragment_message,list);
        actRecyclerRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        actRecyclerRv.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent=new Intent(getActivity(),SystemMessageActivity.class);
                startActivity(intent);
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
    protected void getData() {

    }

}
