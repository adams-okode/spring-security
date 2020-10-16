package com.kseensei.springsecurity.repos;

import com.kseensei.springsecurity.models.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByName(String string);

}
