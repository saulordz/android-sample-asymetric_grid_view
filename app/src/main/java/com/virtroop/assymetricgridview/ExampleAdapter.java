package com.virtroop.assymetricgridview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kletuz on 7/11/2017.
 */

public class ExampleAdapter extends ArrayAdapter<SimplePOJO> implements ListAdapter{

    private final LayoutInflater layoutInflater;

    public ExampleAdapter(Context context, List<SimplePOJO> items) {
        super(context, 0, items);
        layoutInflater = LayoutInflater.from(context);
    }

    public ExampleAdapter(Context context) {
        super(context, 0);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View v;

        SimplePOJO item = getItem(position);
        boolean isRegular = getItemViewType(position) == 0;

        if (convertView == null) {
            v = layoutInflater.inflate(
                    isRegular ? R.layout.list_item : R.layout.list_item_odd, parent, false);
        } else {
            v = convertView;
        }

        TextView textView;
        if (isRegular) {
            textView = (TextView) v.findViewById(R.id.textview);
        } else {
            textView = (TextView) v.findViewById(R.id.textview_odd);
        }

        textView.setText(String.valueOf(item.getPosition()));

        return v;
    }

    @Override public int getViewTypeCount() {
        return 2;
    }

    @Override public int getItemViewType(int position) {
        return position % 2 == 0 ? 1 : 0;
    }

    public void appendItems(List<SimplePOJO> newItems) {
        addAll(newItems);
        notifyDataSetChanged();
    }

    public void setItems(List<SimplePOJO> moreItems) {
        clear();
        appendItems(moreItems);
    }
}
