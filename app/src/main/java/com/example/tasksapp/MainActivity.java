package com.example.tasksapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksapp.TasksApp.task.domain.Task;
import com.example.tasksapp.TasksApp.task.domain.TasksRecycleViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.TasksRecycleView);
        //int resource = android.R.layout.two_line_list_item;
        ArrayList<Task> tasks = new ArrayList<>();
        for(int i=0; i<20; i++){
            tasks.add(new Task());
            tasks.get(i);
        }
        TasksRecycleViewAdapter adapter = new TasksRecycleViewAdapter(this, tasks);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}