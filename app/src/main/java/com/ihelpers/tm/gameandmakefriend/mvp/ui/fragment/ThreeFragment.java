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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.AllClassifyActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.LiveRoomActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.RankActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.activity.YLZBListActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ItemFragmentOneAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_OneFragmentAdapter1;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.Main_OneFragmentAdapter2ItemAdapter;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ThreeFragmentAdapter2;
import com.ihelpers.tm.gameandmakefriend.wedget.MyGridView;
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

public class ThreeFragment extends BaseMainFragment {
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
    @BindView(R.id.fragment_three_recycler2)
    MyGridView fragmentThreeRecycler2;

    private Main_OneFragmentAdapter1 adapter1;
    ThreeFragmentAdapter2 adapter2;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_three;
    }

    @Override
    protected void setUpView() {
        initBanner();
        initGride();
        List<Item> list=new ArrayList<>();
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));
        list.add(new Item(1,"名字"));

        adapter2=new ThreeFragmentAdapter2(getActivity());
        fragmentThreeRecycler2.setAdapter(adapter2);
        fragmentThreeRecycler2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),LiveRoomActivity.class);
                startActivity(intent);
            }
        });
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
    private void initGride() {
        final List<Item> names = new ArrayList<>();
        names.add(new Item(R.mipmap.ic_sy,"娱乐直播"));
        names.add(new Item(R.mipmap.ic_sj,"颜值直播"));
        names.add(new Item(R.mipmap.ic_jd,"声优直播"));
        names.add(new Item(R.mipmap.ic_sj,"电台直播"));
        names.add(new Item(R.mipmap.ic_jd,"附近直播"));
        names.add(new Item(R.mipmap.ic_syfl,"查看全部"));
        fragmentMainOneRecycler1.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        adapter1 = new Main_OneFragmentAdapter1(getActivity(), R.layout.fragment_main_grid1_item, names);
        fragmentMainOneRecycler1.setAdapter(adapter1);
        adapter1.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if(position==adapter1.getItemCount()-1){
                    Intent intent=new Intent(getActivity(),AllClassifyActivity.class);
                    intent.putExtra(Constans.SERVICEMANAGER_TO,1);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(getActivity(),YLZBListActivity.class);
                    intent.putExtra(Constans.THREEFRAGMENT_TO,names.get(position).getName());
                    startActivity(intent);
                }
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

    @OnClick({R.id.fragment_main_one_ph_R})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_main_one_ph_R:
                Intent intent1=new Intent(getActivity(),RankActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
