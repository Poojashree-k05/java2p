package com.pooja.healthcare.repository;

import com.pooja.healthcare.domain.Appointment;
import com.pooja.healthcare.dto.AppointmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
    public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByAppDateBetweenAndType(LocalDate start, LocalDate end,String type);

    }

