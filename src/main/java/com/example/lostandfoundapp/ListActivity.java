package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LostFoundAdapter adapter;
    private DatabaseHelper databaseHelper;
    private List<LostFoundItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new DatabaseHelper(this);
        itemList = databaseHelper.getAllItems();

        adapter = new LostFoundAdapter(this, itemList, item -> {
            databaseHelper.deleteItem(item.getId());
            refreshList();
        });

        recyclerView.setAdapter(adapter);
    }

    private void refreshList() {
        itemList.clear();
        itemList.addAll(databaseHelper.getAllItems());
        adapter.notifyDataSetChanged();
    }
}
