package com.pooja.healthcare.domain;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        @NotBlank
        @Column(unique = false, nullable = false)
        private String type;

        @Column(unique = false, nullable = false)
        private LocalDate pldDate;

        @Column(unique = false, nullable = false)
        private LocalDate appDate;

        @Column(unique = true, nullable = true)
        private String docNm;
    }

