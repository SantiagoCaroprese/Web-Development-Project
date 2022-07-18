package com.javeriana.web.project.Properties.Offer.Infrastructure.Controllers;


import com.javeriana.web.project.Properties.Offer.Application.DeleteOffer.OfferDeleter;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.PropertyNotMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public class DeleteOfferDeleteController {

    @Autowired
    private OfferDeleter offerDeleter;

    @DeleteMapping(value="/{propertyId}/offers/{offerId}")
    public ResponseEntity execute(@PathVariable("offerId") String offerId, @PathVariable("propertyId") String propertyId){
        offerDeleter.execute(offerId,propertyId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(OfferNotExist.class)
    public ResponseEntity<HashMap> handleOfferNotExist(OfferNotExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(PropertyNotMatch.class)
    public ResponseEntity<HashMap> handlePropertyNotMatch(PropertyNotMatch exception){
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
