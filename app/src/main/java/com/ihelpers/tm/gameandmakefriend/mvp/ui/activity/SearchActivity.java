package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.bean.Item;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.SearchResultAdapter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.act_search_tag)
    TagFlowLayout actSearchTag;
    @BindView(R.id.act_search_clean)
    TextView actSearchClean;
    LayoutInflater inflater;
    @BindView(R.id.act_search_L)
    LinearLayout actSearchL;
    @BindView(R.id.act_recycler_rv)
    RecyclerView actRecyclerRv;
    SearchResultAdapter searchResultAdapter;
    InputMethodManager imm;
    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        inflater = this.getLayoutInflater();
        setTitle("");
        getEt_search().setVisibility(View.VISIBLE);
        getEt_search().setHint("房间名称/id、用户名字/id");
        getbtn_right().setText("搜索");
        getbtn_right().setBackgroundResource(R.drawable.shape_search_bg);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_search;
    }

    @Override
    protected void setUpView() {
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        List<String> ss = new ArrayList<>();
        ss.add("搜索1");
        ss.add("英ss地ss求生");
        ss.add("声优聊天");
        ss.add("哄睡ss觉");
        ss.add("视频聊天sss");
        ss.add("唱歌");
        actSearchTag.setAdapter(new TagAdapter<String>(ss) {
            @SuppressLint("SetTextI18n")
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) inflater.inflate(R.layout.tag_text,
                        actSearchTag, false);
                tv.setText(s);
                return tv;
            }
        });
        actRecyclerRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setUpData() {
        getEt_search().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    getSearchDel().setVisibility(View.VISIBLE);
                }else{
                    getSearchDel().setVisibility(View.GONE);
                }
            }
        });
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

    @OnClick({R.id.act_search_clean})
    public void onClick(View view) {
        if (imm != null && imm.isActive()) {
            //如果开启
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
        }
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_title_main_right:
                actSearchL.setVisibility(View.GONE);
                actRecyclerRv.setVisibility(View.VISIBLE);
                List<Item> list=new ArrayList<>();
                list.add(new Item(1,"名字1"));
                list.add(new Item(1,"名字2"));
                searchResultAdapter=new SearchResultAdapter(this,R.layout.include_user,list);
                actRecyclerRv.setAdapter(searchResultAdapter);

                break;
            case R.id.act_title_main_search_clean:
                getEt_search().setText("");
                actSearchL.setVisibility(View.VISIBLE);
                actRecyclerRv.setVisibility(View.GONE);
                break;
            case R.id.act_search_clean:
                break;
        }
    }
}
