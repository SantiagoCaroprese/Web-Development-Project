package com.javeriana.web.project.Properties.Property.Application.FilterProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Shared.Application.Response;

import java.util.HashMap;
import java.util.List;

public class FilterPropertiesResponse implements Response {

    private List<Property> properties;

    public FilterPropertiesResponse(List<Property> properties) {
        this.properties = properties;
    }

    public HashMap response() throws JsonProcessingException {
        HashMap<String, HashMap<String, Object>> response = new HashMap<>();
        HashMap<String, Object> responseItem = new HashMap<>();
        int index = 0;
        for(Property p : properties){
            responseItem = p.data();
            response.put(String.valueOf(index),responseItem);
            index++;
        }
            return response;
    }
}
