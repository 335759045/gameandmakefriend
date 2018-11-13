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

public class PopApply extends BasePop {
    private TextView apply;
    private TextView cancel;
    public PopApply(Context context,String s, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_apply, null);
        apply= (TextView) mMenuView.findViewById(R.id.pop_apply_apply);
        cancel= (TextView) mMenuView.findViewById(R.id.pop_apply_cancel);

        apply.setText(s);
        apply.setOnClickListener(onClick);
        cancel.setOnClickListener(onClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_apply_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_apply_L).getBottom();
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
