package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.InfoFragment1;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.InfoFragment2;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.InfoFragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends BaseActivity {
    @BindView(R.id.act_info_bg)
    ImageView actInfoBg;
    @BindView(R.id.act_info_head)
    ImageView actInfoHead;
    @BindView(R.id.act_info_nicName)
    TextView actInfoNicName;
    @BindView(R.id.act_info_id)
    TextView actInfoId;
    @BindView(R.id.act_info_sex_ig)
    ImageView actInfoSexIg;
    @BindView(R.id.act_info_age)
    TextView actInfoAge;
    @BindView(R.id.act_info_address)
    TextView actInfoAddress;
    @BindView(R.id.act_info_gz_num)
    TextView actInfoGzNum;
    @BindView(R.id.act_info_gz_L)
    LinearLayout actInfoGzL;
    @BindView(R.id.act_info_fans_num)
    TextView actInfoFansNum;
    @BindView(R.id.act_info_fans_L)
    LinearLayout actInfoFansL;
    @BindView(R.id.act_info_zan_num)
    TextView actInfoZanNum;
    @BindView(R.id.act_info_zan_L)
    LinearLayout actInfoZanL;
    @BindView(R.id.act_info_tab)
    SmartTabLayout actInfoTab;
    @BindView(R.id.act_info_viewpager)
    ViewPager actInfoViewpager;
    @BindView(R.id.act_info_add)
    TextView actInfoAdd;
    @BindView(R.id.act_info_chat)
    LinearLayout actInfoChat;
    @BindView(R.id.act_info_botm_L)
    LinearLayout actInfoBotmL;

    private LayoutInflater inflater;
    FragmentPagerItemAdapter adapter;
    final String[] tabTitles = {"资料", "我的服务", "动态"};

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("个人资料");
        getbtn_right().setText("编辑");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_info;
    }

    @Override
    protected void setUpView() {
        inflater = getLayoutInflater();
        setType();
    }

    private void setType() {
        adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(tabTitles[0], InfoFragment1.class)
                .add(tabTitles[1], InfoFragment2.class)
                .add(tabTitles[2], InfoFragment3.class)
                .create());
        actInfoViewpager.setAdapter(adapter);
        setSmartTitle();
        actInfoTab.setViewPager(actInfoViewpager);
        actInfoViewpager.setOffscreenPageLimit(3);//设置ViewPage缓存界面数
    }

    private void setSmartTitle() {
        actInfoTab.setCustomTabView(new SmartTabLayout.TabProvider() {
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

    @OnClick({R.id.act_info_gz_L, R.id.act_info_fans_L, R.id.act_info_zan_L,R.id.act_info_add,R.id.act_info_chat,R.id.act_info_botm_L})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_title_main_right:
                Intent intent=new Intent(this,InfoEditActivity.class);
                startActivity(intent);
                break;
            case R.id.act_info_gz_L:
                break;
            case R.id.act_info_fans_L:
                break;
            case R.id.act_info_zan_L:
                break;
            case R.id.act_info_add:
                break;
            case R.id.act_info_chat:
                break;
            case R.id.act_info_botm_L:
                break;
        }
    }
}
