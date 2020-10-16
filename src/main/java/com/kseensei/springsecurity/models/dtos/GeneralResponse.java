package com.kseensei.springsecurity.models.dtos;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T> {

    private LocalDateTime time;
    private String message;
    private Integer code;
    private T data;

}
