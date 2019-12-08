package com.example.inventoryhome;

public class Item {
    //*** Delcare all our fields
    private int id;
    private String name;
    private String price;
    private String dateOfPurchase;
    private String location;
    private String description;
    private byte[] image;

    public Item(String name, String price, String dateOfPurchase, String location, String description, byte[] image, int id) {
        //**********
        this.name = name;
        this.price = price;
        this.image = image;
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.location = location;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    //Getting the dates
    public String getDateOfPurchase() {return dateOfPurchase;}

    public void setDateOfPurchase(String dateOfPurchase) {this.dateOfPurchase = dateOfPurchase;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

}
