package com.techjumper.myappdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.techjumper.corelib.utils.UI;
import com.techjumper.corelib.utils.window.StatusbarHelper;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/10
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public abstract class BaseActivity extends AppCompatActivity {

    protected AppCompatActivity mThis;
    protected View mViewRoot;
    protected UI mUi;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mThis = this;
        mUi = UI.create(this);

        initData(savedInstanceState);
        mViewRoot = inflateView(savedInstanceState);
        if (mViewRoot != null) setContentView(mViewRoot);
        initView(savedInstanceState);
        find(android.R.id.content).post(new Runnable() {
            @Override
            public void run() {
                onViewInited(savedInstanceState);
            }
        });

        StatusbarHelper.from(this)
                .setNoActionBar(true)
                .setLightStatusBar(false)
                .setTransparentStatusbar(true)
                .setLayoutRoot(mViewRoot)
                .process();

    }


    protected <T extends View> T find(int id) {
        return mUi.findById(id);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T inflate(int id) {
        return (T) getLayoutInflater().inflate(id, null);
    }

    protected Bundle getIntentBundle() {
        if (getIntent() == null || getIntent().getExtras() == null)
            return new Bundle();
        else
            return getIntent().getExtras();
    }

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract View inflateView(Bundle savedInstanceState);

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void onViewInited(Bundle savedInstanceState);


}
