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

public class MessagePop extends BasePop {
    private TextView left;
    private TextView right;
    private TextView title;
    public MessagePop(Context context, String s, String s1, String s2, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_message, null);
        left= (TextView) mMenuView.findViewById(R.id.pop_message_btn_left);
        right= (TextView) mMenuView.findViewById(R.id.pop_message_btn_right);
        title= (TextView) mMenuView.findViewById(R.id.pop_message_btn_title);

        left.setOnClickListener(onClick);
        right.setOnClickListener(onClick);
        title.setText(s);
        left.setText(s1);
        right.setText(s2);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_message_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_message_L).getBottom();
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
