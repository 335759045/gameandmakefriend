package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.JNFWActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.PXPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.SXPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_TwoFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.OnClick;

public class Main_ThreeFragment extends BaseMainFragment {
    @BindView(R.id.fragment_main_two_px_L)
    LinearLayout fragmentMainTwoPxL;
    @BindView(R.id.fragment_main_two_sx_L)
    LinearLayout fragmentMainTwoSxL;
    @BindView(R.id.fragment_main_two_title)
    LinearLayout fragmentMainTwoTitle;
    @BindView(R.id.fragment_main_two_recycler)
    RecyclerView fragmentMainTwoRecycler;

    Main_TwoFragmentAdapter adapter;
    PXPop pxPop;
    SXPop sxPop;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_two;
    }

    @Override
    protected void setUpView() {
        pxPop = new PXPop(getActivity());
        sxPop= new SXPop(getActivity());
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
