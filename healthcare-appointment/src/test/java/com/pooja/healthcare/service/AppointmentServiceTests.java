package com.pooja.healthcare.service;

import com.pooja.healthcare.domain.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceTests {

    @DisplayName("Domain : Checking Object Creation")
    @Test
    void testObjectCreation() {
        var appointment = new Appointment();
        Assertions.assertNotNull(appointment);
    }

    @Autowired
    private AppointmentServiceImpl service;
    @DisplayName("service : Appointment by type :")
    @Test
    public void testAppointmentByType(){
        var op = service.findAppointmentByType("opd");
        Assertions.assertNotNull(op.get(1));
    }

}
