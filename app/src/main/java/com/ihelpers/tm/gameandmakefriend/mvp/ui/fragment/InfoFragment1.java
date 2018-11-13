package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseMainFragment;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;

import butterknife.BindView;

public class InfoFragment1 extends BaseMainFragment {
    @BindView(R.id.fragment_info1_city)
    TextView fragmentInfo1City;
    @BindView(R.id.fragment_info1_xz)
    TextView fragmentInfo1Xz;
    @BindView(R.id.fragment_info1_zy)
    TextView fragmentInfo1Zy;
    @BindView(R.id.fragment_info1_birthday)
    TextView fragmentInfo1Birthday;
    @BindView(R.id.fragment_info1_jj)
    TextView fragmentInfo1Jj;
    @BindView(R.id.fragment_info1_jd)
    TextView fragmentInfo1Jd;
    @BindView(R.id.fragment_info1_jb)
    TextView fragmentInfo1Jb;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_info1;
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
