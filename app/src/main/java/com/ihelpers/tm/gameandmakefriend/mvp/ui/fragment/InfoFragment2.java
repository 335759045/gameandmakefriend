package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

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
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.FragmentInfo2Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InfoFragment2 extends BaseMainFragment {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    @BindView(R.id.act_recycler_no_L)
    LinearLayout actRecyclerNoL;

    FragmentInfo2Adapter adapter;
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
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));

        adapter=new FragmentInfo2Adapter(getActivity(),R.layout.item_fragment_info2,list);
        actRecyclerRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        actRecyclerRv.setAdapter(adapter);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void getData() {

    }
}
