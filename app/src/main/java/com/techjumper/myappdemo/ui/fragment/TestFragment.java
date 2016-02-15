package com.techjumper.myappdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.ui.fragment.BaseViewFragment;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.presenter.fragment.TestFragmentPresenter;

import butterknife.Bind;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/

@Presenter(TestFragmentPresenter.class)
public class TestFragment extends BaseViewFragment<TestFragmentPresenter> {

    @Bind(R.id.tv)
    TextView mTv;

    public static TestFragment getInstance(int num) {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        args.putInt(TestFragmentPresenter.SAVE_KEY_NUM, num);
        fragment.getPresenter().setNum(num);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, null);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTv.setText(String.format("当前是第 %d 个Fragment", getPresenter().getNum()));
    }

    @Override
    protected void onSaveState(Bundle saveBundle) {
        super.onSaveState(saveBundle);
    }

    @Override
    public String getFragmentSignature() {
        return getClass().getName() + "_" + getPresenter().getNum();
    }

}
