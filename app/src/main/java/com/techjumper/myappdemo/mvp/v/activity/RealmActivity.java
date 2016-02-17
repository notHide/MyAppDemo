package com.techjumper.myappdemo.mvp.v.activity;

import android.os.Bundle;
import android.view.View;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.ui.activity.BaseFragmentActivity;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.p.activity.RealmActivityPresenter;
import com.techjumper.myappdemo.mvp.v.fragment.RealmIndexFragment;


/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
@Presenter(RealmActivityPresenter.class)
public class RealmActivity extends BaseFragmentActivity<RealmActivityPresenter> {


    @Override
    protected View inflateView(Bundle savedInstanceState) {
        return inflate(R.layout.activity_realm);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            switchFragment(R.id.container, RealmIndexFragment.getInstance(), false);
        }

    }
}
