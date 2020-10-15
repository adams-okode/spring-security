package com.kseensei.springsecurity.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class TaskRequest {

    private String name;

    private String description;

}
