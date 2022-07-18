package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinderResponse;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/properties")
public class ViewPropertyGetController {

    @Autowired
    private PropertyFinder finder;

    @GetMapping(value="/{propertyId}")
    public ResponseEntity<HashMap> execute(@PathVariable("propertyId") String id) throws JsonProcessingException {
        System.out.println("Propiedad solicitdad");
        PropertyFinderResponse response = new PropertyFinderResponse(finder.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(PropertyNotExist.class)
    public ResponseEntity<HashMap> handlerPropertyNotExist(PropertyNotExist exception){
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
