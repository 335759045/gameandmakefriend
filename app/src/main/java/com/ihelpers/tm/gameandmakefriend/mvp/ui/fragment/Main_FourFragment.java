package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.JNFWActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_TwoFragmentAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.PXPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.SXPop;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Main_FourFragment extends BaseMainFragment {
    @BindView(R.id.fragment_main_two_px_L)
    LinearLayout fragmentMainTwoPxL;
    @BindView(R.id.fragment_main_two_sx_L)
    LinearLayout fragmentMainTwoSxL;
    @BindView(R.id.fragment_main_two_title)
    LinearLayout fragmentMainTwoTitle;
    @BindView(R.id.fragment_main_two_recycler)
    RecyclerView fragmentMainTwoRecycler;
    @BindView(R.id.fragment_main_two_sx_text)
    TextView fragmentMainTwoSxText;

    Main_TwoFragmentAdapter adapter;
    PXPop pxPop;
    SXPop sxPop;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_two;
    }

    @Override
    protected void setUpView() {
        EventBus.getDefault().register(this);
        pxPop = new PXPop(getActivity());
        sxPop = new SXPop(getActivity());
        List<String> s = new ArrayList<>();
        s.add("");
        s.add("");
        s.add("");
        s.add("");
        fragmentMainTwoRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter = new Main_TwoFragmentAdapter(getActivity(), R.layout.item_main_fragment, s);
        fragmentMainTwoRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent = new Intent(getActivity(), JNFWActivity.class);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void getData() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(Object userEvent) {
        if (userEvent instanceof String) {
            fragmentMainTwoSxText.setText((String)userEvent);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.fragment_main_two_px_L, R.id.fragment_main_two_sx_L})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_main_two_px_L:
                pxPop.showAsDropDown(fragmentMainTwoTitle);
                break;
            case R.id.fragment_main_two_sx_L:
                sxPop.showAsDropDown(fragmentMainTwoTitle);
                break;
        }
    }
}
