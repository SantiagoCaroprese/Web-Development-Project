package com.javeriana.web.project.Shared.Domain.Properties;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public final class PropertyModifierDomainEvent extends DomainEvent {

    private final String address;
    private final String propertyType;
    private final String city;
    private final String description;
    private final int bedroomsNumber;
    private final int bathroomsNumber;
    private final int privateArea;
    private final int builtArea;
    private final int serviceLevel;
    private final String condition;
    private final LocalDate deliveryDate;
    private final float latitude;
    private final float longitude;

    public PropertyModifierDomainEvent() {
        super(null);
        this.address = "";
        this.propertyType = "";
        this.city = "";
        this.description = "";
        this.bedroomsNumber = 0;
        this.bathroomsNumber = 0;
        this.privateArea = 0;
        this.builtArea = 0;
        this.serviceLevel = 0;
        this.condition = "";
        this.deliveryDate = LocalDate.of(0,0,0);
        this.latitude = 0;
        this.longitude = 0;
    }

    public PropertyModifierDomainEvent(String aggregateId, String address, String propertyType, String city, String description, int bedroomsNumber, int bathroomsNumber, int privateArea, int builtArea, int serviceLevel, String condition, LocalDate deliveryDate, float latitude, float longitude) {
        super(aggregateId);
        this.address = address;
        this.propertyType = propertyType;
        this.city = city;
        this.description = description;
        this.bedroomsNumber = bedroomsNumber;
        this.bathroomsNumber = bathroomsNumber;
        this.privateArea = privateArea;
        this.builtArea = builtArea;
        this.serviceLevel = serviceLevel;
        this.condition = condition;
        this.deliveryDate = deliveryDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PropertyModifierDomainEvent(String aggregateId, String eventId, String occurredOn, String address, String propertyType, String city, String description, int bedroomsNumber, int bathroomsNumber, int privateArea, int builtArea, int serviceLevel, String condition, LocalDate deliveryDate, float latitude, float longitude) {
        super(aggregateId, eventId, occurredOn);
        this.address = address;
        this.propertyType = propertyType;
        this.city = city;
        this.description = description;
        this.bedroomsNumber = bedroomsNumber;
        this.bathroomsNumber = bathroomsNumber;
        this.privateArea = privateArea;
        this.builtArea = builtArea;
        this.serviceLevel = serviceLevel;
        this.condition = condition;
        this.deliveryDate = deliveryDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public int getBedroomsNumber() {
        return bedroomsNumber;
    }

    public int getBathroomsNumber() {
        return bathroomsNumber;
    }

    public int getPrivateArea() {
        return privateArea;
    }

    public int getBuiltArea() {
        return builtArea;
    }

    public int getServiceLevel() {
        return serviceLevel;
    }

    public String getCondition() {
        return condition;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    @Override
    public String eventName() {
        return "property.modifier";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("address",address);
            put("type",propertyType);
            put("city",city);
            put("bedRooms",bedroomsNumber);
            put("badRooms",bathroomsNumber);
            put("privateArea",privateArea);
            put("builtArea",builtArea);
            put("serviceLevel",serviceLevel);
            put("condition",condition);
            put("deliveryDate",deliveryDate);
            put("latitude",latitude);
            put("longitude",longitude);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PropertyModifierDomainEvent(aggregateId,eventId,occurredOn,
                body.get("address").toString(),body.get("type").toString(),
                (int)body.get("bedRooms"),(int)body.get("badRooms"),
                (int)body.get("privateArea"),(int)body.get("builtArea"),
                (int)body.get("serviceLevel"),body.get("condition").toString(),
                (LocalDate) body.get(deliveryDate),(float)body.get("latitude"),
                (float)body.get("longitude"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyModifierDomainEvent that = (PropertyModifierDomainEvent) o;
        return bedroomsNumber == that.bedroomsNumber && bathroomsNumber == that.bathroomsNumber && privateArea == that.privateArea && builtArea == that.builtArea && serviceLevel == that.serviceLevel && Float.compare(that.latitude, latitude) == 0 && Float.compare(that.longitude, longitude) == 0 && Objects.equals(address, that.address) && Objects.equals(propertyType, that.propertyType) && Objects.equals(city, that.city) && Objects.equals(description, that.description) && Objects.equals(condition, that.condition) && Objects.equals(deliveryDate, that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, propertyType, city, description, bedroomsNumber, bathroomsNumber, privateArea, builtArea, serviceLevel, condition, deliveryDate, latitude, longitude);
    }
}
