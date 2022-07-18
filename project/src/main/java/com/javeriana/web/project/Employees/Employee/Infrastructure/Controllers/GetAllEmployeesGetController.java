package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned.FindAssignedAppointmetsResponse;
import com.javeriana.web.project.Employees.Employee.Application.GetAll.EmployeesObtainer;
import com.javeriana.web.project.Employees.Employee.Application.GetAll.GetAllEmployeesResponse;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/employees")
public class GetAllEmployeesGetController {

    @Autowired
    private EmployeesObtainer employeesObtainer;

    @GetMapping()
    public ResponseEntity execute(){
        GetAllEmployeesResponse response = new GetAllEmployeesResponse(employeesObtainer.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(EmployeeNotExist.class)
    public ResponseEntity<HashMap> handlerEmployeeNotExist(EmployeeNotExist exception){
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
