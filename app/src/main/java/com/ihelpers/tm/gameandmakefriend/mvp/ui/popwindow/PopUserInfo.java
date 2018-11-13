package com.ihelpers.tm.gameandmakefriend.mvp.ui.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BasePop;

public class PopUserInfo extends BasePop {
    private ImageView heard;
    private ImageView close;
    private TextView name;
    private TextView vip;
    private TextView number;
    private LinearLayout girt;
    private LinearLayout info;
    private Button btn_gz;
    private Button btn_tm;
    private Button btn_jy;
    public PopUserInfo(Context context , View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_user_info, null);
        heard= (ImageView) mMenuView.findViewById(R.id.pop_user_info_heard);
        close= (ImageView) mMenuView.findViewById(R.id.pop_user_info_close);
        name= (TextView) mMenuView.findViewById(R.id.pop_user_info_name);
        vip= (TextView) mMenuView.findViewById(R.id.pop_user_info_vip);
        number= (TextView) mMenuView.findViewById(R.id.pop_user_info_num);
        girt= (LinearLayout) mMenuView.findViewById(R.id.pop_user_info_gift_L);
        info= (LinearLayout) mMenuView.findViewById(R.id.pop_user_info_info_L);
        btn_gz=(Button) mMenuView.findViewById(R.id.pop_user_info_gz);
        btn_tm=(Button) mMenuView.findViewById(R.id.pop_user_info_tm);
        btn_jy=(Button) mMenuView.findViewById(R.id.pop_user_info_jy);

        close.setOnClickListener(onClick);
        girt.setOnClickListener(onClick);
        info.setOnClickListener(onClick);
        btn_gz.setOnClickListener(onClick);
        btn_tm.setOnClickListener(onClick);
        btn_jy.setOnClickListener(onClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_user_info_R).getTop();
                int btom = mMenuView.findViewById(R.id.pop_user_info_R).getBottom();
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
