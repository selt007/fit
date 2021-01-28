package com.sashantgroup.fit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        prefs = getSharedPreferences("config", Context.MODE_PRIVATE);
        if (prefs.getString(APP_OPS_SERVICE, "").equals("")) {
            Intent intent = new Intent(this, InputDataActivity.class);
            startActivity(intent);
            onPause();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        InputFitData inputFitData = new InputFitData();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(APP_OPS_SERVICE, inputFitData.set()).apply();
    }

}