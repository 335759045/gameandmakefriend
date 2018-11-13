package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class OneFragment extends BaseMainFragment {
    @BindView(R.id.include_main_smart)
    SmartTabLayout includeMainSmart;
    @BindView(R.id.include_main_viewpager)
    ViewPager includeMainViewpager;

    private LayoutInflater inflater;
    FragmentPagerItemAdapter adapter;
    final String[] tabTitles = {"推荐", "优质新人", "特价专区", "找陪玩"};
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_one;
    }

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void setUpView() {
        EventBus.getDefault().register(this);
        inflater = getActivity().getLayoutInflater();
        setType();
    }
    private void setType() {
        adapter = new FragmentPagerItemAdapter(getActivity().getSupportFragmentManager(), FragmentPagerItems.with(getActivity())
                .add(tabTitles[0], Main_OneFragment.class)
                .add(tabTitles[1], Main_TwoFragment.class)
                .add(tabTitles[2], Main_ThreeFragment.class)
                .add(tabTitles[3], Main_FourFragment.class)
                .create());
        includeMainViewpager.setAdapter(adapter);
        setSmartTitle();
        includeMainSmart.setViewPager(includeMainViewpager);
        includeMainViewpager.setOffscreenPageLimit(4);//设置ViewPage缓存界面数
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
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //定义处理接收的方法
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(Object userEvent){
        if(userEvent instanceof String){
            includeMainViewpager.setCurrentItem(3);
        }
    }
    @Override
    protected void setUpData() {

    }

    @Override
    protected void getData() {

    }
}
