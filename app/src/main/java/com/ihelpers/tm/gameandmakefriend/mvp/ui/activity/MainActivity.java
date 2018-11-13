package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.commom.LoginOut;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_InfoListAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.FourFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.OneFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.ThreeFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment.TwoFragment;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.ChangeMSPop;
import com.ihelpers.tm.gameandmakefriend.utils.SystemHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.v4_drawerlayout_frame)
    FrameLayout v4DrawerlayoutFrame;
    @BindView(R.id.v4_listview)
    ListView v4Listview;
    @BindView(R.id.v4_drawerlayout)
    DrawerLayout v4Drawerlayout;
    @BindView(R.id.include_main_ig_ms)
    ImageView includeMainIgMs;
    @BindView(R.id.include_main_tv_mg)
    TextView includeMainTvMg;
    @BindView(R.id.include_main_ms_L)
    LinearLayout includeMainMsL;
    @BindView(R.id.include_main_ig_qh)
    ImageView includeMainIgQh;
    @BindView(R.id.include_main_qh_L)
    LinearLayout includeMainQhL;
    @BindView(R.id.include_main_ig_mg)
    ImageView includeMainIgMg;
    @BindView(R.id.include_main_mg_L)
    RelativeLayout includeMainMgL;
    @BindView(R.id.include_main_message)
    TextView includeMainMessage;
    @BindView(R.id.include_main_message_num)
    TextView includeMainMessageNum;
    @BindView(R.id.include_main_ig_left)
    ImageView includeMainIgLeft;
    @BindView(R.id.include_main_ig_heard)
    ImageView includeMainIgHeard;
    @BindView(R.id.include_main_ig_search)
    ImageView includeMainIgSearch;
    @BindView(R.id.include_main_ig_listner)
    ImageView includeMainIgListner;
    @BindView(R.id.fragment_controller)
    FrameLayout fragmentController;
    @BindView(R.id.act_main_head)
    ImageView actMainHead;
    @BindView(R.id.act_main_name)
    TextView actMainName;
    @BindView(R.id.act_main_id)
    TextView actMainId;
    @BindView(R.id.act_main_money)
    TextView actMainMoney;
    @BindView(R.id.act_main_star_num)
    TextView actMainStarNum;
    @BindView(R.id.act_main_wallet)
    ImageView actMainWallet;
    @BindView(R.id.act_main_L)
    LinearLayout actMainL;
    @BindView(R.id.act_main_info_L)
    LinearLayout actMainInfoL;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;

    private Main_InfoListAdapter listAdapter;
    ChangeMSPop pop;

    int i1 = 0;
    int i2 = 0;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }


    @Override
    protected void initTitle() {
        hideTitleView();
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemHelper.setMargins(v4DrawerlayoutFrame, 0, Constans.P_STATUSBAR_HEIGHT, 0, 0);
            actMainL.setPadding(0, Constans.P_STATUSBAR_HEIGHT, 0, 0);
        }
        pop = new ChangeMSPop(this, this);
        fragmentManager = getSupportFragmentManager();
        showFragment(0);

        List<Item> list = new ArrayList<>();
        list.add(new Item(R.mipmap.main_order, "我的订单"));
        list.add(new Item(R.mipmap.main_kf, "服务管理"));
        list.add(new Item(R.mipmap.main_lts, "聊天室管理"));
        list.add(new Item(R.mipmap.main_zbgl, "直播管理"));
        list.add(new Item(R.mipmap.main_czrw, "成长任务"));
        list.add(new Item(R.mipmap.main_xtsz, "系统设置"));
        listAdapter = new Main_InfoListAdapter(this);
        listAdapter.setList(list);
        v4Listview.setAdapter(listAdapter);

        v4Drawerlayout.openDrawer(Gravity.LEFT);
        showDrawerLayout();

        v4Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, OrderListActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, ServiceManagerActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    i1++;
                    if (i1 == 1) {
                        Intent intent = new Intent(MainActivity.this, ApplyCRoomActivity.class);
                        intent.putExtra(Constans.MAIN_TO, 1);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, EditRoomActivity.class);
                        intent.putExtra(Constans.MAIN_TO, 1);
                        startActivity(intent);
                    }
                } else if (position == 3) {
                    i2++;
                    if (i2 == 1) {
                        Intent intent = new Intent(MainActivity.this, ApplyCRoomActivity.class);
                        intent.putExtra(Constans.MAIN_TO, 2);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, EditRoomActivity.class);
                        intent.putExtra(Constans.MAIN_TO, 2);
                        startActivity(intent);
                    }
                } else if (position == 4) {
                    Intent intent=new Intent(MainActivity.this,GrowthTaskActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(MainActivity.this, SystemSetActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 显示fragment
     */
    private void showFragment(int index) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);/*想要显示一个fragment,先隐藏所有fragment，防止重叠*/
        switch (index) {
            case 0:
                /*如果fragment1已经存在则将其显示出来*/
                if (oneFragment != null)
                    fragmentTransaction.show(oneFragment);
                    /*否则是第一次切换则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add*/
                else {
                    oneFragment = new OneFragment();
                    fragmentTransaction.add(R.id.fragment_controller, oneFragment);
                }
                break;
            case 1:
                if (twoFragment != null)
                    fragmentTransaction.show(twoFragment);
                else {
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.fragment_controller, twoFragment);
                }
                break;
            case 2:
                if (threeFragment != null)
                    fragmentTransaction.show(threeFragment);
                else {
                    threeFragment = new ThreeFragment();
                    fragmentTransaction.add(R.id.fragment_controller, threeFragment);
                }
                break;
            case 3:
                if (fourFragment != null)
                    fragmentTransaction.show(fourFragment);
                else {
                    fourFragment = new FourFragment();
                    fragmentTransaction.add(R.id.fragment_controller, fourFragment);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏fragment
     */
    private void hideFragment(FragmentTransaction ft) {
        if (oneFragment != null)
            ft.hide(oneFragment);
        if (twoFragment != null)
            ft.hide(twoFragment);
        if (threeFragment != null)
            ft.hide(threeFragment);
        if (fourFragment != null)
            ft.hide(fourFragment);
    }


    private void showDrawerLayout() {
        if (!v4Drawerlayout.isDrawerOpen(Gravity.LEFT)) {
            v4Drawerlayout.openDrawer(Gravity.LEFT);
        } else {
            v4Drawerlayout.closeDrawer(Gravity.LEFT);
        }
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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private int messageI=0;
    private boolean isMessage=false;
    @OnClick({R.id.include_main_ms_L, R.id.include_main_qh_L, R.id.include_main_mg_L, R.id.include_main_ig_left,R.id.act_main_info_L,
            R.id.include_main_ig_heard, R.id.include_main_ig_search, R.id.include_main_ig_listner, R.id.act_main_wallet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.include_main_ms_L:
                switchMessage(messageI);
                showFragment(messageI);
                break;
            case R.id.include_main_qh_L:
                pop.showAtLocation(this.findViewById(R.id.v4_drawerlayout_frame),
                        Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
                break;
            case R.id.include_main_mg_L:
                switchMessage(3);
                showFragment(3);
                break;
            case R.id.pop_ms_pw:
                switchMessage(0);
                showFragment(0);
                pop.dismiss();
                break;
            case R.id.pop_ms_jy:
                switchMessage(1);
                showFragment(1);
                pop.dismiss();
                break;
            case R.id.pop_ms_zb:
                switchMessage(2);
                showFragment(2);
                pop.dismiss();
                break;
            case R.id.include_main_ig_left:
                showDrawerLayout();
                break;
            case R.id.include_main_ig_heard:
                showDrawerLayout();
                break;
            case R.id.include_main_ig_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.include_main_ig_listner:
                if(isMessage){//消息界面状态
                    Intent intentM=new Intent(this,TXLActivity.class);
                    startActivity(intentM);
                }else{
                    Intent intent1=new Intent(this,LoginActivity.class);
                    startActivity(intent1);
                }
                break;
            case R.id.act_main_wallet:
                Intent intent1 = new Intent(this, WalletActivity.class);
                startActivity(intent1);
                break;
            case R.id.act_main_info_L:
                Intent intentInfo=new Intent(this,InfoActivity.class);
                startActivity(intentInfo);
                break;
        }
    }

    private void switchMessage(int i) {
        if(i==3){
            includeMainMessage.setTextColor(getResources().getColor(R.color.red));
//            includeMainTvMg.setTextColor(getResources().getColor(R.color.gray_text));
            includeMainIgMg.setImageResource(R.mipmap.main_message);
            includeMainIgSearch.setVisibility(View.GONE);
            includeMainIgListner.setImageResource(R.mipmap.txl);
            isMessage=true;
//            if(messageI==1){
//                includeMainIgMs.setImageResource(R.mipmap.main_pw2);
//            }else if(messageI==2){
//                includeMainIgMs.setImageResource(R.mipmap.main_jy2);
//            }else if(messageI==3){
//                includeMainIgMs.setImageResource(R.mipmap.main_zb2);
//            }
        }else{
            isMessage=false;
            includeMainMessage.setTextColor(getResources().getColor(R.color.gray_tab));
            includeMainIgMg.setImageResource(R.mipmap.main_message2);
            includeMainIgSearch.setVisibility(View.VISIBLE);
            includeMainIgListner.setImageResource(R.mipmap.main_right);
            includeMainTvMg.setTextColor(getResources().getColor(R.color.red));
            if(i==0){
                includeMainTvMg.setText("陪玩模式");
                includeMainIgMs.setImageResource(R.mipmap.main_pw);
            }else if(i==1){
                includeMainTvMg.setText("娱乐交友");
                includeMainIgMs.setImageResource(R.mipmap.main_jy);
            }else if(i==2){
                includeMainTvMg.setText("直播模式");
                includeMainIgMs.setImageResource(R.mipmap.main_zb);
            }
            messageI=i;
        }
    }
}
