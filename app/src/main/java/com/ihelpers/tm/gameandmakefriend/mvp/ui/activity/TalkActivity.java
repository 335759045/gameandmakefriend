package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TalkActivity extends FragmentActivity {
    @BindView(R.id.act_talk_left)
    ImageView actTalkLeft;
    @BindView(R.id.act_talk_right)
    TextView actTalkRight;
    @BindView(R.id.act_talk_content)
    TextView actTalkContent;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_talk);
        ButterKnife.bind(this);
        id = getIntent().getData().getQueryParameter("targetId");
        String title = getIntent().getData().getQueryParameter("title");
        actTalkContent.setText(title);
    }

    @OnClick({R.id.act_talk_left, R.id.act_talk_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_talk_left:
                finish();
                break;
            case R.id.act_talk_right:
                break;
        }
    }
}
