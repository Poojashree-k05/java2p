package com.pooja.healthcare.controller;

import com.pooja.healthcare.domain.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerTests {

    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    @DisplayName("Get - Appointment - Checking Object Is non null")
    @Test
    public void testGetMethod(){

        String url = "http://"+"localhost"+":"+port+"/appointment";
        Appointment appointment = template.getForObject(url, Appointment.class);
        Assertions.assertNotNull(appointment);
    }

    @DisplayName("Put - Appointment - deleting a  appointment")
    @Test
    public void testDeleteMethod(){
        String url = "http://" + "localhost"+":"+port+"/appointment";
        template.delete(url);
    }
}
