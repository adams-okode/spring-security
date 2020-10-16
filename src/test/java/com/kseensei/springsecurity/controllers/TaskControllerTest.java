package com.kseensei.springsecurity.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.models.dtos.GeneralResponse;
import com.kseensei.springsecurity.services.TaskService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService taskService;

    Logger logger = LoggerFactory.getLogger(TaskControllerTest.class);

    @Before
    public void setUp() {

        List<Task> allTasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setDescription("Lol");
        task1.setName("Lol");

        allTasks.add(task1);

        Task task2 = new Task();
        task2.setDescription("Lol2");
        task2.setName("Lol2");

        allTasks.add(task2);

        Mockito.when(taskService.getTasks()).thenReturn(allTasks);

    }

    @Test
    public void getTasks() throws Exception {

        // Employee alex = new Employee("alex");

        // List<Employee> allEmployees = Arrays.asList(alex);

        // given(service.getAllEmployees()).willReturn(allEmployees);

        List<Task> allTasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setDescription("Lol");
        task1.setName("Lol");

        allTasks.add(task1);

        Task task2 = new Task();
        task2.setDescription("Lol2");
        task2.setName("Lol2");

        allTasks.add(task2);

        RequestBuilder builder = MockMvcRequestBuilders.get("/task");
        String response = mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
                .getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        GeneralResponse<List<Task>> gen = objectMapper.readValue(response, GeneralResponse.class);

        logger.info("response = {}", response);

        assertEquals(((List<Task>) gen.getData()).size(), allTasks.size());
    }

}
