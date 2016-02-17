package com.techjumper.myappdemo.mvp.v.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.ui.fragment.BaseViewFragment;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.p.fragment.RealmQueryFragmentPresenter;

import butterknife.Bind;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/

@Presenter(RealmQueryFragmentPresenter.class)
public class RealmQueryFragment extends BaseViewFragment<RealmQueryFragmentPresenter> {

    @Bind(R.id.btn_all)
    Button mBtnAll;
    @Bind(R.id.btn_2)
    Button mBtn2;
    @Bind(R.id.btn_3)
    Button mBtn3;
    @Bind(R.id.btn_4)
    Button mBtn4;
    @Bind(R.id.tv)
    TextView mTv;

    public static RealmQueryFragment getInstance() {
        RealmQueryFragment fragment = new RealmQueryFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_realm_query, null);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }

    public void showResult(String result) {
        mTv.setText(result);
    }

    public String getText() {
        return mTv.getText().toString();
    }

}
