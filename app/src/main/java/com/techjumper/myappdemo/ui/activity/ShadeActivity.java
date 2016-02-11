package com.techjumper.myappdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.techjumper.myappdemo.R;


/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/10
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class ShadeActivity extends BaseActivity {

    private ImageView mIV1;

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected View inflateView(Bundle savedInstanceState) {
        return inflate(R.layout.activity_shade);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mIV1 = find(R.id.iv_1);
    }

    @Override
    protected void onViewInited(Bundle savedInstanceState) {
        mIV1.setImageResource(R.mipmap.one_piece);
    }
}
