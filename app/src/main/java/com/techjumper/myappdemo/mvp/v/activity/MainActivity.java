package com.techjumper.myappdemo.mvp.v.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.techjumper.corelib.utils.common.ActivityUtils;
import com.techjumper.corelib.utils.window.StatusbarHelper;
import com.techjumper.myappdemo.R;


public class MainActivity extends ListActivity {

    private String[] dataList = new String[]{"MVP", "Shade", "FragmentSwitchTest", "Realm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList));

        StatusbarHelper.from(this)
                .setTransparentStatusbar(true)
                .setLightStatusBar(false)
                .setLayoutRoot(findViewById(android.R.id.list))
                .setNoActionBar(true)
                .process();

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (dataList[position]) {
            case "MVP":
                ActivityUtils.start(this, MVPActivity.class);
                break;
            case "Shade":
                ActivityUtils.start(this, ShadeActivity.class);
                break;
            case "FragmentSwitchTest":
                ActivityUtils.start(this, FragmentTestActivity.class);
                break;
            case "Realm":
                ActivityUtils.start(this, RealmActivity.class);
                break;
        }
        super.onListItemClick(l, v, position, id);
    }
}
