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

public class SharePop extends BasePop {
    private LinearLayout wechat;
    private LinearLayout friend;
    private LinearLayout qq;
    private LinearLayout sina;
    public SharePop(Context context, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_share, null);
        wechat= (LinearLayout) mMenuView.findViewById(R.id.pop_share_wechat);
        friend= (LinearLayout) mMenuView.findViewById(R.id.pop_share_friend);
        qq= (LinearLayout) mMenuView.findViewById(R.id.pop_share_qq);
        sina= (LinearLayout) mMenuView.findViewById(R.id.pop_share_sina);

        wechat.setOnClickListener(onClick);
        friend.setOnClickListener(onClick);
        qq.setOnClickListener(onClick);
        sina.setOnClickListener(onClick);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_share_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_share_L).getBottom();
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
