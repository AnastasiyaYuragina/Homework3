package com.rem.homework3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Select;
import java.util.ArrayList;
import java.util.List;


public class AllApplicationActivity extends Activity {

    private EditText editText;
    private Filter filter;
    private ApplicationAdapter adapter;
    private RecyclerView recyclerView;

    public void openNewApp(View view) {
        Intent intent = new Intent(AllApplicationActivity.this, App.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app);
        FlowManager.init(this);
        AddItemInDB();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        onClickGrid(recyclerView);

//        adapter = new ApplicationAdapter(new ArrayList<>(Arrays.asList(list)));
        adapter = new ApplicationAdapter(SelectFromDB());
        recyclerView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.searchText);
        editText.addTextChangedListener(textWatcher);
        filter = adapter.getFilter();
    }

    public void onClickGrid(View view) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void onClickList(View view) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            filter.filter(s);
        }
    };

    private void AddItemInDB () {
        String[] item = {"App1", "App2", "App3", "App4", "App5", "App6", "App7", "App8", "App9", "App10", "App11", "App12", "App13"};
        
        TableApplication application = new TableApplication();

        for (int i = 0; i < item.length; i++) {
            application.id = i;
            application.setName(item[i]);
            application.save();
        }
    }

    private ArrayList<String> SelectFromDB() {
        List<TableApplication> tableApplicationList = new Select().from(TableApplication.class).queryList();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < tableApplicationList.size(); i++) {
            list.add(tableApplicationList.get(i).name);
        }

        return list;
    }

}
