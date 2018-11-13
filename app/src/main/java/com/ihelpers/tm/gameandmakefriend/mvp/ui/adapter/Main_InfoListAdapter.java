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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main_InfoListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Item> list = new ArrayList<>();

    public Main_InfoListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<Item> list) {
        this.list = list;
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
            convertView = inflater.inflate(R.layout.item_main_list, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.itemMainListIg.setBackgroundResource(list.get(position).getIcon());
        holder.itemMainListName.setText(list.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_main_list_ig)
        ImageView itemMainListIg;
        @BindView(R.id.item_main_list_name)
        TextView itemMainListName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
