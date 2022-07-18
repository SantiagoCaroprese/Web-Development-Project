package com.javeriana.web.project.Properties.Offer.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Offer.Application.CreateOffer.OfferCreator;
import com.javeriana.web.project.Properties.Offer.Application.FindOffer.OfferFinder;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferAlreadyExist;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.PropertyNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public class AddOfferPostController {

    @Autowired
    private OfferCreator offerCreator;

    @PostMapping(value="/{propertyId}/offers")
    public ResponseEntity execute(@RequestBody Request request, @PathVariable("propertyId") String propertyId){
        offerCreator.execute(request.getOfferId(),propertyId,request.getPrice(),request.getAction());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(OfferAlreadyExist.class)
    public ResponseEntity<HashMap> handleOfferAlreadyExist(OfferAlreadyExist exception) {
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(PropertyNotFound.class)
    public ResponseEntity<HashMap> handlePropertyNotFound(PropertyNotFound exception){
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

    private String offerId;
    private int price;
    private String action;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}