package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageGridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> images = new ArrayList<>();

    public void setImages(List<String> images) {
        this.images = images;
    }

    public ImageGridAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (images.size() >= 9) {
            return 9;
        }
        return images.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
//        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_choose_photo, null);
            holder=new ViewHolder(convertView);
//            convertView.setTag(holder);
//        }else{
//            holder= (ViewHolder) convertView.getTag();
//        }

        if (position!=images.size()) {
            GlideUtil.loadImage(context, images.get(position), holder.itemChoosePhoto);

        }else{
            holder.itemChoosePhoto.setImageResource(R.mipmap.photo_add);
            if (position == 9) {
                holder.itemChoosePhoto.setVisibility(View.GONE);
            }
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_choose_photo)
        ImageView itemChoosePhoto;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
