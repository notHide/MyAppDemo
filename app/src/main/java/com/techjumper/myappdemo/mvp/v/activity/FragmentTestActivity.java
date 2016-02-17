package com.techjumper.myappdemo.mvp.v.activity;

import android.os.Bundle;
import android.view.View;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.rx.RxBus;
import com.techjumper.corelib.ui.activity.BaseFragmentActivity;
import com.techjumper.corelib.utils.rxtools.RxUtils;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.p.activity.FragmentTestActivityPresenter;
import com.techjumper.myappdemo.mvp.p.fragment.TestFragmentPresenter;
import com.techjumper.myappdemo.mvp.v.fragment.TestFragment;

import rx.Subscription;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
@Presenter(FragmentTestActivityPresenter.class)
public class FragmentTestActivity extends BaseFragmentActivity<FragmentTestActivityPresenter> {

    private Subscription mSubscribe;


    @Override
    protected View inflateView(Bundle savedInstanceState) {
        return inflate(R.layout.activity_test_fragment);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mSubscribe = RxBus.INSTANCE.asObservable()
                .subscribe(o -> {
                    if (o instanceof TestFragmentPresenter.ClickEvent) {
                        TestFragmentPresenter.ClickEvent event = (TestFragmentPresenter.ClickEvent) o;
                        switchFragment(R.id.container, TestFragment.getInstance(event.getNum() + 1), true);
                    }
                });

        if (savedInstanceState == null) {
            switchFragment(R.id.container, TestFragment.getInstance(1), false);
        }
    }

    @Override
    protected void onViewInited(Bundle savedInstanceState) {
        super.onViewInited(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxUtils.unsubscribeIfNotNull(mSubscribe);
    }
}
