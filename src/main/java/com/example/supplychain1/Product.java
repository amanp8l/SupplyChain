package com.example.supplychain1;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Product {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;

    Product(int id, String name, double price){
        this.id =new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }
    public ObservableList<Product> getAllProducts(){
       DatabaseConnection dbConn =new DatabaseConnection();
       ObservableList<Product> data = FXCollections.observableArrayList();
       String selectALLProduct = "Select * from product";
       try{
           ResultSet rs = dbConn.getQueryTable(selectALLProduct);
           while(rs.next()){

           }
       }catch(Exception e){
           e.printStackTrace();
       }
       return data;
    }
    public int getId(){
        return id.get();
    }
    public String getName(){
        return name.get();
    }
    public double getPrice(){
        return price.get();
    }
}
