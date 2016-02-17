package com.techjumper.myappdemo.mvp.p.fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.litesuits.orm.LiteOrm;
import com.techjumper.corelib.mvp.presenter.BaseFragmentPresenterImp;
import com.techjumper.corelib.utils.common.JLog;
import com.techjumper.corelib.utils.window.ToastUtils;
import com.techjumper.lib2.utils.LiteHelper;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.entity.User;
import com.techjumper.myappdemo.mvp.v.fragment.RealmInsertFragment;

import butterknife.OnClick;
import rx.Subscriber;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class RealmInsertFragmentPresenter extends BaseFragmentPresenterImp<RealmInsertFragment> {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onViewInited(Bundle savedInstanceState) {
    }

    @OnClick({R.id.btn_1, R.id.btn_2})
    public void onClick(Button button) {
        LiteOrm liteOrm = LiteHelper.getInstance().getLiteOrm();
        switch (button.getId()) {
            case R.id.btn_1:
                LiteHelper.getInstance().asObservable(liteOrm)
                        .map(liteOrm1 -> {
                            JLog.showThreadId("map()");
                            User user = new User();
                            user.setName("王思思");
                            user.setAge(18);
                            return liteOrm1.save(user);
                        })
                        .subscribe(new Subscriber<Long>() {
                            @Override
                            public void onCompleted() {
                                LiteHelper.close(liteOrm);
                            }

                            @Override
                            public void onError(Throwable e) {
                                ToastUtils.show("出错啦:" + e);
                            }

                            @Override
                            public void onNext(Long aLong) {
                                ToastUtils.show("保存完成: " + aLong);
                            }
                        });
//                User user = new User();
//                user.setName("王思思");
//                user.setAge(21);
//                RealmHelper.INSTANCE.saveToRealm(user, new RealmCallback() {
//                    @Override
//                    public void onSuccess() {
//                        ToastUtils.show("写入成功");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.show("失败: " + e);
//                    }
//                });
                break;
            case R.id.btn_2:
//                final Realm realm = Realm.getDefaultInstance();
//                realm.executeTransaction(realm1 -> {
//                    User user2 = realm1.createObject(User.class);
//                    user2.setName("赵朝朝");
//                    user2.setAge(23);
//                }, new Realm.Transaction.Callback() {
//                    @Override
//                    public void onSuccess() {
//                        Toast.makeText(getView().getActivity(), "写入成功", Toast.LENGTH_SHORT).show();
//
//                        if (realm != null) {
//                            realm.close();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        Toast.makeText(getView().getActivity(), "出错啦: " + e.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
                break;
        }

    }
}
