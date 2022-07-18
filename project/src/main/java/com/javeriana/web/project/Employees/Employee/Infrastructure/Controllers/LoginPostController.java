package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.Login.EmployeeLogin;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeAlreadyExist;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.WrongCredentials;
import com.javeriana.web.project.Shared.Domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class LoginPostController {

    @Autowired
    EmployeeLogin employeeLogin;

    @PostMapping(value = "/login")
    public ResponseEntity<Token> execute(@RequestBody Request request) {
        Token token = employeeLogin.execute(request.getEmail(), request.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @ExceptionHandler(WrongCredentials.class)
    public ResponseEntity<HashMap> handleWrongCredentials(WrongCredentials exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            exception.printStackTrace();
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    static class Request {
        private String email;
        private String password;

        public Request() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
