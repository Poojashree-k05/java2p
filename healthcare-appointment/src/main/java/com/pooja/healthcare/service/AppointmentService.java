package com.pooja.healthcare.service;

import com.pooja.healthcare.dto.AppointmentDto;
import com.pooja.healthcare.exception.AppointementAlreadyExisting;
import com.pooja.healthcare.exception.DateOutOfBound;
import com.pooja.healthcare.exception.InvalidIdException;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    public AppointmentDto createAppointment(AppointmentDto dto);

//    LocalDate setAppointment(Long id, LocalDate appointment,String type) throws DateOutOfBound, AppointmentAlreadyExisting;
    LocalDate updateAppDate(Long id, LocalDate appDate,String type);

    public void deleteAppointment(Long id) throws InvalidIdException;

    List<AppointmentDto> findAppointmentByType(String type);

    public List<AppointmentDto> getTypeBetweenDates(LocalDate start, LocalDate end,String type);

}