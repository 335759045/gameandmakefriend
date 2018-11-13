package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MessagePop;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow.MorePop;
import com.ihelpers.tm.gameandmakefriend.mvp.contract.FBDTContract;
import com.ihelpers.tm.gameandmakefriend.mvp.presenterImpl.FBDTPresenterImpl;
import com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter.ImageGridAdapter;
import com.ihelpers.tm.gameandmakefriend.utils.PictureUtils;
import com.ihelpers.tm.gameandmakefriend.utils.SystemHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

public class FBDTActivity extends BaseActivity<FBDTContract.View,FBDTPresenterImpl>implements FBDTContract.View {
    @BindView(R.id.act_fbdt_content)
    EditText actFbdtContent;
    @BindView(R.id.act_fbdt_grid)
    GridView actFbdtGrid;
    @BindView(R.id.act_fbdt_address)
    TextView actFbdtAddress;
    @BindView(R.id.act_fbdt_address_del)
    ImageView actFbdtAddressDel;
    private ImageGridAdapter imageGridAdapter;
    private MorePop choosePop;
    private MessagePop messagePop;

    private String mPublicPhotoPath;
    private ArrayList<String> photo = new ArrayList<>();//添加图片需要的图片路径
    private int imagePosition;
    @Override
    protected FBDTPresenterImpl createPresent() {
        return new FBDTPresenterImpl(this,this);
    }

    @Override
    protected void initTitle() {
        setTitle("发布动态");
        getbtn_right().setText("发表");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_fbdt;
    }

    @Override
    protected void setUpView() {
        choosePop=new MorePop(this,"相机","相册",this);
        messagePop=new MessagePop(this, "是否确认发布？", "同意", "拒绝", this);
        imageGridAdapter = new ImageGridAdapter(this);
        imageGridAdapter.setImages(photo);
        actFbdtGrid.setAdapter(imageGridAdapter);
        actFbdtGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imagePosition=position;
                if(position == photo.size()){
                    mPresent.requestPermissions();
                }else{
                    //预览
                    PhotoPreview.builder()
                            .setPhotos(photo)
                            .setCurrentItem(position)
                            .setShowDeleteButton(false)
                            .start(FBDTActivity.this);
                }
            }
        });
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
        photo.addAll(photos);
        imageGridAdapter.setImages(photo);
        imageGridAdapter.notifyDataSetChanged();
    }

    @Override
    protected void setUpData() {

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

    @OnClick({ R.id.act_fbdt_address_del})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_title_main_right:
                messagePop.showAtLocation(this.findViewById(R.id.act_fbdt_main),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, SystemHelper.getNavigationBarHeight(this));
                break;
            case R.id.act_fbdt_address_del:
                break;
            case R.id.pop_more_share:
                camare();
                choosePop.dismiss();
                break;
            case R.id.pop_more_exit:
                photo(9);
                choosePop.dismiss();
                break;
            case R.id.pop_more_cancel:
                choosePop.dismiss();
                break;
        }
    }

    @Override
    public void requestPermissionsSuccess() {
        choosePop.showAtLocation(this.findViewById(R.id.act_fbdt_main),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, SystemHelper.getNavigationBarHeight(this));
    }
}
