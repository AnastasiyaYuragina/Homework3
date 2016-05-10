package com.rem.homework3;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.Arrays;


public class Application extends Activity {

    private EditText editText;
    private Button applicationButton;
    private Button uninstallButton;
    private Filter filter;
    private ApplicationAdapter adapter;
    private RecyclerView recyclerView;
    private String[] list = {"App1", "App2", "App3", "App4", "App5", "App6", "App7", "App8", "App9", "App10", "App11", "App12", "App13"};

    public void openNewApp(View view) {
        Intent intent = new Intent(Application.this, App.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app);

        uninstallButton = (Button) findViewById(R.id.uninstall);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        onClickGrid(recyclerView);

        adapter = new ApplicationAdapter(new ArrayList<>(Arrays.asList(list)));
        recyclerView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.searchText);
        editText.addTextChangedListener(textWatcher);
        filter = adapter.getFilter();

        uninstallButton.setOnDragListener(new MyDragListener());
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

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundColor(getTitleColor());
                    break;
                case DragEvent.ACTION_DROP:
                    View view = (View) event.getLocalState();
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    viewGroup.removeView(view);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundColor(getTitleColor());
                    default:
                        break;
            }

            return true;
        }
    }
}
