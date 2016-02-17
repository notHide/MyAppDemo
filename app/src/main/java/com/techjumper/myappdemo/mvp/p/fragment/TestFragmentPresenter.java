package com.techjumper.myappdemo.mvp.p.fragment;

import android.os.Bundle;

import com.techjumper.corelib.mvp.presenter.BaseFragmentPresenterImp;
import com.techjumper.corelib.rx.RxBus;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.v.fragment.TestFragment;

import butterknife.OnClick;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class TestFragmentPresenter extends BaseFragmentPresenterImp<TestFragment> {

    public static final String SAVE_KEY_NUM = "save_key_num";

    private int mNum = 1;

    @Override
    public void initData(Bundle savedInstanceState) {
        mNum = getView().getArguments().getInt(SAVE_KEY_NUM, -1);
    }

    @Override
    public void onViewInited(Bundle savedInstanceState) {
    }

    public int getNum() {
        return mNum;
    }

    public void setNum(int mNum) {
        this.mNum = mNum;
    }

    @OnClick(R.id.btn)
    public void onClick() {
        RxBus.INSTANCE.send(new ClickEvent(mNum));
    }

    public static class ClickEvent {
        private int num;

        public ClickEvent(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }


}
