package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;

public class TalkPop extends BasePop {
    private EditText content;
    private Button sure;
    public TalkPop(Context context, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_talk, null);
        content= (EditText) mMenuView.findViewById(R.id.pop_talk_edit);
        sure= (Button) mMenuView.findViewById(R.id.pop_talk_sure);
        sure.setOnClickListener(onClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_talk_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_talk_L).getBottom();
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
