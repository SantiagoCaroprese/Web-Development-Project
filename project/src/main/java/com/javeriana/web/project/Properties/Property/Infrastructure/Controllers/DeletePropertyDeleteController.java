package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Property.Application.Delete.PropertyDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public final class DeletePropertyDeleteController {

    @Autowired
    private PropertyDeleter deleter;

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{propertyId}")
    public ResponseEntity execute(@PathVariable("propertyId") String id){
        deleter.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
