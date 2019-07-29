package com.example.putatoe;

import java.util.ArrayList;

public class Item {

  public int Id,discount;
        public String name,image;
    public boolean supportMultipleProductPurchase;
        private ArrayList<String> serviceProviders;


    public boolean isSupportMultipleProductPurchase() {
        return supportMultipleProductPurchase;
    }

    public void setSupportMultipleProductPurchase(boolean supportMultipleProductPurchase) {
        this.supportMultipleProductPurchase = supportMultipleProductPurchase;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(ArrayList<String> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
