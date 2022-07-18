package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.Create.EmployeeCreator;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/employees")
public final class CreateEmployeePostController {
    @Autowired
    private EmployeeCreator creator;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        creator.execute(request.getEmployeeId(),request.getEmployeeEmail(),request.getEmployeePassword(),request.getEmployeeFirstName(),request.getEmployeeLastName(),request.isEmployeeIsAdministrator());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(EmployeeAlreadyExist.class)
    public ResponseEntity<HashMap> handleEmployeeAlreadyExist(EmployeeAlreadyExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}

class Request{
    private String employeeId;
    private String employeeEmail;
    private String employeePassword;
    private String employeeFirstName;
    private String employeeLastName;
    private boolean employeeIsAdministrator;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public boolean isEmployeeIsAdministrator() {
        return employeeIsAdministrator;
    }

    public void setEmployeeIsAdministrator(boolean employeeIsAdministrator) {
        this.employeeIsAdministrator = employeeIsAdministrator;
    }
}
