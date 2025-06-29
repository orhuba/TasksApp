package com.example.tasksapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        //int resource = android.R.layout.two_line_list_item;
        String[] tasks = {"Task 1", "Task 2", "Task 3", "Task 4", "Task 5", "Task 6", "Task 7", "Task 8", "Task 9", "Task 10", "Task 11", "Task 12"
        , "Task 13", "Task 14", "Task 15", "Task 16", "Task 17", "Task 18", "Task 19", "Task 20", "Task 21", "Task 22", "Task 23", "Task 24", "Task 25"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked,tasks);
        listView.setAdapter(adapter);

    }
}