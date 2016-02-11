package com.techjumper.myappdemo.others;

import com.techjumper.corelib.others.JumperApplication;
import com.techjumper.corelib.utils.common.JLog;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/10
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class MyApplication extends JumperApplication {
    @Override
    public void onCrash(Throwable ex) {
        JLog.e("崩溃啦~！");
    }

    @Override
    public String[] fetchCrashFolderName() {
        return new String[]{"MyApp", "Log"};
    }
}
