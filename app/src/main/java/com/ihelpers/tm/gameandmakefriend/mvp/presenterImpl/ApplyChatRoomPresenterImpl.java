package com.ihelpers.tm.gameandmakefriend.mvp.presenterImpl;

import android.content.Context;

import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.contract.ApplyChatRoomContract;
import com.ihelpers.tm.gameandmakefriend.mvp.modelImpl.ApplyChatRoomModelImpl;

public class ApplyChatRoomPresenterImpl extends BasePresentImpl<ApplyChatRoomContract.View> implements ApplyChatRoomContract.Presenter,ApplyChatRoomContract.Model.modelListner{
    private Context context;
    private ApplyChatRoomContract.Model model;
    private ApplyChatRoomContract.View view;

    public ApplyChatRoomPresenterImpl(Context context, ApplyChatRoomContract.View view) {
        this.context = context;
        this.view = view;
        model=new ApplyChatRoomModelImpl(context,this);
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
