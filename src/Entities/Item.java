package Entities;

import java.util.Date;

public class Item {

    private int id;
    private String name;
    private String model;
    private double value;
    private int quantity;
    private String expiryDate;

    public Item(int id, String name, String model, double value, int quantity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.value = value;
        this.quantity = quantity;
//        this.expiryDate = expiryDate;
    }

    public Item(int id, String name, String model, double value, int quantity, String expiryDate) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.value = value;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item(String name, String model, double value, int quantity, String expiryDate) {
        this.name = name;
        this.model = model;
        this.value = value;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Item(String name, String model, double value, int quantity) {
        this.name = name;
        this.model = model;
        this.value = value;
        this.quantity = quantity;
//        this.expiryDate = expiryDate;
    }

    public Item() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

}
