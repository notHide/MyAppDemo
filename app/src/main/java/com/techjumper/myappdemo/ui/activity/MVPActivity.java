package com.techjumper.myappdemo.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.ui.activity.BaseViewActivity;
import com.techjumper.corelib.utils.window.DialogUtils;
import com.techjumper.myappdemo.presenter.MVPPresenter;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/11
 * * * * * * * * * * * * * * * * * * * * * * *
 **/

@Presenter(MVPPresenter.class)
public class MVPActivity extends BaseViewActivity<MVPPresenter> {

    @Override
    protected View inflateView(Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }


    public void showDialog(String str) {
        DialogUtils.quickDialog(this, "这是 " + str);
    }
}
