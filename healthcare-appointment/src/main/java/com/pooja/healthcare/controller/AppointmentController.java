package com.pooja.healthcare.controller;
import com.pooja.healthcare.domain.Appointment;
import com.pooja.healthcare.dto.AppResponse;
import com.pooja.healthcare.dto.AppointDto;
import com.pooja.healthcare.dto.AppointmentDto;
import com.pooja.healthcare.exception.AppointementAlreadyExisting;
import com.pooja.healthcare.exception.DateOutOfBound;
import com.pooja.healthcare.exception.DuplicateException;
import com.pooja.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/appointment")
    @RestController
    public class AppointmentController {

        @Autowired
        private AppointmentService service;

    @PostMapping
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@Valid @RequestBody AppointmentDto dto) throws DuplicateException {
        var svObj = service.createAppointment(dto);

        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Appointment saved successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateAppoint")
    public ResponseEntity<AppResponse<String>> updateAppDate(@RequestBody AppointmentDto dto) {
        LocalDate stat = service.updateAppDate(dto.getId(), dto.getAppDate(),dto.getType());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is updated");
        response.setStatus("success");
        response.setBody(String.valueOf(stat));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<AppointmentDto>> deleteAppointment(@PathVariable("id") Long id){

        service.deleteAppointment(id);
        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Appointment deleted successfully");
        return ResponseEntity.ok(response);
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


