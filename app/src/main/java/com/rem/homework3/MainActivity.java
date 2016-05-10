package com.rem.homework3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends Activity {

    public void openNewApp(View view) {
        Intent intent = new Intent(MainActivity.this, App.class);
        startActivity(intent);
    }

    public void onClickApplication (View view) {
        Intent intent = new Intent(MainActivity.this, Application.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
