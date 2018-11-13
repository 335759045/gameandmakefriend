package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.YLZBListAdapter;
import com.ihelpers.tm.gameandmakefriend.wedget.PullScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class YLZBListActivity extends BaseActivity {
    @BindView(R.id.fragment_chat_room)
    LRecyclerView myRecyclerView;
    @BindView(R.id.not_data)
    ImageView notData;
    @BindView(R.id.tv_empty_tip)
    TextView tvEmptyTip;
    @BindView(R.id.pull_view)
    PullScrollView pullView;
    YLZBListAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle(getIntent().getStringExtra(Constans.THREEFRAGMENT_TO));
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_chat_room;
    }

    @Override
    protected void setUpView() {
        List<Item> items=new ArrayList<>();
        items.add(new Item(1,""));
        items.add(new Item(1,""));
        items.add(new Item(1,""));
        items.add(new Item(1,""));
        adapter=new YLZBListAdapter(this,R.layout.item_threefragment,items);
        myRecyclerView.setEmptyView(pullView);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        myRecyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        myRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
        myRecyclerView.setHeaderViewColor(R.color.red, R.color.gray_text, R.color.white);
        myRecyclerView.setFooterViewColor(R.color.red, R.color.gray_text, R.color.white);
        myRecyclerView.setHasFixedSize(true);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        myRecyclerView.setAdapter(mLRecyclerViewAdapter);
        //设置头部加载颜色
        pullView.setHeaderViewColor(R.color.red, R.color.gray_text, R.color.white);
        pullView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        pullView.setRefreshListener(new PullScrollView.RefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        myRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
//                if (adapter != null) {
//                    mLRecyclerViewAdapter.notifyDataSetChanged();
//                    page = 1;
//                    getRoomList();
//                }
            }
        });
        myRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
//                if (hasNextPage) {
//                    page++;
//                    getOrderList();
//                } else {
//                    myRecyclerView.setNoMore(true);
//                }
            }
        });
        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(YLZBListActivity.this,LiveRoomActivity.class);
                startActivity(intent);
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
