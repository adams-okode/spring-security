package com.kseensei.springsecurity.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Null;

import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.models.dtos.GeneralResponse;
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
    public GeneralResponse<Null> createTask(TaskRequest taskRequest) {

        taskService.createTask(taskRequest);

        LocalDateTime time = LocalDateTime.now().plusHours(3);

        GeneralResponse<Null> gen = new GeneralResponse<Null>(time, "Success", 200, null);

        return gen;

    }

    @GetMapping(path = "/task")
    public GeneralResponse<List<Task>> getTasks() {

        List<Task> findAll = taskService.getTasks();

        LocalDateTime time = LocalDateTime.now().plusHours(3);

        GeneralResponse<List<Task>> gen = new GeneralResponse<List<Task>>(time, "Success", 200, findAll);

        return gen;

    }

    @PutMapping(path = "/task")
    public GeneralResponse<Null> updateTask(Long id, @RequestBody TaskRequest taskRequest) {

        taskService.updateTask(id, taskRequest);

        LocalDateTime time = LocalDateTime.now().plusHours(3);

        GeneralResponse<Null> gen = new GeneralResponse<Null>(time, "Success", 200, null);

        return gen;

    }

    @DeleteMapping(path = "/task")
    public GeneralResponse<Null> deleteTask(Long id) {

        taskService.deleteTask(id);

        LocalDateTime time = LocalDateTime.now().plusHours(3);

        GeneralResponse<Null> gen = new GeneralResponse<Null>(time, "Success", 200, null);

        return gen;

    }

}
