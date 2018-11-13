package com.ihelpers.tm.gameandmakefriend.mvp.modelImpl;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.ihelpers.tm.gameandmakefriend.mvp.contract.ApplyChatRoomContract;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class ApplyChatRoomModelImpl implements ApplyChatRoomContract.Model {
    private String[] pm=new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE};
    private int i=0;
    private Context context;
    private ApplyChatRoomContract.Model.modelListner listner;

    public ApplyChatRoomModelImpl(Context context, modelListner listner) {
        this.context = context;
        this.listner = listner;
    }

    @SuppressLint("CheckResult")
    @Override
    public void requestPermissions() {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) context);
        rxPermissions
                .requestEach(pm)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            i++;
                            if(i==pm.length){
                                listner.requestPermissionsSuccess();
                                i=0;//重新赋值
                            }
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Toast.makeText(context, "用户拒绝了权限可能导致部分功能无法使用", Toast.LENGTH_SHORT).show();
                            Log.e("-----TAG", permission.name + " 非不再询问拒绝");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            Toast.makeText(context, "用户拒绝了权限可能导致部分功能无法使用", Toast.LENGTH_SHORT).show();
                            Log.e("-----TAG", permission.name + " 完全拒绝.");
                        }
                    }
                });
    }
}
