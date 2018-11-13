package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.LiveRoomManagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LiveRoomManagerFragment1 extends BaseMainFragment {
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    LiveRoomManagerFragmentAdapter adapter;
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
        List<Item> items=new ArrayList<>();
        items.add(new Item(1,""));
        items.add(new Item(1,""));
        items.add(new Item(1,""));
        adapter=new LiveRoomManagerFragmentAdapter(getActivity(),1,R.layout.item_live_room_manager,items);
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
