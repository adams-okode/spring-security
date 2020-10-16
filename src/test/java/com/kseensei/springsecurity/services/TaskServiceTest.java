package com.kseensei.springsecurity.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.kseensei.springsecurity.mappers.CustomMapperImpl;
import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.repos.TaskRepository;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TaskServiceTest {

    @TestConfiguration
    static class TaskServiceTestContextConfiguration {

        @Bean
        public CustomMapperImpl customMapperImpl() {
            return new CustomMapperImpl();
        }

        @Bean
        public TaskService taskService() {
            return new TaskService();
        }
    }

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

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

        Mockito.when(taskRepository.findAll()).thenReturn(allTasks);

    }

    @Test
    public void testGetTasks() {
        List<Task> allTasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setDescription("Lol");
        task1.setName("Lol");

        allTasks.add(task1);

        Task task2 = new Task();
        task2.setDescription("Lol2");
        task2.setName("Lol2");

        allTasks.add(task2);

        List<Task> found = taskService.getTasks();

        assertEquals(found.size(), allTasks.size());

    }

    @Test
    public void updateTask() {

    }

}
