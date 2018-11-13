package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;
import com.ihelpers.tm.gameandmakefriend.mvp.contract.ApplyChatRoomContract;
import com.ihelpers.tm.gameandmakefriend.mvp.presenterImpl.ApplyChatRoomPresenterImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.ChoosePricePop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MorePop;
import com.ihelpers.tm.gameandmakefriend.utils.GlideUtil;
import com.ihelpers.tm.gameandmakefriend.utils.PictureUtils;
import com.ihelpers.tm.gameandmakefriend.utils.SystemHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class ApplyCRoomActivity extends BaseActivity<ApplyChatRoomContract.View, ApplyChatRoomPresenterImpl> implements ApplyChatRoomContract.View
    ,ChoosePricePop.OnPopItemListner{
    @BindView(R.id.act_apply_chat_room_example1)
    ImageView actApplyChatRoomExample1;
    @BindView(R.id.act_apply_chat_room_photo1)
    ImageView actApplyChatRoomPhoto1;
    @BindView(R.id.act_apply_chat_room_example2)
    ImageView actApplyChatRoomExample2;
    @BindView(R.id.act_apply_chat_room_photo2)
    ImageView actApplyChatRoomPhoto2;
    @BindView(R.id.act_apply_chat_room_choose1)
    TextView actApplyChatRoomChoose1;
    @BindView(R.id.act_apply_chat_room_choose2)
    TextView actApplyChatRoomChoose2;
    @BindView(R.id.act_apply_chat_room_desc)
    EditText actApplyChatRoomDesc;
    @BindView(R.id.act_apply_chat_room_number)
    TextView actApplyChatRoomNumber;
    @BindView(R.id.act_apply_chat_room_check)
    CheckBox actApplyChatRoomCheck;
    @BindView(R.id.act_apply_chat_room_tk)
    TextView actApplyChatRoomTk;
    @BindView(R.id.act_apply_chat_room_post)
    Button actApplyChatRoomPost;
    @BindView(R.id.act_apply_chat_room_sm_L)
    LinearLayout actApplyChatRoomSmL;
    @BindView(R.id.act_apply_chat_room_voice)
    TextView actApplyChatRoomVoice;
    @BindView(R.id.act_apply_chat_room_voice_L)
    LinearLayout actApplyChatRoomVoiceL;
    private MorePop choosePop;
    private String mPublicPhotoPath;
    private int imageType = 1;
    private int intentType;

    private ChoosePricePop choosePricePop;
    @Override
    protected ApplyChatRoomPresenterImpl createPresent() {
        return new ApplyChatRoomPresenterImpl(this, this);
    }

    @Override
    protected void initTitle() {
        intentType = getIntent().getIntExtra(Constans.MAIN_TO, 0);
        if (intentType == 1) {//表示聊天室
            setTitle("申请聊天室");
        } else if (intentType == 2) {
            setTitle("申请直播");
        } else if (intentType == 3) {
            setTitle("提交审核");
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_apply_chat_room;
    }

    @Override
    protected void setUpView() {
        choosePop = new MorePop(this, "相机", "相册", this);
        choosePricePop=new ChoosePricePop(this,this);
        choosePricePop.setListner(this);
    }

    @Override
    protected void setUpData() {
        if (intentType == 1) {//表示聊天室
            actApplyChatRoomChoose1.setText("选择房间分类");
            actApplyChatRoomSmL.setVisibility(View.VISIBLE);
        } else if (intentType == 2) {
            actApplyChatRoomChoose1.setText("选择直播分类");
            actApplyChatRoomSmL.setVisibility(View.GONE);
        } else if (intentType == 3) {
            actApplyChatRoomChoose1.setText("选择等级");
            actApplyChatRoomChoose2.setVisibility(View.VISIBLE);
            actApplyChatRoomVoiceL.setVisibility(View.VISIBLE);
            actApplyChatRoomDesc.setHint("简单介绍你的服务，以及方便接单时间段");
        }
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

    private void photo(int number) {
        PhotoPicker.builder()
                .setPhotoCount(number)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(true)
                .start(this, PhotoPicker.REQUEST_CODE);
    }

    private void camare() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断是否有相机应用
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            //创建临时图片文件
            File photoFile = null;
            try {
                photoFile = PictureUtils.createPublicImageFile();
                mPublicPhotoPath = photoFile.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置Action为拍照
            if (photoFile != null) {
                takePictureIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                //这里加入flag
                takePictureIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri photoURI = FileProvider.getUriForFile(this, "com.ihelpers.tm.gameandmakefriend.FileProvider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, 10000);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10000) {
            if (resultCode != Activity.RESULT_OK)
                return;
            Uri uri = Uri.parse(mPublicPhotoPath);
            ArrayList<String> photos = new ArrayList<>();
            String path = uri.getPath();
            photos.add(path);
            refreshImage(photos);
//            useLuban(photos);
        } else if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                refreshImage(photos);
//                useLuban(photos);
            }
        }
    }

    private void refreshImage(ArrayList<String> photos) {
        if (imageType == 1) {
            GlideUtil.loadImage(this, photos.get(0), actApplyChatRoomPhoto1);
        } else {
            GlideUtil.loadImage(this, photos.get(0), actApplyChatRoomPhoto2);
        }
    }

    @OnClick({R.id.act_apply_chat_room_photo1, R.id.act_apply_chat_room_photo2, R.id.act_apply_chat_room_choose1,R.id.act_apply_chat_room_choose2, R.id.act_apply_chat_room_tk, R.id.act_apply_chat_room_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_apply_chat_room_photo1:
                imageType = 1;
                mPresent.requestPermissions();
                break;
            case R.id.act_apply_chat_room_photo2:
                imageType = 2;
                mPresent.requestPermissions();
                break;
            case R.id.act_apply_chat_room_choose1:
                break;
            case R.id.act_apply_chat_room_choose2:
                choosePricePop.showAtLocation(this.findViewById(R.id.act_apply_chat_room_main),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, SystemHelper.getNavigationBarHeight(this));
                break;
            case R.id.act_apply_chat_room_tk:
                break;
            case R.id.act_apply_chat_room_post:
                break;
            case R.id.pop_more_share:
                camare();
                choosePop.dismiss();
                break;
            case R.id.pop_more_exit:
                photo(1);
                choosePop.dismiss();
                break;
            case R.id.pop_more_cancel:
                choosePop.dismiss();
                break;
            case R.id.pop_choose_price_sure:
                choosePricePop.dismiss();
                break;
        }
    }

    @Override
    public void requestPermissionsSuccess() {
        choosePop.showAtLocation(this.findViewById(R.id.act_apply_chat_room_main),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, SystemHelper.getNavigationBarHeight(this));
    }

    @Override
    public void onItemClick(int position) {

    }
}
