package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.RankAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RankActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    @BindView(R.id.act_rank_top_rank_rg)
    RadioGroup actRankTopRankRg;
    @BindView(R.id.act_rank_top_rank_rb1)
    RadioButton actRankTopRankRb1;
    @BindView(R.id.act_rank_top_rank_rb2)
    RadioButton actRankTopRankRb2;
    @BindView(R.id.act_rank_top_rank_rb3)
    RadioButton actRankTopRankRb3;
    @BindView(R.id.act_rank_top_rank1_head)
    ImageView actRankTopRank1Head;
    @BindView(R.id.act_rank_top_rank1_name)
    TextView actRankTopRank1Name;
    @BindView(R.id.act_rank_top_rank1_vip)
    TextView actRankTopRank1Vip;
    @BindView(R.id.act_rank_top_rank1_vip_L)
    LinearLayout actRankTopRank1VipL;
    @BindView(R.id.act_rank_top_rank1_hy_num)
    TextView actRankTopRank1HyNum;
    @BindView(R.id.act_rank_top_rank1_hy_L)
    LinearLayout actRankTopRank1HyL;
    @BindView(R.id.act_rank_top_rank1_sex_ig)
    ImageView actRankTopRank1SexIg;
    @BindView(R.id.act_rank_top_rank1_age)
    TextView actRankTopRank1Age;
    @BindView(R.id.act_rank_top_rank1_sex_L)
    LinearLayout actRankTopRank1SexL;
    @BindView(R.id.act_rank_top_rank1_add)
    TextView actRankTopRank1Add;
    @BindView(R.id.act_rank_top_rank1_L)
    LinearLayout actRankTopRank1L;
    @BindView(R.id.act_rank_top_rank2_head)
    ImageView actRankTopRank2Head;
    @BindView(R.id.act_rank_top_rank2_name)
    TextView actRankTopRank2Name;
    @BindView(R.id.act_rank_top_rank2_vip)
    TextView actRankTopRank2Vip;
    @BindView(R.id.act_rank_top_rank2_vip_L)
    LinearLayout actRankTopRank2VipL;
    @BindView(R.id.act_rank_top_rank2_hy_num)
    TextView actRankTopRank2HyNum;
    @BindView(R.id.act_rank_top_rank2_hy_L)
    LinearLayout actRankTopRank2HyL;
    @BindView(R.id.act_rank_top_rank2_sex_ig)
    ImageView actRankTopRank2SexIg;
    @BindView(R.id.act_rank_top_rank2_age)
    TextView actRankTopRank2Age;
    @BindView(R.id.act_rank_top_rank2_sex_L)
    LinearLayout actRankTopRank2SexL;
    @BindView(R.id.act_rank_top_rank2_add)
    TextView actRankTopRank2Add;
    @BindView(R.id.act_rank_top_rank2_L)
    LinearLayout actRankTopRank2L;
    @BindView(R.id.act_rank_top_rank3_head)
    ImageView actRankTopRank3Head;
    @BindView(R.id.act_rank_top_rank3_name)
    TextView actRankTopRank3Name;
    @BindView(R.id.act_rank_top_rank3_vip)
    TextView actRankTopRank3Vip;
    @BindView(R.id.act_rank_top_rank3_vip_L)
    LinearLayout actRankTopRank3VipL;
    @BindView(R.id.act_rank_top_rank3_hy_num)
    TextView actRankTopRank3HyNum;
    @BindView(R.id.act_rank_top_rank3_hy_L)
    LinearLayout actRankTopRank3HyL;
    @BindView(R.id.act_rank_top_rank3_sex_ig)
    ImageView actRankTopRank3SexIg;
    @BindView(R.id.act_rank_top_rank3_age)
    TextView actRankTopRank3Age;
    @BindView(R.id.act_rank_top_rank3_sex_L)
    LinearLayout actRankTopRank3SexL;
    @BindView(R.id.act_rank_top_rank3_add)
    TextView actRankTopRank3Add;
    @BindView(R.id.act_rank_top_rank3_L)
    LinearLayout actRankTopRank3L;
    @BindView(R.id.act_rank_top_L)
    LinearLayout actRankTopL;
    @BindView(R.id.act_rank_btom_L)
    LinearLayout actRankBtomL;
    @BindView(R.id.act_rank_top_recycler)
    RecyclerView actRankTopRecycler;

    private RankAdapter adapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("TOP排行榜");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_rank;
    }

    @Override
    protected void setUpView() {
        actRankTopRankRg.setOnCheckedChangeListener(this);
        List<Item> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Item(i+4,""));
        }
        adapter=new RankAdapter(this,R.layout.item_rank,list);
        actRankTopRecycler.setLayoutManager(new LinearLayoutManager(this));
        actRankTopRecycler.setAdapter(adapter);
        actRankTopRecycler.setFocusableInTouchMode(false); //设置不需要焦点
        actRankTopRecycler.requestFocus(); //设置焦点不需要
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

    @OnClick({R.id.act_rank_top_rank1_add, R.id.act_rank_top_rank2_add, R.id.act_rank_top_rank3_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_rank_top_rank1_add:
                break;
            case R.id.act_rank_top_rank2_add:
                break;
            case R.id.act_rank_top_rank3_add:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.act_rank_top_rank_rb1:
                actRankTopRankRb1.setTextSize(19);
                actRankTopRankRb2.setTextSize(15);
                actRankTopRankRb3.setTextSize(15);
                break;
            case R.id.act_rank_top_rank_rb2:
                actRankTopRankRb1.setTextSize(15);
                actRankTopRankRb2.setTextSize(19);
                actRankTopRankRb3.setTextSize(15);
                break;
            case R.id.act_rank_top_rank_rb3:
                actRankTopRankRb1.setTextSize(15);
                actRankTopRankRb2.setTextSize(15);
                actRankTopRankRb3.setTextSize(19);
                break;
        }
    }
}
