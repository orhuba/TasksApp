package com.example.tasksapp.TasksApp.task.domain;

import android.content.Context;
import android.graphics.Color;

import com.example.tasksapp.R;
import com.example.tasksapp.TasksApp.core.utils.Utils;

public class Task{
    public static final long FIRST_TASK_ID = 10000;
    public static final String DEFAULT_CATEGORY = "General";
    public static final Utils.Priority DEFAULT_PRIORITY = Utils.Priority.Medium;
    public static final String DEFAULT_STATUS = "Not Completed";
    public static final String DEFAULT_DESCRIPTION = "No Description";
    public static final String DEFAULT_DEADLINE = "No Deadline";
    public static final String DEFAULT_TITLE = "Task";
    public static final String DEFAULT_FILES = "No Files";
    public static final String DEFAULT_DATE = "Today";

    public static int tasksCount = 0;
    private long _id;
    private String _creationDate; //dd:mm:yyyy
    private String _deadline; //dd:mm:yyyy
    private String _title;
    private String _description;
    private boolean _isCompleted;
    private String _attachedFiles;
    private Utils.Priority _priority;
    private String _category;

    // constructors
    public Task(long id, String creationDate, String deadline, String title, String description,
                boolean isCompleted, String attachedFiles, Utils.Priority priority, String category){
        _id = id;
        _creationDate = creationDate;
        _deadline = deadline;
        _title = title;
        _description = description;
        _isCompleted = isCompleted;
        _attachedFiles = attachedFiles;
        _priority = priority;
        _category = category;
    }
    public Task(){
        this(FIRST_TASK_ID+tasksCount,DEFAULT_DATE,DEFAULT_DEADLINE,DEFAULT_TITLE,DEFAULT_DESCRIPTION,
                false,DEFAULT_FILES, DEFAULT_PRIORITY,DEFAULT_CATEGORY);
        tasksCount++;
    }
    public Task(String taskTitle){
        this();
        _title = taskTitle;
    }

    public String getTitle(){
        return _title;
    }
    public long getId(){
        return _id;
    }


    public boolean isCompleted(){
        return _isCompleted;
    }
    public void changeStatus(){
        if(_isCompleted){
            _isCompleted = false;
        }
        else
            _isCompleted = true;
    }
}
