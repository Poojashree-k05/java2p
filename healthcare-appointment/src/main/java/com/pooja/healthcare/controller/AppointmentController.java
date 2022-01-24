package com.pooja.healthcare.controller;
import com.pooja.healthcare.domain.Appointment;
import com.pooja.healthcare.dto.AppResponse;
import com.pooja.healthcare.dto.AppointDto;
import com.pooja.healthcare.dto.AppointmentDto;
import com.pooja.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@RequestMapping("/appointment")
    @RestController
    public class AppointmentController {

        @Autowired
        private AppointmentService service;

        @PostMapping
        public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@RequestBody AppointmentDto dto) {
            var svObj = service.createAppointment(dto);
            var response = new AppResponse<AppointmentDto>();
            response.setStatus("success");
            response.setMessage("Appointment saved successfully");
            response.setBody(svObj);
            return ResponseEntity.ok(response);
        }

        @PutMapping("/SetAppointment")
        public ResponseEntity<AppResponse<LocalDate>> activate(@RequestBody AppointmentDto dto){
            LocalDate stat = service.setAppDate(dto.getId(),dto.getAppDate());
            var response = new AppResponse<LocalDate>();
            response.setStatus("success");
            response.setBody(stat);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }

         @PutMapping("/cancelAppointment")
         public ResponseEntity<AppResponse<String>> cancelAppointment(@RequestBody AppointmentDto dto) {
             String stat = service.cancelAppointment(dto.getId(), dto.getType());
             var response = new AppResponse<String>();
             response.setMessage("Appointment is cancelled");
             response.setStatus("success");
             response.setBody(stat);
             return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

        @GetMapping("/{type}")
        public ResponseEntity<AppResponse<List<AppointmentDto>>> findAppointmentByType(@PathVariable String type){

            var svObj = service.findAppointmentByType(type);
            var response = new AppResponse<List<AppointmentDto>>();
            response.setStatus("success");
            response.setMessage("Appointment by Type is successfully");
            response.setBody(svObj);
            return ResponseEntity.ok(response);
          }

          @GetMapping("/date")
          public ResponseEntity<AppResponse<List<AppointmentDto>>> findByAppDateBetween(@RequestBody AppointDto dto){
             var response=new AppResponse<List<AppointmentDto>>();
             response.setStatus("success");
             response.setMessage("List of appointment");
             response.setBody(service.getTypeBetweenDates(dto.getStart(),dto.getEnd(),dto.getType()));
             return  ResponseEntity.ok(response);
          }
    }


