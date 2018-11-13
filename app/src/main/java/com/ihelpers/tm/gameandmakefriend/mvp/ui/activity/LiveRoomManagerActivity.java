package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.LiveRoomManagerFragment1;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.LiveRoomManagerFragment2;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveRoomManagerActivity extends BaseActivity {
    @BindView(R.id.act_live_room_manager_tab)
    SmartTabLayout actLiveRoomManagerTab;
    @BindView(R.id.act_live_room_manager_pager)
    ViewPager actLiveRoomManagerPager;
    @BindView(R.id.act_live_room_manager_number)
    TextView actLiveRoomManagerNumber;

    private LayoutInflater inflater;
    FragmentPagerItemAdapter adapter;
    final String[] tabTitles = {"黑名单", "禁言名单"};

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("直播间管理");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_live_room_manager;
    }

    @Override
    protected void setUpView() {
        inflater = getLayoutInflater();
        setAdapter();
    }

    private void setAdapter() {
        adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(tabTitles[0], LiveRoomManagerFragment1.class)
                .add(tabTitles[1], LiveRoomManagerFragment2.class)
                .create());
        actLiveRoomManagerPager.setAdapter(adapter);
        setSmartTitle();
        actLiveRoomManagerTab.setViewPager(actLiveRoomManagerPager);
        actLiveRoomManagerPager.setOffscreenPageLimit(2);//设置ViewPage缓存界面数
    }

    private void setSmartTitle() {
        actLiveRoomManagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.layout_navigation_top_item, container, false);
                TextView titleView = (TextView) view.findViewById(R.id.txt_title);
                titleView.setText(tabTitles[position % tabTitles.length]);
                return view;
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
