package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThreeFragmentAdapter2 extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public ThreeFragmentAdapter2(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
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
            convertView = inflater.inflate(R.layout.item_threefragment, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
//        GlideUtils.loadImageViewYJ(context,);
        Glide.with(context).load(R.mipmap.ic_content).into(holder.itemThreefragmentImage);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_threefragment_image)
        ImageView itemThreefragmentImage;
        @BindView(R.id.item_threefragment_name)
        TextView itemThreefragmentName;
        @BindView(R.id.item_threefragment_num)
        TextView itemThreefragmentNum;
        @BindView(R.id.item_threefragment_title)
        TextView itemThreefragmentTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
