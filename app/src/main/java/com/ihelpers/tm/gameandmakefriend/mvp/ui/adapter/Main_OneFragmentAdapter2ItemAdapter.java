package com.ihelpers.tm.gameandmakefriend.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ihelpers.tm.gameandmakefriend.R;

public class Main_OneFragmentAdapter2ItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public Main_OneFragmentAdapter2ItemAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
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
        if(convertView==null){
            convertView=inflater.inflate(R.layout.item_main_fragment,null);
        }
        return convertView;
    }
}
