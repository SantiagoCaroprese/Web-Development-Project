package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Property.Application.Update.PropertyModifier;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public class EditPropertyPutController {

    @Autowired
    private PropertyModifier modifier;

    @PutMapping(value = "/{propertyId}")
    public ResponseEntity execute(@RequestBody Request request, @PathVariable("propertyId") String id){
        modifier.execute(id,request.getAddress(),request.getPropertyType(),request.getCity(),request.getDescription(),request.getBedroomsNumber(),request.getBathroomsNumber(),request.getPrivateArea(),request.getBuiltArea(),request.getServiceLevel(),request.getCondition(),request.getDeliveryDateYear(), request.getDeliveryDateMonth(), request.getDeliveryDateDay(), request.getLatitude(),request.getLongitude());
        return ResponseEntity.status(HttpStatus.OK).body(null);
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
