package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Controllers;

import com.javeriana.web.project.Appointments.Appointment.Application.Unassigned.UnassignedAppointmentsGetter;
import com.javeriana.web.project.Appointments.Appointment.Application.Unassigned.UnassignedAppointmentsResponse;
import com.javeriana.web.project.Employees.Employee.Application.Find.EmployeeFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/appointments")
public class ViewUnassignedAppointmentsGetController {

    @Autowired
    UnassignedAppointmentsGetter unassignedAppointmentsGetter;


    @GetMapping (value = "/unassigned")
    public ResponseEntity<List<HashMap>> execute() {
        UnassignedAppointmentsResponse response = new UnassignedAppointmentsResponse(unassignedAppointmentsGetter.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
