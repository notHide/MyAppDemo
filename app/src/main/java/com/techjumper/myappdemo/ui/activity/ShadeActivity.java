package com.techjumper.myappdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.techjumper.corelib.ui.activity.BaseActivity;
import com.techjumper.myappdemo.R;

import butterknife.Bind;


/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/10
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class ShadeActivity extends BaseActivity {

    @Bind(R.id.iv_1)
    ImageView mIV1;

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected View inflateView(Bundle savedInstanceState) {
        return inflate(R.layout.activity_shade);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }

    @Override
    protected void onViewInited(Bundle savedInstanceState) {
        mIV1.setImageResource(R.mipmap.one_piece);
    }
}
