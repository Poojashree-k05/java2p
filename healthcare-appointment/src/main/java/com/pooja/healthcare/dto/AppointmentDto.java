package com.pooja.healthcare.dto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
    @Setter
    @Getter
    public class AppointmentDto {
        private Long id;
        @NotNull
        @NotBlank
        private String type;
        private LocalDate pldDate;
        private LocalDate appDate;
        private String docNm;

    }

