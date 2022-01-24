package com.pooja.healthcare.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class AppointmentTests {

    @DisplayName("Domain : Checking Object Creation")
    @Test
    void testObjectCreation() {
        var app = new Appointment();
        Assertions.assertNotNull(app);
    }

    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var app = new Appointment();
        app.setId(10L);
        app.setAppDate((LocalDate.of(2021,1,1)));
        app.setDocNm("xyz");
        Assertions.assertEquals(10, app.getId());
        Assertions.assertEquals(
                (LocalDate.of(2021,1,1)),
                app.getAppDate()
        );
        Assertions.assertEquals("xyz", app.getDocNm());
        Assertions.assertEquals(10, app.getId());
    }

}
