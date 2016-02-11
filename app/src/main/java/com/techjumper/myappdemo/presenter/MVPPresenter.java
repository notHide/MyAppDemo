package com.techjumper.myappdemo.presenter;

import android.os.Bundle;

import com.techjumper.corelib.mvp.presenter.BaseActivityPresenterImp;
import com.techjumper.corelib.utils.common.JLog;
import com.techjumper.myappdemo.ui.activity.MVPActivity;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/11
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class MVPPresenter extends BaseActivityPresenterImp<MVPActivity> {

    @Override
    public void initData(Bundle savedInstanceState) {
        JLog.d("initData()");
    }

    @Override
    public void onViewInited(Bundle savedInstanceState) {
        JLog.d("onViewInited()");
        log();
    }

    public void log() {
        JLog.d("这是 MVPPresenter 打出的 Log");
        getView().showDialog(getClass().getSimpleName());
    }

}
