package com.example.tasksapp.TasksApp.task.domain;

import android.content.Context;
import android.graphics.Color;

import com.example.tasksapp.R;
import com.example.tasksapp.TasksApp.core.utils.Utils;

public class Task{
    public final String DEFAULT_CATEGORY = "General";
    public final Utils.Priority DEFAULT_PRIORITY = Utils.Priority.Medium;
    public final String DEFAULT_STATUS = "Not Completed";
    public final String DEFAULT_DESCRIPTION = "No Description";
    public final String DEFAULT_DEADLINE = "No Deadline";
    public final String DEFAULT_TITLE = "Task";
    public final String DEFAULT_FILES = "No Files";
    public final String DEFAULT_DATE = "Today";

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
    public Task(){ // TODO: complete empty constructor
        _id = 0;
        _creationDate = DEFAULT_DATE;
        _deadline = DEFAULT_DEADLINE;
        _title = DEFAULT_TITLE;
        _description = DEFAULT_DESCRIPTION;
        _isCompleted = false;
        _attachedFiles = DEFAULT_FILES;
        _priority = DEFAULT_PRIORITY;
        _category = DEFAULT_CATEGORY;
    }

    public String getTitle(){
        return _title;
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
