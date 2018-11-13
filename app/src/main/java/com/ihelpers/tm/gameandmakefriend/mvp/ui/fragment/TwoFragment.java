package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.AllClassifyActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.ChatRoomActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.DTDetailActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.FBDTActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.RankActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.VideoChatActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ItemFragmentOneAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_OneFragmentAdapter1;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 再添加viewpager包裹Fragment会导致手机性能低下
 * 娱乐交友模式
 */
public class TwoFragment extends BaseMainFragment {
    @BindView(R.id.fragment_main_banner)
    Banner fragmentMainBanner;
    @BindView(R.id.fragment_main_one_recycler1)
    RecyclerView fragmentMainOneRecycler1;
    @BindView(R.id.fragment_main_one_ph_image1)
    ImageView fragmentMainOnePhImage1;
    @BindView(R.id.fragment_main_one_ph_image2)
    ImageView fragmentMainOnePhImage2;
    @BindView(R.id.fragment_main_one_ph_image3)
    ImageView fragmentMainOnePhImage3;
    @BindView(R.id.fragment_main_one_ph_R)
    RelativeLayout fragmentMainOnePhR;
    @BindView(R.id.fragment_two_rb1)
    RadioButton fragmentTwoRb1;
    @BindView(R.id.fragment_two_rb2)
    RadioButton fragmentTwoRb2;
    @BindView(R.id.fragment_two_rb3)
    RadioButton fragmentTwoRb3;
    @BindView(R.id.fragment_two_recycler)
    RecyclerView fragmentTwoRecycler;
    @BindView(R.id.fragment_two_fabu)
    ImageView fragmentTwoFabu;

    private Main_OneFragmentAdapter1 adapter1;
    ItemFragmentOneAdapter adapter;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_two;
    }

    @Override
    protected void setUpView() {
        initBanner();
        initGride1();
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "名字"));
        list.add(new Item(1, "名字"));
        list.add(new Item(1, "名字"));
        fragmentTwoRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ItemFragmentOneAdapter(getActivity(), R.layout.item_fragment_one, list);
        fragmentTwoRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent=new Intent(getActivity(),DTDetailActivity.class);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void initBanner() {
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        //设置banner样式
        fragmentMainBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        fragmentMainBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        fragmentMainBanner.setImages(images);
        //设置banner动画效果
        fragmentMainBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        fragmentMainBanner.isAutoPlay(true);
        //设置轮播时间
        fragmentMainBanner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        fragmentMainBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        fragmentMainBanner.start();
    }

    private void initGride1() {
        List<Item> names = new ArrayList<>();
        names.add(new Item(R.mipmap.ic_sy, "聊天室"));
        names.add(new Item(R.mipmap.ic_sj, "语音聊天"));
        names.add(new Item(R.mipmap.ic_jd, "视频聊天"));
        names.add(new Item(R.mipmap.ic_syfl, "查看全部"));
        fragmentMainOneRecycler1.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        adapter1 = new Main_OneFragmentAdapter1(getActivity(), R.layout.fragment_main_grid1_item, names);
        fragmentMainOneRecycler1.setAdapter(adapter1);
        adapter1.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(getActivity(), ChatRoomActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), VideoChatActivity.class);
                        intent1.putExtra("title","语音聊天");
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), VideoChatActivity.class);
                        intent2.putExtra("title","视频聊天");
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), AllClassifyActivity.class);
                        intent3.putExtra(Constans.SERVICEMANAGER_TO,1);
                        startActivity(intent3);
                        break;
                }
//                if(position==adapter1.getItemCount()-1){
//                    Intent intent=new Intent(getActivity(),AllClassifyActivity.class);
//                    startActivity(intent);
//                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        fragmentMainBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        fragmentMainBanner.stopAutoPlay();
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
//            GlideUtils.loadImageViewLoding(context, (String) path, imageView);
            Glide.with(context).load(path).into(imageView);
        }
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void getData() {

    }

    @OnClick({R.id.fragment_main_one_ph_R,R.id.fragment_two_fabu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_main_one_ph_R:
                Intent intent1=new Intent(getActivity(),RankActivity.class);
                startActivity(intent1);
                break;
            case R.id.fragment_two_fabu:
                Intent intent=new Intent(getActivity(),FBDTActivity.class);
                startActivity(intent);
                break;
        }
    }
}
