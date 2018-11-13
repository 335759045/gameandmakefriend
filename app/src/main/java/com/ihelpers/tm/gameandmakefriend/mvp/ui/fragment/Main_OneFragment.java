package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.AllClassifyActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.JNFWActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.RankActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_OneFragmentAdapter1;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_OneFragmentAdapter2;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import app.my.br.com.baserecyclerview.adapter.MultiItemTypeAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Main_OneFragment extends BaseMainFragment {
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
    @BindView(R.id.fragment_main_recycler2)
    RecyclerView fragmentMainRecycler2;

    private Main_OneFragmentAdapter1 adapter1;
    private Main_OneFragmentAdapter2 adapter2;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_one;
    }

    @Override
    protected void setUpView() {
        initBanner();
        initGride1();
    }

    private void initGride1() {
        final List<Item> names = new ArrayList<>();
        names.add(new Item(R.mipmap.ic_sy, "声优聊天"));
        names.add(new Item(R.mipmap.ic_sj, "哄睡觉"));
        names.add(new Item(R.mipmap.ic_jd, "绝地求生"));
        names.add(new Item(R.mipmap.ic_wz, "王者荣耀"));
        names.add(new Item(R.mipmap.ic_hx, "穿越火线"));
        names.add(new Item(R.mipmap.ic_cg, "唱歌"));
        names.add(new Item(R.mipmap.id_yx, "英雄联盟"));
        names.add(new Item(R.mipmap.ic_cj, "刺激战场"));
        names.add(new Item(R.mipmap.ic_syjd, "声音鉴定"));
        names.add(new Item(R.mipmap.ic_syfl, "所有分类"));
        fragmentMainOneRecycler1.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        adapter1 = new Main_OneFragmentAdapter1(getActivity(), R.layout.fragment_main_grid1_item, names);
        fragmentMainOneRecycler1.setAdapter(adapter1);
        adapter1.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (position == adapter1.getItemCount() - 1) {
                    Intent intent = new Intent(getActivity(), AllClassifyActivity.class);
                    intent.putExtra(Constans.SERVICEMANAGER_TO,1);
                    startActivity(intent);
                }else{
                    EventBus.getDefault().post(names.get(position).getName());
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        List<String> rec = new ArrayList<>();
        rec.add("热门陪玩");
        rec.add("线下指导");
        fragmentMainRecycler2.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter2 = new Main_OneFragmentAdapter2(getActivity(), R.layout.fragment_main_recycler_item, rec);
        fragmentMainRecycler2.setAdapter(adapter2);
        adapter2.setGridItemOnclicListner(new Main_OneFragmentAdapter2.GridItemOnclicListner() {
            @Override
            public void onItemClicl(int position) {
                Intent intent = new Intent(getActivity(), JNFWActivity.class);
                startActivity(intent);
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

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void getData() {

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
    @OnClick({R.id.fragment_main_one_ph_R})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.fragment_main_one_ph_R:
                Intent intent=new Intent(getActivity(),RankActivity.class);
                startActivity(intent);
                break;
        }
    }
}
