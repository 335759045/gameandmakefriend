package com.ihelpers.tm.gameandmakefriend.mvp.presenterImpl;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.contract.FBDTContract;
import com.ihelpers.tm.gameandmakefriend.mvp.modelImpl.FBDTModelImpl;

public class FBDTPresenterImpl extends BasePresentImpl<FBDTContract.View> implements FBDTContract.Presenter,FBDTContract.Model.modelListner{
    private Context context;
    private FBDTContract.Model model;
    private FBDTContract.View view;
    private FBDTContract.Model.modelListner listner;

    public FBDTPresenterImpl(Context context, FBDTContract.View view) {
        this.context = context;
        this.view = view;
        model=new FBDTModelImpl(context,this);
    }

    @Override
    public void fetch() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void requestPermissions() {
        model.requestPermissions();
    }

    @Override
    public void requestPermissionsSuccess() {
        view.requestPermissionsSuccess();
    }
}
