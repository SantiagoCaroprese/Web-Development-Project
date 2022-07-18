package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;

import java.util.HashMap;
import java.util.Objects;

public class SerializedOffer {

    private String offerId;
    private double price;
    private String action;

    public SerializedOffer() {
    }

    public SerializedOffer(String offerId, double price, String action) {
        this.offerId = offerId;
        this.price = price;
        this.action = action;
    }

    public HashMap<String,Object> data(){
        HashMap<String, Object> data= new HashMap<>(){{
            put("id",offerId);
            put("price",price);
            put("action",action);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializedOffer that = (SerializedOffer) o;
        return Objects.equals(offerId, that.offerId) && Objects.equals(price, that.price) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, price,action);
    }

    public boolean equalsSerializedOfferId(SerializedOffer serializedOffer){
        return this.offerId.equals((serializedOffer.getOfferId()));
    }

    public String getOfferId() {
        return offerId;
    }

    public double getPrice() {
        return price;
    }

    public String getAction() {
        return action;
    }
}
