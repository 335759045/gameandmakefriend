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

public class LiveRoomInfoPop extends BasePop {
    private ImageView head;
    private ImageView close;
    private TextView nicName;
    private TextView vip;
    private ImageView sex_ig;
    private TextView age;
    private TextView id;
    private TextView address;
    private TextView qm;
    private TextView gz;
    private TextView fans;
    private TextView outStar;
    private TextView getStar;
    private LinearLayout gn_L;
    private TextView jy;
    private TextView lh;
    private Button cancel;
    private TextView sl;
    private LinearLayout home;
    private LinearLayout btm_L;
    public LiveRoomInfoPop(Context context,int type, View.OnClickListener onClick){
        super(context);
        mMenuView = inflater.inflate(R.layout.pop_live_room_info, null);

        close= (ImageView) mMenuView.findViewById(R.id.pop_live_room_info_close);
        nicName= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_name);
        vip= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_vip);
        sex_ig= (ImageView) mMenuView.findViewById(R.id.pop_live_room_info_sex_ig);
        age= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_age);
        id= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_id);
        address= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_address);
        qm= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_qm);
        gz= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_gz);
        fans= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_fans);
        outStar= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_out_star);
        getStar= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_get_star);
        gn_L= (LinearLayout) mMenuView.findViewById(R.id.pop_live_room_info_gn_L);
        jy= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_jy);
        lh= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_lh);
        cancel= (Button) mMenuView.findViewById(R.id.pop_live_room_info_cancel);
        sl= (TextView) mMenuView.findViewById(R.id.pop_live_room_info_sl);
        home= (LinearLayout) mMenuView.findViewById(R.id.pop_live_room_info_home);
        btm_L= (LinearLayout) mMenuView.findViewById(R.id.pop_live_room_info_btm_L);
        head= (ImageView) mMenuView.findViewById(R.id.pop_live_room_info_heard);

        if(type==1){//他人用户
            gn_L.setVisibility(View.GONE);
        }else if(type==2){//直播间观众

        }else if(type==3){//主播资料
            gn_L.setVisibility(View.GONE);
            btm_L.setVisibility(View.GONE);
            cancel.setText("直播间管理");
        }

        close.setOnClickListener(onClick);
        jy.setOnClickListener(onClick);
        lh.setOnClickListener(onClick);
        gz.setOnClickListener(onClick);
        sl.setOnClickListener(onClick);
        home.setOnClickListener(onClick);
        cancel.setOnClickListener(onClick);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int top = mMenuView.findViewById(R.id.pop_live_room_info_L).getTop();
                int btom = mMenuView.findViewById(R.id.pop_live_room_info_L).getBottom();
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
