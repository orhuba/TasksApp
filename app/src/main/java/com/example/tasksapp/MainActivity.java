package com.example.tasksapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

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
        Button addTaskButton = findViewById(R.id.addTaskButton);
        RecyclerView recyclerView = findViewById(R.id.TasksRecycleView);
        ArrayList<Task> tasks = new ArrayList<>();
        addTaskButton.setOnClickListener(v -> {
            /// /
        });
        for(int i=0; i<20; i++){
            tasks.add(new Task());
            tasks.get(i);
        }
        TasksRecycleViewAdapter adapter = new TasksRecycleViewAdapter(this, tasks);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}