package com.kseensei.springsecurity.mappers;

import com.kseensei.springsecurity.models.Task;
import com.kseensei.springsecurity.models.dtos.TaskRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomMapper {

    // CustomMapper INSTANCE = Mappers.getMapper(CustomMapper.class);

    @Mapping(target = "id", ignore = true)
    Task taskRequestToTask(TaskRequest source);

}
