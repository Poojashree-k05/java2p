package com.pooja.healthcare.service;

import com.pooja.healthcare.domain.Appointment;
import com.pooja.healthcare.dto.AppointmentDto;
import com.pooja.healthcare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {
        var app = new Appointment();
        app.setId(dto.getId());
        app.setType(dto.getType());
        app.setPldDate(dto.getPldDate());
        app.setAppDate(dto.getAppDate());
        app.setDocNm(dto.getDocNm());
        repository.save(app);
        return dto;
    }
    @Override
    public LocalDate setAppDate(Long id, LocalDate appointment) {
        Optional<Appointment> op =repository.findById(id);
        Appointment apOld = op.orElseThrow();
        LocalDate existingAppointment = apOld.getAppDate();
        LocalDate newAppointment = appointment;
        Appointment apNew = new Appointment();
        apNew.setId(apOld.getId());
        apNew.setType(apOld.getType());
        apNew.setPldDate(apOld.getPldDate());
        apNew.setAppDate(apOld.getAppDate());
        apNew.setDocNm(apOld.getDocNm());
        repository.save(apNew);
        return apNew.getAppDate();
    }

    @Override
    public String cancelAppointment(Long id,String type){
        Optional<Appointment> op = repository.findById(id);
        Appointment baOld = op.orElseThrow();
        String existingType = baOld.getType();
        String newType= type;
        Appointment baNew = new Appointment();
        baNew.setAppDate(baOld.getAppDate());
        baNew.setId(baOld.getId());
        baNew.setType(newType);
        baNew.setPldDate(baOld.getPldDate());
        baNew.setDocNm(baOld.getDocNm());
        repository.save(baNew);
        return baNew.getType();
    }

    @Override
    public List<AppointmentDto> findAppointmentByType(String type) {

        List<Appointment> dto = repository.findAll();
        List<AppointmentDto> dto1 = dto.stream()
                .filter(n-> n.getType().equals(type))
                .map (app -> new AppointmentDto(
                        app.getId()
                        ,app.getType()
                        ,app.getPldDate()
                        ,app.getAppDate()
                        ,app.getDocNm()
                ))
                .collect(Collectors.toList());
        return dto1;
    }

    @Override
    public List<AppointmentDto> getTypeBetweenDates(LocalDate start, LocalDate end,String type) {
        List<Appointment> app = repository.findByAppDateBetweenAndType(start, end,type);
        List<AppointmentDto> appDto = new ArrayList<>();
        for (int i = 0; i < app.size(); i++) {
            Appointment apps = app.get(i);
            AppointmentDto dto = new AppointmentDto(
                    apps.getId(),
                    apps.getType(),
                    apps.getPldDate(),
                    apps.getAppDate(),
                    apps.getDocNm()
            );
            appDto.add(dto);
        }
        return appDto;
    }
}