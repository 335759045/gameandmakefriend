package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.utils.GlideUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DTGridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public DTGridAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 6;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_choose_photo, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(R.mipmap.ic_content).into(holder.itemChoosePhoto);
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
