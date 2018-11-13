package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;

public class ChangeMSPop extends BasePop {
    private LinearLayout pw;
    private LinearLayout jy;
    private LinearLayout zb;
    public ChangeMSPop(Context context, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_ms, null);
        pw= (LinearLayout) mMenuView.findViewById(R.id.pop_ms_pw);
        jy= (LinearLayout) mMenuView.findViewById(R.id.pop_ms_jy);
        zb= (LinearLayout) mMenuView.findViewById(R.id.pop_ms_zb);
        pw.setOnClickListener(onClick);
        jy.setOnClickListener(onClick);
        zb.setOnClickListener(onClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_L).getBottom();
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
