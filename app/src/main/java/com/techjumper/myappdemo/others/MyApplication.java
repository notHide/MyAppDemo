package com.techjumper.myappdemo.others;

import com.techjumper.corelib.utils.common.JLog;
import com.techjumper.lib2.others.Lib2Application;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/10
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class MyApplication extends Lib2Application {


    @Override
    public void onCrash(Throwable ex) {
        JLog.e("崩溃啦~！");
    }

    @Override
    public String[] fetchCrashFolderName() {
        return new String[]{"MyApp", "Log"};
    }

    @Override
    protected int getDbVersion() {
        return Config.DB_VERSION;
    }
}
