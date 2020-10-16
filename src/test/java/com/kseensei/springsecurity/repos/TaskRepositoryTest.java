package com.kseensei.springsecurity.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.kseensei.springsecurity.models.Task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testTaskRepository() {

        // given

        Task task = new Task();
        task.setDescription("Lol");
        task.setName("Lol");
        entityManager.persist(task);
        entityManager.flush();

        // when

        Task taskFound = taskRepository.findByName("Lol");

        assertNotNull(taskFound.getId());
        assertEquals(taskFound.getName(), task.getName());
    }

}
