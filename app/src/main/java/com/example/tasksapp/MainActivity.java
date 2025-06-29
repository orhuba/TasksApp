package com.example.tasksapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tasksapp.TasksApp.task.domain.Task;
import com.example.tasksapp.TasksApp.task.domain.TaskListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        //int resource = android.R.layout.two_line_list_item;
        List<Task> tasks = new ArrayList<>();
        for(int i=0; i<20; i++){
            tasks.add(new Task());
        }
        TaskListAdapter adapter = new TaskListAdapter(this, tasks);
        listView.setAdapter(adapter);

    }
}