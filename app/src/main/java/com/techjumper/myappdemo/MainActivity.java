package com.techjumper.myappdemo;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.techjumper.corelib.utils.window.StatusbarHelper;

public class MainActivity extends ListActivity {

    private String[] dataList = new String[]{"MVP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList));

        StatusbarHelper.from(this)
                .setTransparentStatusbar(true)
                .setLightStatusBar(true)
                .setLayoutRoot(findViewById(android.R.id.list))
                .setNoActionBar(true)
                .process();

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (dataList[position]) {
            case "MVP":
                break;
        }
        super.onListItemClick(l, v, position, id);
    }
}
