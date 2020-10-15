package com.kseensei.springsecurity.mappers;

import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.models.dtos.TaskRequest;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomMapper {

    Task taskRequestToTask(TaskRequest source);

}
