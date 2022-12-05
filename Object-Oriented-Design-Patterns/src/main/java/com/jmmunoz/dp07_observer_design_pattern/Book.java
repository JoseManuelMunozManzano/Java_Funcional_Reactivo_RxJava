package com.jmmunoz.dp07_observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject
public class Book implements SubjectLibrary {

    private String name;
    private String type;
    private double price;
    private String author;
    private String inStock;
    private List<Observer> obsList = new ArrayList<>();

    public Book(String name, String type, double price, String author, String inStock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.author = author;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        System.out.println("Availability changed from Sold out to Back in stock\n");
        notifyObserver();
    }

    public List<Observer> getObsList() {
        return obsList;
    }

    public void setObsList(List<Observer> obsList) {
        this.obsList = obsList;
    }

    @Override
    public void subscribeObserver(Observer ob) {
        obsList.add(ob);
    }

    @Override
    public void unsubscribeObserver(Observer ob) {
        obsList.remove(ob);
    }

    @Override
    public void notifyObserver() {
        System.out.println(
                "Book name: " + this.name +
                ", Book type: " + this.type +
                ", Price: " + this.price +
                ", Author: " + this.author +
                " is now " + this.inStock +
                ". So, please, notify all users.\n"
        );

        for (Observer o : obsList) {
            o.update(this.inStock);
        }
    }
}
