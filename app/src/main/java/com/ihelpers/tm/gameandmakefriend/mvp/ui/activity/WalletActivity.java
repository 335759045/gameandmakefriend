package com.ihelpers.tm.gameandmakefriend.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihelpers.tm.gameandmakefriend.R;
import com.ihelpers.tm.gameandmakefriend.base.BaseActivity;
import com.ihelpers.tm.gameandmakefriend.base.BasePresentImpl;
import com.ihelpers.tm.gameandmakefriend.commom.Constans;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalletActivity extends BaseActivity {
    @BindView(R.id.act_wallet_ye)
    TextView actWalletYe;
    @BindView(R.id.act_wallet_ye_tx)
    TextView actWalletYeTx;
    @BindView(R.id.act_wallet_star)
    TextView actWalletStar;
    @BindView(R.id.act_wallet_star_tx)
    TextView actWalletStarTx;
    @BindView(R.id.act_wallet_ye_L)
    LinearLayout actWalletYeL;
    @BindView(R.id.act_wallet_star_L)
    LinearLayout actWalletStarL;
    @BindView(R.id.act_wallet_sr_L)
    LinearLayout actWalletSrL;
    @BindView(R.id.act_wallet_zc_L)
    LinearLayout actWalletZcL;
    @BindView(R.id.act_wallet_cz_L)
    LinearLayout actWalletCzL;
    @BindView(R.id.act_wallet_tx_L)
    LinearLayout actWalletTxL;

    @Override
    protected BasePresentImpl createPresent() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("我的钱包");
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.act_wallet;
    }

    @Override
    protected void setUpView() {

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
    @OnClick({R.id.act_wallet_ye_tx, R.id.act_wallet_star_tx, R.id.act_wallet_ye_L, R.id.act_wallet_star_L, R.id.act_wallet_sr_L, R.id.act_wallet_zc_L, R.id.act_wallet_cz_L, R.id.act_wallet_tx_L})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_title_main_left:
                finish();
                break;
            case R.id.act_wallet_ye_tx:
                Intent intent1=new Intent(this,TiXianActivity.class);
                intent1.putExtra(Constans.WALLET_TO1,1);
                startActivity(intent1);
                break;
            case R.id.act_wallet_star_tx:
                Intent intent2=new Intent(this,TiXianActivity.class);
                intent2.putExtra(Constans.WALLET_TO1,2);
                startActivity(intent2);
                break;
            case R.id.act_wallet_ye_L:
                Intent intent3=new Intent(this,TopUpActivity.class);
                startActivity(intent3);
                break;
            case R.id.act_wallet_star_L:
                Intent intent4=new Intent(this,StarTopUpActivity.class);
                startActivity(intent4);
                break;
            case R.id.act_wallet_sr_L:
                Intent intent5=new Intent(this,IncomeDetailActivity.class);
                intent5.putExtra(Constans.WALLET_TO2,1);
                startActivity(intent5);
                break;
            case R.id.act_wallet_zc_L:
                Intent intent6=new Intent(this,IncomeDetailActivity.class);
                intent6.putExtra(Constans.WALLET_TO2,2);
                startActivity(intent6);
                break;
            case R.id.act_wallet_cz_L:
                Intent intent7=new Intent(this,IncomeDetailActivity.class);
                intent7.putExtra(Constans.WALLET_TO2,3);
                startActivity(intent7);
                break;
            case R.id.act_wallet_tx_L:
                Intent intent8=new Intent(this,IncomeDetailActivity.class);
                intent8.putExtra(Constans.WALLET_TO2,4);
                startActivity(intent8);
                break;
        }
    }
}
