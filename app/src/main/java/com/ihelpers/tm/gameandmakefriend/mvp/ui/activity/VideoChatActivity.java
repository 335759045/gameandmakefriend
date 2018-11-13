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
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ChatRoom1Fragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ChatRoom2Fragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ChatRoom3Fragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ChatRoom4Fragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ChatRoom5Fragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.VideoChatFragment1;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.VideoChatFragment2;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.VideoChatFragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoChatActivity extends BaseActivity {
    @BindView(R.id.include_main_smart)
    SmartTabLayout includeMainSmart;
    @BindView(R.id.include_main_viewpager)
    ViewPager includeMainViewpager;

    private LayoutInflater inflater;
    FragmentPagerItemAdapter adapter;
    final String[] tabTitles = {"推荐", "优质新人", "特价专区"};
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle(getIntent().getStringExtra("title"));
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_one;
    }

    @Override
    protected void setUpView() {
        inflater = getLayoutInflater();
        setAdapter();
    }
    private void setAdapter() {
        adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(tabTitles[0], VideoChatFragment1.class)
                .add(tabTitles[1], VideoChatFragment2.class)
                .add(tabTitles[2], VideoChatFragment3.class)
                .create());
        includeMainViewpager.setAdapter(adapter);
        setSmartTitle();
        includeMainSmart.setViewPager(includeMainViewpager);
        includeMainViewpager.setOffscreenPageLimit(3);//设置ViewPage缓存界面数
    }
    private void setSmartTitle() {
        includeMainSmart.setCustomTabView(new SmartTabLayout.TabProvider() {
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
        if(v==getbtn_left()){
            finish();
        }
    }
}
