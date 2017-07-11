package com.virtroop.assymetricgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ListAdapter;

import com.felipecsl.asymmetricgridview.library.Utils;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int currentOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsymmetricGridView listView = (AsymmetricGridView) findViewById(R.id.listView);

        // Choose your own preferred column width
        listView.setRequestedColumnWidth(Utils.dpToPx(this, 120));
        final List<SimplePOJO> items = getDefaultItems(10);

        // initialize your items array
        ExampleAdapter adapter = new ExampleAdapter(this, items);
        AsymmetricGridViewAdapter asymmetricAdapter =
                new AsymmetricGridViewAdapter<>(this, listView, adapter);
        listView.setAdapter(asymmetricAdapter);

    }

    public List<SimplePOJO> getDefaultItems(int qty) {
        List<SimplePOJO> items = new ArrayList<>();

        for (int i = 0; i < qty; i++) {
            int colSpan = Math.random() < 0.2f ? 2 : 1;
            int rowSpan = colSpan;
            if (i == 0) {
                rowSpan = 2;
            }
            SimplePOJO item = new SimplePOJO(colSpan, rowSpan, currentOffset + i);
            items.add(item);
        }

        currentOffset += qty;

        return items;
    }
}
