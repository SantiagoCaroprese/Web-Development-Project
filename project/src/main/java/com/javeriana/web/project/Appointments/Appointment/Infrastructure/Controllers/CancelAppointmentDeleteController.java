package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Controllers;

import com.javeriana.web.project.Appointments.Appointment.Application.Cancel.CancelAppointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Exceptions.AppointmentNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/appointments")
public class CancelAppointmentDeleteController {

    @Autowired
    CancelAppointment cancelAppointment;

    @DeleteMapping(value = "/{appointmentId}")
    public ResponseEntity execute(@PathVariable("appointmentId") String id){
        cancelAppointment.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AppointmentNotExist.class)
    public ResponseEntity<HashMap> handlerAppointmentNotExist(AppointmentNotExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
