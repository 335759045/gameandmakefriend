package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.Gravity;
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
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.RoomHintPop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.ChatRoomDetailActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ChatRoomAdapter;
import com.ihelpers.tm.gameandmakefriend.wedget.PullScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BaseChatRoomFragment extends BaseMainFragment {
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
    ChatRoomAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    private RoomHintPop hintPop;
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
    //此方法只执行一次
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //只要activity 不销毁,此方法 就只调用一次
        super.onActivityCreated(savedInstanceState);
        hintPop=new RoomHintPop(getActivity(),"该聊天室已关闭","我知道了",this);
        myRecyclerView.setEmptyView(pullView);
        myRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myRecyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        myRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
        myRecyclerView.setHeaderViewColor(R.color.red, R.color.gray_text, R.color.white);
        myRecyclerView.setFooterViewColor(R.color.red, R.color.gray_text, R.color.white);
        myRecyclerView.setHasFixedSize(true);
        List<Item> list=new ArrayList<>();
        list.add(new Item(1,""));
        list.add(new Item(2,""));
        list.add(new Item(3,""));
        list.add(new Item(4,""));
        list.add(new Item(2,""));
        list.add(new Item(3,""));
        adapter=new ChatRoomAdapter(getActivity(),R.layout.item_chat_room,list);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        myRecyclerView.setAdapter(mLRecyclerViewAdapter);
        //设置头部加载颜色
        pullView.setHeaderViewColor(R.color.red, R.color.gray_text, R.color.white);
        pullView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        pullView.setRefreshListener(new PullScrollView.RefreshListener() {
            @Override
            public void onRefresh() {
                getRoomList();
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
                if(position==0){
                    hintPop.showAtLocation(getActivity().findViewById(R.id.fragment_chat_room_main),
                            Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
                }else{
                    Intent intent=new Intent(getActivity(),ChatRoomDetailActivity.class);
                    startActivity(intent);
                }
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
    public void getRoomList() {

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
