package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;

public class RoomMasterPop extends BasePop {
    private ImageView heard;
    private TextView vip;
    private TextView apply;
    private TextView yes;
    private TextView no;

    public RoomMasterPop(Context context, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_room_master, null);
        heard= (ImageView) mMenuView.findViewById(R.id.pop_room_master_heard);
        vip= (TextView) mMenuView.findViewById(R.id.pop_room_master_vip);
        apply= (TextView) mMenuView.findViewById(R.id.pop_room_master_apply);
        yes= (TextView) mMenuView.findViewById(R.id.pop_room_master_y);
        no= (TextView) mMenuView.findViewById(R.id.pop_room_master_n);

        yes.setOnClickListener(onClick);
        no.setOnClickListener(onClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_room_master_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_room_master_L).getBottom();
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
