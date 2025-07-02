package com.example.tasksapp.TasksApp.core.storage;
 import android.content.Context;
 import android.content.SharedPreferences;

 import com.example.tasksapp.TasksApp.task.domain.Task;
 import com.google.common.reflect.TypeToken;
 import com.google.gson.Gson;

 import java.lang.reflect.Type;
 import java.util.ArrayList;

public class LocalGson{
    private static final String FILE_NAME = "tasks.json";
    private static final String KEY_TASK_LIST = "task_list";

    public static void saveTasks(Context context, ArrayList<Task> tasks){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(tasks);
        editor.putString(KEY_TASK_LIST, json);
        editor.apply();

    }
    public static ArrayList<Task> loadTasks(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(KEY_TASK_LIST, null);
        if(json == null)
            return new ArrayList<>();
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Task>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
