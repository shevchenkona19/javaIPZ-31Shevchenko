package com.company;

public class Plumbing {
    private String id;
    private String look;
    private String firm;
    private String name;
    private int quantity;
    private int price;
    private String model;

    public Plumbing(String id, String look, String firm, String name, int quantity, int price, String model) {
        this.id = id;
        this.look = look;
        this.firm = firm;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.model = model;
    }

    public Plumbing() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-10s%-30s%-15s%-10d%-10d", id, firm, model, name, look, quantity, price);
    }
}
