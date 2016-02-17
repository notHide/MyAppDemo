package com.techjumper.myappdemo.mvp.p.fragment;

import android.os.Bundle;

import com.techjumper.corelib.mvp.presenter.BaseFragmentPresenterImp;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.v.fragment.RealmIndexFragment;
import com.techjumper.myappdemo.mvp.v.fragment.RealmInsertFragment;
import com.techjumper.myappdemo.mvp.v.fragment.RealmQueryFragment;

import butterknife.OnItemClick;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class RealmIndexFragmentPresenter extends BaseFragmentPresenterImp<RealmIndexFragment> {

    private String[] mDataList = new String[]{"写入", "查询"};

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onViewInited(Bundle savedInstanceState) {
    }

    @OnItemClick(R.id.list)
    public void onItemClick(int position) {
        switch (mDataList[position]) {
            case "写入":
                RealmInsertFragment instance = RealmInsertFragment.getInstance();
                getView().getBaseFragmentActivity().switchFragment(R.id.container
                        , instance, true);

                break;
            case "查询":
                getView().getBaseFragmentActivity().switchFragment(R.id.container
                        , RealmQueryFragment.getInstance(), true);
                break;
        }
    }

    public String[] getDataList() {
        return mDataList;
    }
}
