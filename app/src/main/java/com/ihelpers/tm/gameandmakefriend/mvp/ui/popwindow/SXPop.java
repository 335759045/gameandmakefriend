package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;


public class SXPop extends BasePop {
    private TagFlowLayout tag1;
    private TagFlowLayout tag2;
    private TextView sure;
    public SXPop(final Context context){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_sx, null);
        tag1= (TagFlowLayout) mMenuView.findViewById(R.id.pop_sx_tag1);
        tag2 =(TagFlowLayout) mMenuView.findViewById(R.id.pop_sx_tag2);
        sure=(TextView) mMenuView.findViewById(R.id.pop_sx_sure);
        List<String> s=new ArrayList<>();
        s.add("全部");
        s.add("男");
        s.add("女");
        tag1.setAdapter(new TagAdapter<String>(s)
        {
            @SuppressLint("SetTextI18n")
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) inflater.inflate(R.layout.tag_text,
                        tag1, false);
                tv.setText(s);
                return tv;
            }
        });
        List<String> ss=new ArrayList<>();
        ss.add("全部");
        ss.add("英雄联盟");
        ss.add("绝地求生");
        ss.add("声优聊天");
        ss.add("哄睡觉");
        ss.add("视频聊天");
        ss.add("唱歌");
        tag2.setAdapter(new TagAdapter<String>(ss)
        {
            @SuppressLint("SetTextI18n")
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) inflater.inflate(R.layout.tag_text,
                        tag2, false);
                tv.setText(s);
                return tv;
            }
        });

        this.setContentView(mMenuView);
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_sx_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_sx_L).getBottom();
                int y=(int) event.getY();
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(y<top){
                        dismiss();
                    }
                    if(y>btom){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }
}
