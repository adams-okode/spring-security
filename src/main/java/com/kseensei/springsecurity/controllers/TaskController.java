package com.kseensei.springsecurity.controllers;

import java.util.List;

import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.models.dtos.TaskRequest;
import com.kseensei.springsecurity.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/task")
    public void createTask(TaskRequest taskRequest) {

        taskService.createTask(taskRequest);

    }

    @GetMapping(path = "/task")
    public List<Task> getTasks() {

        List<Task> findAll = taskService.getTasks();

        return findAll;

    }

    @PutMapping(path = "/task")
    public void updateTask(Long id, @RequestBody TaskRequest taskRequest) {

        taskService.updateTask(id, taskRequest);

    }

    @DeleteMapping(path = "/task")
    public void deleteTask(Long id) {

        taskService.deleteTask(id);

    }

}
