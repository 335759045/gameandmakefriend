package com.ihelpers.tm.gameandmakefriend.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.codeutils.utils.TimeUtils;
import com.ihelpers.tm.gameandmakefriend.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PikerUtils {
    private Context context;
    private OptionsPickerView optionsPickerView;
    private TimePickerView timePickerView;

    private PikerCaseData pikerCaseData;
    private PikerCaseTime pikerCaseTime;

    public PikerUtils(Context context) {
        this.context = context;
    }

    public void setPikerCaseData(PikerCaseData pikerCaseData) {
        this.pikerCaseData = pikerCaseData;
    }

    public void setPikerCaseTime(PikerCaseTime pikerCaseTime) {
        this.pikerCaseTime = pikerCaseTime;
    }
    /**
     * 条件选择器
     * @param textView
     * @param list
     * @param viewId
     * @return
     */
    public OptionsPickerView initPiker(final TextView textView, final List<String> list, final int viewId){
        optionsPickerView = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = list.get(options1);
                textView.setText(tx);
                swichData(viewId,options1);
            }
        }).setContentTextSize(16)//设置滚轮文字大小
                .setSubCalSize(16)
                .setCancelText("取消")
                .setSubmitText("确定")
                .setDividerColor(Color.DKGRAY)//设置分割线的颜色
                .setSelectOptions(0)//默认选中项
                .setCancelColor(context.getResources().getColor(R.color.gray_text))
                .setSubmitColor(context.getResources().getColor(R.color.red))
                .setTextColorCenter(Color.BLACK)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .build();
        optionsPickerView.setPicker(list);//添加数据源
        return optionsPickerView;
    }

    /**
     * 时间选择器
     * @param textView
     * @param type //1=年月2=年月日
     * @return
     */
    public TimePickerView initTimePicker(final TextView textView, final int type){
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        boolean[] setType = new boolean[]{true, true, true, false, false, false};
        if(type==1){
            setType=new boolean[]{true, true, false, false, false, false};
        }else if(type==2){
            setType=new boolean[]{true, true, true, false, false, false};
        }

        //正确设置方式 原因：注意事项有说明
        startDate.set(1938,0,1);
        //时间选择器
        timePickerView = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                if(type==1){
                    textView.setText(TimeUtils.date2String(date, TimeUtils.YMD_PATTERN2));
                }else if(type==2){
                    textView.setText(TimeUtils.date2String(date, TimeUtils.YMD_PATTERN));
                }
                //10位数时间戳
//                timeStr= SystemHelper.getTime10(TimeUtils.date2String(date, TimeUtils.YMD_PATTERN2)+"-01 00:00");
                pikerCaseTime.caseTime(TimeUtils.date2String(date, TimeUtils.YMD_PATTERN));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(setType)
                .setLabel("年", "月", "日", "", "", "")
                .isCenterLabel(false)
                .isCyclic(false)//是否循环滚动
                .setDividerColor(Color.DKGRAY)
                .setContentTextSize(16)
                .setSubCalSize(16)
                .setCancelColor(context.getResources().getColor(R.color.gray_text))
                .setSubmitColor(context.getResources().getColor(R.color.red))
                .setRangDate(startDate, selectedDate)
                .setDate(selectedDate)
//                .isDialog(true)//是否显示为对话框样式
                .build();
        return timePickerView;
    }
    private void swichData(int viewId,int position) {
        pikerCaseData.caseData(viewId,position);
    }
    public interface PikerCaseData{
        /**
         * Piker返回选择好的参数
         * @param viewId view ID
         * @param position 选择的list数据item
         */
        void caseData(int viewId,int position);
    }
    public interface PikerCaseTime{
        /**
         * Piker返回选择好的参数
         * @param time
         */
        void caseTime(String time);
    }
}
