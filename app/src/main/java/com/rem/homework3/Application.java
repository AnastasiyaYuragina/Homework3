package com.rem.homework3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class Application extends Activity {

    private RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
//    private ArrayList<String> list = new ArrayList<>();
    private String[] list1 = {"App1", "App2", "App3", "App4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app);

//        list.add("App1");
//        list.add("App2");
//        list.add("App3");
//        list.add("App4");
//        list.add("App5");
//        list.add("App6");
//        list.add("App7");
//        list.add("App8");
//        list.add("App9");
//        list.add("App10");
//        list.add("App11");
//        list.add("App12");
//        list.add("App13");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        onClickList(null);

        adapter = new MyAdapter(list1);
        recyclerView.setAdapter(adapter);

    }

    public void onClickGrid(View view) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void onClickList(View view) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}
