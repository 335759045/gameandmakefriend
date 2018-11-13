package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemImageAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Item> list = new ArrayList<>();

    public ItemImageAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
            convertView = inflater.inflate(R.layout.item_image_fragment, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
//        Glide.with(context).load(list.get(position).getIcon()).into(holder.itemImageFragmentIg);
        holder.itemImageFragmentIg.setImageResource(R.mipmap.ic_content);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_image_fragment_ig)
        ImageView itemImageFragmentIg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
