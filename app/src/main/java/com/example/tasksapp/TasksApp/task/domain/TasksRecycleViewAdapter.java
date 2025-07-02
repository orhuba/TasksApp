package com.example.tasksapp.TasksApp.task.domain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksapp.R;

import java.util.ArrayList;

public class TasksRecycleViewAdapter extends RecyclerView.Adapter<TasksRecycleViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Task> tasks;


    public TasksRecycleViewAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }
    @NonNull
    @Override
    public TasksRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this is where you inflate the layout (giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.task_recycleview_row, parent, false);
        return new TasksRecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksRecycleViewAdapter.ViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view
        Task task = tasks.get(position);
        holder.textView.setText(tasks.get(position).getTitle());
        int white = this.context.getResources().getColor(R.color.white, null);
        int green = this.context.getResources().getColor(R.color.green, null);
        if(task.isCompleted())
            holder.button.setBackgroundColor(green);
        else
            holder.button.setBackgroundColor(white);
        holder.button.setOnClickListener(v -> {
            task.changeStatus();
            //holder.button.setBackgroundColor(green);
            notifyItemChanged(position);

            //holder.button.setBackgroundColor(tasks.get(position).getCompleteButtomColor());
        });


    }

    @Override
    public int getItemCount() {
        // how many rows will be in the list
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView textView;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            // we simply hold our views here
            // that will allow us to access them later
            super(itemView);
            textView = itemView.findViewById(R.id.taskName);
            button = itemView.findViewById(R.id.button2);

        }
    }
}
