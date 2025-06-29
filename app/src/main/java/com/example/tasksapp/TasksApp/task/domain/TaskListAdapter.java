package com.example.tasksapp.TasksApp.task.domain;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tasksapp.R;

import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Task> {
    Context context;
    private List<Task> tasks;
    public TaskListAdapter(Context context, List<Task> tasks){
        super(context, 0, tasks);
        this.context = context;
        this.tasks = tasks;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_task_item, parent, false);
        }
        Task task = tasks.get(position);
        TextView textView = convertView.findViewById(R.id.taskTitle);
        textView.setText(task.getTitle());
        Button button = convertView.findViewById(R.id.completeButton);
        button.setOnClickListener(v -> {
            task.setComleted();
            button.setBackgroundColor(context.getResources(). getColor(R.color.green, null));
            Toast.makeText(context, "Task completed", Toast.LENGTH_SHORT).show();
        });
        return convertView;
    }


}
