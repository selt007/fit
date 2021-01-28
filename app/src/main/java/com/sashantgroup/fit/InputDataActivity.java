package com.sashantgroup.fit;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class InputDataActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("");
        tabSpec.setContent(new Intent(this, InputStep1Activity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("");
        tabSpec.setContent(new Intent(this, InputStep2Activity.class));
        tabHost.addTab(tabSpec);
    }

    @Override
    public TabHost getTabHost() {
        return super.getTabHost();
    }
}

