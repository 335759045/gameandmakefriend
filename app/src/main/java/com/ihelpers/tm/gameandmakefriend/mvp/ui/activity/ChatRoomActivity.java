package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

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
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.Main_FourFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.Main_OneFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.Main_ThreeFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.Main_TwoFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class ChatRoomActivity extends BaseActivity {
    @BindView(R.id.include_main_smart)
    SmartTabLayout includeMainSmart;
    @BindView(R.id.include_main_viewpager)
    ViewPager includeMainViewpager;

    private LayoutInflater inflater;
    FragmentPagerItemAdapter adapter;
    final String[] tabTitles = {"热门", "派单", "声优", "电台", "情感"};
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("聊天室");
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
                .add(tabTitles[0], ChatRoom1Fragment.class)
                .add(tabTitles[1], ChatRoom2Fragment.class)
                .add(tabTitles[2], ChatRoom3Fragment.class)
                .add(tabTitles[3], ChatRoom4Fragment.class)
                .add(tabTitles[4], ChatRoom5Fragment.class)
                .create());
        includeMainViewpager.setAdapter(adapter);
        setSmartTitle();
        includeMainSmart.setViewPager(includeMainViewpager);
        includeMainViewpager.setOffscreenPageLimit(5);//设置ViewPage缓存界面数
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
