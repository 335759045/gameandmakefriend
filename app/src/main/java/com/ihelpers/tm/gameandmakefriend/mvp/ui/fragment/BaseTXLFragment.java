package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.BaseTXLAdapter;
import com.ihelpers.tm.gameandmakefriend.wedget.PullScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BaseTXLFragment extends BaseMainFragment {
    @BindView(R.id.fragment_chat_room)
    LRecyclerView myRecyclerView;
    @BindView(R.id.not_data)
    ImageView notData;
    @BindView(R.id.tv_empty_tip)
    TextView tvEmptyTip;
    @BindView(R.id.pull_view)
    PullScrollView pullView;

    public boolean isPrepared;
    //标志当前页面是否可见
    public boolean isVisible;
    public int clueType;
    private BaseTXLAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_chat_room;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myRecyclerView.setEmptyView(pullView);
        myRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myRecyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        myRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
        myRecyclerView.setHeaderViewColor(R.color.red, R.color.gray_text, R.color.white);
        myRecyclerView.setFooterViewColor(R.color.red, R.color.gray_text, R.color.white);
        myRecyclerView.setHasFixedSize(true);

        List<Item> list=new ArrayList<>();
        list.add(new Item(1,""));
        list.add(new Item(1,""));
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new BaseTXLAdapter(getActivity(),R.layout.item_txl,list);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        myRecyclerView.setAdapter(mLRecyclerViewAdapter);
        //设置头部加载颜色
        pullView.setHeaderViewColor(R.color.red, R.color.gray_text, R.color.white);
        pullView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        pullView.setRefreshListener(new PullScrollView.RefreshListener() {
            @Override
            public void onRefresh() {
                getDataList();
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
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //懒加载
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }
    protected void onVisible() {
        lazyLoad();
    }

    protected void lazyLoad() {

    }

    protected void onInvisible() {

    }
    public void setClueType(int type) {
        clueType = type;
    }
    public void getDataList() {

    }
    @Override
    protected void setUpView() {
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void getData() {

    }
}
