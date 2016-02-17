package com.techjumper.myappdemo.mvp.p.activity;

import android.os.Bundle;

import com.techjumper.corelib.rx.RxBus;
import com.techjumper.corelib.mvp.presenter.BaseActivityPresenterImp;
import com.techjumper.corelib.utils.rxtools.RxUtils;
import com.techjumper.myappdemo.mvp.v.activity.MVPActivity;

import rx.Subscription;
import rx.functions.Action1;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/11
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class MVPPresenter extends BaseActivityPresenterImp<MVPActivity> {

    private Subscription subscribe;

    @Override
    public void initData(Bundle savedInstanceState) {
        subscribe = RxBus.INSTANCE.asObservable().subscribe(o -> {
            getView().log("RxBus Running");
        });
    }

    @Override
    public void onViewInited(Bundle savedInstanceState) {
        log();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxUtils.unsubscribeIfNotNull(subscribe);
    }

    public void log() {
        getView().sendMessage(getClass().getSimpleName());
        getView().showDialog();
    }

}
