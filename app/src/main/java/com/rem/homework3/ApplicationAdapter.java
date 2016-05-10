package com.rem.homework3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ViewHolder> implements Filterable{
    private ArrayList<String> items;
    private ArrayList<String> originalItems;
    private ApplicationFilter applicationFilter = new ApplicationFilter();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.applicationButton);
        }
    }

    public ApplicationAdapter(ArrayList<String> items) {
        this.items = items;
        originalItems = new ArrayList<>(items);
    }

    @Override
    public ApplicationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_app, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.button.setText(items.get(position));
        holder.button.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_launcher, 0, 0);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Filter getFilter() {
        return applicationFilter;
    }

    private class ApplicationFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            items.clear();
            ArrayList<String> filteredList = new ArrayList<>();
            FilterResults filterResults = new FilterResults();

            if (constraint != null || constraint.length() != 0) {
                for (String s : originalItems) {
                    if (s.contains(constraint.toString())) {
                        s = s.replaceAll(constraint.toString(), constraint + "");
                        filteredList.add(s);
                    }
                }
            }

            filterResults.values = filteredList;
            filterResults.count = filteredList.size();

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            items.addAll((List<String>) results.values);
            notifyDataSetChanged();
        }
    }
}
