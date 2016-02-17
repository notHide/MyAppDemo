package com.techjumper.myappdemo.mvp.v.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.techjumper.corelib.mvp.factory.Presenter;
import com.techjumper.corelib.ui.fragment.BaseViewFragment;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.p.fragment.RealmIndexFragmentPresenter;

import butterknife.Bind;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/

@Presenter(RealmIndexFragmentPresenter.class)
public class RealmIndexFragment extends BaseViewFragment<RealmIndexFragmentPresenter> {

    @Bind(R.id.list)
    ListView mLv;

    public static RealmIndexFragment getInstance() {
        RealmIndexFragment fragment = new RealmIndexFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_realm_index, null);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mLv.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1
                , getPresenter().getDataList()));
    }

}
