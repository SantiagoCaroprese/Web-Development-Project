package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.Find.EmployeeFinder;
import com.javeriana.web.project.Employees.Employee.Application.Find.EmployeeFinderResponse;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/employees")
public class ViewEmployeeGetController {
    @Autowired
    private EmployeeFinder finder;

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<HashMap> execute(@PathVariable("employeeId") String id){
        EmployeeFinderResponse response = new EmployeeFinderResponse(finder.execute(id));
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
