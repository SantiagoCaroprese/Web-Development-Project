package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;


import com.javeriana.web.project.Properties.Property.Application.AddImage.ImageAdditive;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public class AddImagePostController {

    @Autowired
    private ImageAdditive imageAdditive;

    @PostMapping(value = "/{propertyId}/images")
    public ResponseEntity execute(@RequestBody AddImageRequest request,@PathVariable("propertyId") String propertyId){
        imageAdditive.execute(propertyId,request.getImage());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
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

class AddImageRequest {
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
