package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class AppointmentProperty {

    private String propertyId;
    private String address;
    private String propertyType;
    private String city;
    private long latitude;
    private long longitude;

    public AppointmentProperty(String propertyId,
                               String address,
                               String propertyType,
                               String city,
                               long latitude,
                               long longitude) {
        this.propertyId = propertyId;
        this.address = address;
        this.propertyType = propertyType;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AppointmentProperty() {
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", propertyId);
            put("address", address);
            put("type", propertyType);
            put("city", city);
            put("latitude", latitude);
            put("longitude", longitude);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentProperty that = (AppointmentProperty) o;
        return latitude == that.latitude && longitude == that.longitude && Objects.equals(propertyId, that.propertyId) && Objects.equals(address, that.address) && Objects.equals(propertyType, that.propertyType) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, address, propertyType, city, latitude, longitude);
    }

    public String getPropertyId() {
        return propertyId;
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

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }
}
