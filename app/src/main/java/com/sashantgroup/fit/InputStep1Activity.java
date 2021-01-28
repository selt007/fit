package com.sashantgroup.fit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TabHost;

public class InputStep1Activity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_step1);

        Button button = findViewById(R.id.butStep1);
        button.setOnClickListener(v -> {
            InputDataActivity inputDataActivity = (InputDataActivity) this.getParent();
            TabHost tabHost = inputDataActivity.getTabHost();
            tabHost.setCurrentTab(1);
        });
    }
}
