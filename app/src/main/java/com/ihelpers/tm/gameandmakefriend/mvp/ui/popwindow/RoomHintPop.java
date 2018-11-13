package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

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

public class RoomHintPop extends BasePop {
    private TextView title;
    private TextView sure;
    public RoomHintPop(Context context,String s1,String s2, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_hint, null);
        title= (TextView) mMenuView.findViewById(R.id.pop_hint_title);
        sure= (TextView) mMenuView.findViewById(R.id.pop_hint_ok);

        title.setText(s1);
        sure.setText(s2);
        sure.setOnClickListener(onClick);
        title.setOnClickListener(onClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_hint_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_hint_L).getBottom();
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
