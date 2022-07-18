package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class Image{

    private String imageId;
    private String image;

    public Image() {
    }

    public Image(String imageId, String image) {
        this.imageId = imageId;
        this.image = image;
    }

    public String value(){
        return this.image;
    }

    public HashMap<String,Object> data(){
        HashMap<String, Object> data= new HashMap<>(){{
           put("id",imageId);
            put("image",image);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image1 = (Image) o;
        return Objects.equals(imageId, image1.imageId) && Objects.equals(image, image1.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, image);
    }

    public String getImageId() {
        return imageId;
    }

    public String getImage() {
        return image;
    }

    public boolean equalsId(String imageId) {
        if(this.image.equals(imageId)){
            return true;
        }
        return false;
    }
}
