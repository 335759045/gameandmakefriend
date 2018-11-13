package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.TalkPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.JNFWAdapter1;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.JNFWAdapter2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.rong.imkit.RongIM;

public class JNFWActivity extends BaseActivity {
    @BindView(R.id.avt_jnfw_image_heard)
    ImageView avtJnfwImageHeard;
    @BindView(R.id.avt_jnfw_name)
    TextView avtJnfwName;
    @BindView(R.id.avt_jnfw_vip_num)
    TextView avtJnfwVipNum;
    @BindView(R.id.avt_jnfw_hy_num)
    TextView avtJnfwHyNum;
    @BindView(R.id.avt_jnfw_sex_ig)
    ImageView avtJnfwSexIg;
    @BindView(R.id.avt_jnfw_age)
    TextView avtJnfwAge;
    @BindView(R.id.avt_jnfw_address)
    TextView avtJnfwAddress;
    @BindView(R.id.avt_jnfw_status)
    TextView avtJnfwStatus;
    @BindView(R.id.avt_jnfw_add)
    TextView avtJnfwAdd;
    @BindView(R.id.avt_jnfw_recycler1)
    RecyclerView avtJnfwRecycler1;
    @BindView(R.id.avt_jnfw_type)
    TextView avtJnfwType;
    @BindView(R.id.avt_jnfw_sf)
    TextView avtJnfwSf;
    @BindView(R.id.avt_jnfw_money)
    TextView avtJnfwMoney;
    @BindView(R.id.avt_jnfw_yy_time)
    TextView avtJnfwYyTime;
    @BindView(R.id.avt_jnfw_yuyin_icon)
    ImageView avtJnfwYuyinIcon;
    @BindView(R.id.avt_jnfw_yy_L)
    LinearLayout avtJnfwYyL;
    @BindView(R.id.avt_jnfw_content)
    TextView avtJnfwContent;
    @BindView(R.id.avt_jnfw_pl_num)
    TextView avtJnfwPlNum;
    @BindView(R.id.avt_jnfw_fen)
    TextView avtJnfwFen;
    @BindView(R.id.avt_jnfw_recycler2)
    RecyclerView avtJnfwRecycler2;
    @BindView(R.id.avt_jnfw_call)
    TextView avtJnfwCall;
    @BindView(R.id.avt_jnfw_buy)
    TextView avtJnfwBuy;

    private JNFWAdapter1 adapter1;
    private JNFWAdapter2 adapter2;
    private TalkPop talkPop;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("技能服务");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_jnfw;
    }

    @Override
    protected void setUpView() {
        talkPop=new TalkPop(this,this);
        List<Item> itemLis = new ArrayList<>();
        itemLis.add(new Item(R.mipmap.ic_content, ""));
        itemLis.add(new Item(R.mipmap.ic_content, ""));
        adapter1 = new JNFWAdapter1(this, R.layout.item_image, itemLis);
        avtJnfwRecycler1.setLayoutManager(new GridLayoutManager(this, itemLis.size()));
        avtJnfwRecycler1.setAdapter(adapter1);
        avtJnfwRecycler2.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.mipmap.ix_tx, "名字1"));
        items.add(new Item(R.mipmap.ix_tx, "名字2"));
        adapter2 = new JNFWAdapter2(this, R.layout.item_comment, items);
        avtJnfwRecycler2.setAdapter(adapter2);
        //回复监听
        adapter2.setItemTalKListner(new JNFWAdapter2.ItemTalKListner() {
            @Override
            public void itemTotalk(int position) {
                talkPop.showAtLocation(JNFWActivity.this.findViewById(R.id.act_jnfw_main),
                        Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
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


    @OnClick({R.id.avt_jnfw_image_heard, R.id.avt_jnfw_add, R.id.avt_jnfw_call, R.id.avt_jnfw_buy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.avt_jnfw_image_heard:
                break;
            case R.id.avt_jnfw_add:
                break;
            case R.id.avt_jnfw_call:
                RongIM.getInstance().startPrivateChat(this,"1","名字");
                break;
            case R.id.avt_jnfw_buy:
                Intent intent=new Intent(this,PosOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
