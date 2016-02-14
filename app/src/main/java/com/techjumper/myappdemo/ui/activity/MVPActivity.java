package com.techjumper.myappdemo.ui.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.techjumper.corelib.rx.RxBus;
import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.rx.SchedulersCompat;
import com.techjumper.corelib.utils.file.PreferenceUtils;
import com.techjumper.corelib.ui.activity.BaseViewActivity;
import com.techjumper.corelib.utils.common.DateUtils;
import com.techjumper.corelib.utils.common.JLog;
import com.techjumper.corelib.utils.rxtools.RxCountdown;
import com.techjumper.corelib.utils.window.DialogUtils;
import com.techjumper.myappdemo.presenter.MVPPresenter;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;

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


    public void sendMessage(String str) {
        RxBus.INSTANCE.send(new Event());
    }


    public void log(String str) {
        JLog.d(str);
        PreferenceUtils.save("test", 1.3);

//        RxCountdown.countdown(5)
//                .doOnSubscribe(() -> appendLog("开始计时"))
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        appendLog("计时完成");
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        appendLog("当前计时：" + integer);
//
//                    }
//                });

    }


    public void showDialog() {
        Observable.just("异步测试对话框")
                .map(s -> {
                    JLog.d("map()当前线程：" + Thread.currentThread().getId());
                    SystemClock.sleep(2000);
                    return s;
                })
                .map(s -> {
                    JLog.d("map2()当前线程：" + Thread.currentThread().getId());
                    return s;
                })
                .compose(SchedulersCompat.<String>applyComputationSchedulers())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        JLog.e("弹出对话框发生错误：" + e);

                    }

                    @Override
                    public void onNext(String s) {
                        DialogUtils.quickDialog(mThis, s);
                        JLog.d("onNext()当前线程：" + Thread.currentThread().getId());
                    }
                });
    }

    private void appendLog(String str) {
        JLog.d("当前时间：" + DateUtils.formatCurrentTime("mm:ss:SSS") + " --- " + str);
    }

    private static class Event {
    }
}
