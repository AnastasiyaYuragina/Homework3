package com.rem.homework3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

/**
 * Created by Anastasiya on 18.04.2016.
 */
public class Adapter extends BaseAdapter {
    private Context context;
    private List<Button> items;

    public Adapter(Context context, List<Button> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.add_app, null);
            holder.button = (Button) convertView.findViewById(R.id.application);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {
        Button button;
    }

    public void appItem(Button button) {
        items.add(button);
        notifyDataSetChanged();
    }
}
