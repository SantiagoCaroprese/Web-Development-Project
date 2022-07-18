package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Property.Application.Create.PropertyCreator;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public final class CreatePropertyPostController {

    @Autowired
    private PropertyCreator creator;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        creator.execute(request.getPropertyId(),request.getAddress(),request.getPropertyType(),request.getCity(),request.getDescription(),request.getBedroomsNumber(),request.getBathroomsNumber(),request.getPrivateArea(),request.getBuiltArea(),request.getServiceLevel(),request.getCondition(),request.getDeliveryDateYear(), request.getDeliveryDateMonth(), request.getDeliveryDateDay(), request.getLatitude(),request.getLongitude());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(PropertyAlreadyExist.class)
    public ResponseEntity<HashMap> handlePropertyAlreadyExist(PropertyAlreadyExist exception){
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

class Request {

    private String propertyId;
    private String address;
    private String propertyType;
    private String city;
    private String description;
    private int bedroomsNumber;
    private int bathroomsNumber;
    private int privateArea;
    private int builtArea;
    private int serviceLevel;
    private String condition;
    private float latitude;
    private float longitude;
    private int deliveryDateYear;
    private int deliveryDateMonth;
    private int deliveryDateDay;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBedroomsNumber() {
        return bedroomsNumber;
    }

    public void setBedroomsNumber(int bedroomsNumber) {
        this.bedroomsNumber = bedroomsNumber;
    }

    public int getBathroomsNumber() {
        return bathroomsNumber;
    }

    public void setBathroomsNumber(int bathroomsNumber) {
        this.bathroomsNumber = bathroomsNumber;
    }

    public int getPrivateArea() {
        return privateArea;
    }

    public void setPrivateArea(int privateArea) {
        this.privateArea = privateArea;
    }

    public int getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(int builtArea) {
        this.builtArea = builtArea;
    }

    public int getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(int serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getDeliveryDateYear() {
        return deliveryDateYear;
    }

    public void setDeliveryDateYear(int deliveryDateYear) {
        this.deliveryDateYear = deliveryDateYear;
    }

    public int getDeliveryDateMonth() {
        return deliveryDateMonth;
    }

    public void setDeliveryDateMonth(int deliveryDateMonth) {
        this.deliveryDateMonth = deliveryDateMonth;
    }

    public int getDeliveryDateDay() {
        return deliveryDateDay;
    }

    public void setDeliveryDateDay(int deliveryDateDay) {
        this.deliveryDateDay = deliveryDateDay;
    }
}
