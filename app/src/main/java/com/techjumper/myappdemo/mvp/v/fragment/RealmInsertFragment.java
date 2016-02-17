package com.techjumper.myappdemo.mvp.v.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.ui.fragment.BaseViewFragment;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.p.fragment.RealmInsertFragmentPresenter;


/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/

@Presenter(RealmInsertFragmentPresenter.class)
public class RealmInsertFragment extends BaseViewFragment<RealmInsertFragmentPresenter> {

    public static RealmInsertFragment getInstance() {
        RealmInsertFragment fragment = new RealmInsertFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_realm_insert, null);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

}
