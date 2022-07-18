package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.Update.EmployeeModifier;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/employees")
public class EditEmployeePutController {

    @Autowired
    private EmployeeModifier modifier;

    @PutMapping(value="/{employeeId}")
    public ResponseEntity execute(@RequestBody Request request,@PathVariable("employeeId") String id){
        modifier.execute(id,request.getEmployeeEmail(),request.getEmployeePassword(),request.getEmployeeFirstName(),request.getEmployeeLastName(),request.isEmployeeIsAdministrator());
        return ResponseEntity.status(HttpStatus.OK).body(null);
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
