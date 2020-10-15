package com.kseensei.springsecurity.services;

import com.kseensei.springsecurity.models.dtos.TaskRequest;
import com.kseensei.springsecurity.repos.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(TaskRequest taskRequest) {

        taskRepository.save()

    }

    public void getTasks() {

    }

    public void updateTask() {

    }

    public void deleteTask() {

    }

}
