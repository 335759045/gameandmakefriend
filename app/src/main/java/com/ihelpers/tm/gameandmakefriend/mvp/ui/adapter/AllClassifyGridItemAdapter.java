package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.bean.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllClassifyGridItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Item> list;

    public AllClassifyGridItemAdapter(Context context, List<Item> list) {
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
            convertView = inflater.inflate(R.layout.fragment_main_grid1_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.fragmentMainGride1ItemName.setText(list.get(position).getName());
        holder.fragmentMainGride1ItemIcom.setBackgroundResource(list.get(position).getIcon());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.fragment_main_gride1_item_icom)
        ImageView fragmentMainGride1ItemIcom;
        @BindView(R.id.fragment_main_gride1_item_name)
        TextView fragmentMainGride1ItemName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
