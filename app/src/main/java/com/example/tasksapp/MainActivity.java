package com.example.tasksapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksapp.TasksApp.core.storage.LocalGson;
import com.example.tasksapp.TasksApp.task.domain.Task;
import com.example.tasksapp.TasksApp.task.domain.TasksRecycleViewAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button addTaskButton = findViewById(R.id.addTaskButton);
        RecyclerView recyclerView = findViewById(R.id.TasksRecycleView);
        ArrayList<Task> tasks = LocalGson.loadTasks(this);
        //show tasks
        TasksRecycleViewAdapter adapter = new TasksRecycleViewAdapter(this, tasks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //add task button
        addTaskButton.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            View view = getLayoutInflater().inflate(R.layout.task_adding_sheet_dialog,null);
            bottomSheetDialog.setContentView(view);
            EditText editText = bottomSheetDialog.findViewById(R.id.taskTitleEditor);
            Button saveTaskButton = bottomSheetDialog.findViewById(R.id.saveTaskButton);
            saveTaskButton.setOnClickListener(v1 -> {
                tasks.add(new Task(editText.getText().toString()));
                bottomSheetDialog.dismiss();
                adapter.notifyDataSetChanged();
            });
            bottomSheetDialog.show();
        });
        LocalGson.saveTasks(this, tasks);
    }
}