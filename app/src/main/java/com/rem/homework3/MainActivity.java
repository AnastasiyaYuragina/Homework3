package com.rem.homework3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
//            gridLayout.setColumnCount(3);
//            addButton(gridLayout.getColumnCount(), gridLayout);
//        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
//            gridLayout.setColumnCount(5);
//            addButton(gridLayout.getColumnCount(), gridLayout);
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private void addButton(int colum, GridLayout gridLayout) {
//
//
//        for (int i = 0; i < colum; i++) {
//            for (int j = 0; j < 10; j++) {
//                Button button = new Button(this);
//                button.setId(i + j);
//                button.setText(R.string.text_button);
//                gridLayout.addView(button);
//
//                GridLayout.LayoutParams params = (GridLayout.LayoutParams) button.getLayoutParams();
//                params.columnSpec = GridLayout.spec(i);
//                params.rowSpec = GridLayout.spec(j);
//                params.setMargins(2, 2, 2, 2);
//            }
//        }
//
//    }
}
