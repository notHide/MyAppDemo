package com.techjumper.myappdemo.mvp.p.fragment;

import android.os.Bundle;
import android.view.View;

import com.techjumper.corelib.mvp.presenter.BaseFragmentPresenterImp;
import com.techjumper.myappdemo.R;
import com.techjumper.myappdemo.mvp.v.fragment.RealmQueryFragment;

import butterknife.OnClick;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/15
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class RealmQueryFragmentPresenter extends BaseFragmentPresenterImp<RealmQueryFragment> {

    private final static String SAVED_STATE_TEXT = "saved_state_text";

    @Override
    public void initData(Bundle savedInstanceState) {
        if (getView().hasRestoreData()) {
            String string = getView().getRestoreData().getString(SAVED_STATE_TEXT);
            getView().showResult(string);
        }
    }

    @Override
    public void onViewInited(Bundle savedInstanceState) {

    }


    @OnClick({R.id.btn_all, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onClick(View view) {
        String name = null;
        switch (view.getId()) {
            case R.id.btn_all:
                name = "";
                break;
            case R.id.btn_2:
                name = "张三";
                break;
            case R.id.btn_3:
                name = "王思思";

                break;
            case R.id.btn_4:
                name = "张全全";
                break;
        }


//        final String finalName = name;
//        RealmQueryFragmentModel model = new RealmQueryFragmentModel();
//
//        //为了测试在子线程是否工作正常,实际是运行在主线程的
//        new Thread(() -> {
//            model.findName(finalName)
//                    .flatMap(Observable::from)
//                    .subscribe(new Subscriber<User>() {
//                        @Override
//                        public void onCompleted() {
//                            sb.append("查询完毕\n");
//                            getView().showResult(sb.toString());
//                            RealmHelper.closeRealm();
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            sb.append(e.toString()).append("\n");
//                            getView().showResult(sb.toString());
//                        }
//
//                        @Override
//                        public void onNext(User user) {
//                            sb.append(user).append("\n");
//                        }
//                    });
//        }).start();


    }

    @Override
    public void onSaveState(Bundle saveBundle) {
        saveBundle.putString(SAVED_STATE_TEXT, getView().getText());
    }
}
