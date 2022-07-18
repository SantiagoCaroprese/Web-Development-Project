package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javeriana.web.project.Properties.Offer.Application.filterOffers.FilterOffers;
import com.javeriana.web.project.Properties.Property.Application.FilterProperties.FilterProperties;
import com.javeriana.web.project.Properties.Property.Application.FilterProperties.FilterPropertiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class FilterPropertiesGetController {

    @Autowired
    FilterProperties filterProperties;

    @Autowired
    FilterOffers filterOffers;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap> execute(
                                           @RequestParam(defaultValue = "") String propertyType,
                                           @RequestParam(defaultValue = "0") int priceLowerLimit,
                                           @RequestParam(defaultValue = "0")  int priceUpperLimit,
                                           @RequestParam(defaultValue = "Bogota")  String city,
                                           @RequestParam(defaultValue = "0")  int bedRoomsNumber,
                                           @RequestParam(defaultValue = "0")  int bathRoomNumber,
                                           @RequestParam(defaultValue = "")  String action,
                                           @RequestParam(defaultValue = "") String propertyCondition
    ) throws JsonProcessingException {

        List<String> propiedades = filterOffers.execute(priceLowerLimit,priceUpperLimit,action);
        FilterPropertiesResponse response = new FilterPropertiesResponse(filterProperties.execute(propiedades, propertyType,city,
                bedRoomsNumber,bathRoomNumber,propertyCondition));
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
