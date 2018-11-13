package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hedgehog.ratingbar.RatingBar;
import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;

import butterknife.BindView;

public class EvaluateActivity extends BaseActivity {
    @BindView(R.id.act_evaluate_title)
    TextView actEvaluateTitle;
    @BindView(R.id.act_evaluate_bar)
    RatingBar actEvaluateBar;
    @BindView(R.id.act_evaluate_content)
    EditText actEvaluateContent;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("评价");
        getbtn_right().setText("发布");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_evaluate;
    }

    @Override
    protected void setUpView() {
        actEvaluateBar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float RatingCount) {
                switch ((int) RatingCount){
                    case 1:
                        actEvaluateTitle.setText("非常差，不会再来");
                        break;
                    case 2:
                        actEvaluateTitle.setText("感觉很一般");
                        break;
                    case 3:
                        actEvaluateTitle.setText("满意，感觉不错");
                        break;
                    case 4:
                        actEvaluateTitle.setText("很满意，下次还来");
                        break;
                    case 5:
                        actEvaluateTitle.setText("真的是，超赞耶");
                        break;
                }
            }
        });
        actEvaluateBar.setStar(1f);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected boolean getretunData() {
        return true;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void reFreshData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v==getbtn_left()){
            finish();
        }else if(v==getbtn_right()){

        }
    }
}
