package com.pooja.healthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@Setter
@Getter
public class AppointDto {

    private LocalDate start;
    private LocalDate end;
    private String type;
}
