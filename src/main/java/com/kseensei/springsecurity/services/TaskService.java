package com.kseensei.springsecurity.services;

import java.util.List;
import java.util.Optional;

import com.kseensei.springsecurity.mappers.CustomMapper;
import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.models.dtos.TaskRequest;
import com.kseensei.springsecurity.repos.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CustomMapper customMapper;

    public void createTask(TaskRequest taskRequest) {

        Task taskRequestToTask = customMapper.taskRequestToTask(taskRequest);

        taskRepository.save(taskRequestToTask);

    }

    public List<Task> getTasks() {

        List<Task> findAll = taskRepository.findAll();

        return findAll;

    }

    public void updateTask(Long id, TaskRequest taskRequest) {

        Optional<Task> findById = taskRepository.findById(id);

        if (findById.isPresent()) {
            Task task = findById.get();
            task.setDescription(taskRequest.getDescription());
            task.setName(taskRequest.getName());
            taskRepository.save(task);
        }

    }

    public void deleteTask(Long id) {

        taskRepository.deleteById(id);

    }

}
