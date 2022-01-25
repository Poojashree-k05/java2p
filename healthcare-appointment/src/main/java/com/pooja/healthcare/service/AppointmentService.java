package com.pooja.healthcare.service;

import com.pooja.healthcare.dto.AppointmentDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    public AppointmentDto createAppointment(AppointmentDto dto);


    LocalDate updateAppDate(Long id, LocalDate appDate,String type);

    String cancelAppointment(Long id, String type);

    List<AppointmentDto> findAppointmentByType(String type);

    public List<AppointmentDto> getTypeBetweenDates(LocalDate start, LocalDate end,String type);

}