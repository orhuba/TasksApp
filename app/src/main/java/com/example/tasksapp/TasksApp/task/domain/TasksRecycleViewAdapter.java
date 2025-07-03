package com.example.tasksapp.TasksApp.task.domain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksapp.MainActivity;
import com.example.tasksapp.R;
import com.example.tasksapp.TasksApp.core.storage.LocalGson;

import java.util.ArrayList;

import kotlin.ranges.ULongProgression;

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

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull TasksRecycleViewAdapter.ViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view
        Task task = tasks.get(position);
        holder.textView.setText(tasks.get(position).getTitle());
        int white = this.context.getResources().getColor(R.color.white, null);
        int green = this.context.getResources().getColor(R.color.green, null);
        int gray = this.context.getResources().getColor(R.color.gray);
        if(task.isCompleted())
            holder.completeButton.setBackgroundColor(green);
        else
            holder.completeButton.setBackgroundColor(white);
        holder.completeButton.setOnClickListener(v -> {
            task.changeStatus();
            notifyItemChanged(position);
            LocalGson.saveTasks(this.context, tasks);
        });
        holder.longPressListener.setOnLongClickListener(v -> {
            holder.longPressListener.setBackgroundColor(gray);
            notifyItemChanged(position);
            PopupMenu topToolBar = new PopupMenu(this.context, v);
            topToolBar.getMenuInflater().inflate(R.menu.top_tool_bar,topToolBar.getMenu());
            topToolBar.setOnMenuItemClickListener(menuItem -> {
                if(menuItem.getTitle() == "Delete")
                    Toast.makeText(this.context, "Task has been deleted! ", Toast.LENGTH_SHORT).show();
                else if(menuItem.getTitle() == "Edit")
                    Toast.makeText(this.context, "please edit the task ", Toast.LENGTH_SHORT).show();
                return true;
            });
            topToolBar.show();
            return true;
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
        TextView longPressListener;
        Button completeButton;

        public ViewHolder(@NonNull View itemView) {
            // we simply hold our views here
            // that will allow us to access them later
            super(itemView);
            textView = itemView.findViewById(R.id.taskName);
            completeButton = itemView.findViewById(R.id.button2);
            longPressListener = itemView.findViewById(R.id.longPressListener);

        }
    }
}
