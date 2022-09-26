package com.kbe.shoppingapp.model;

public class CartItem {
    
    private String productID;
    private int quantity;

    CartItem(){}
    
    CartItem(Product p){
        this.productID = p.getId();
        this.quantity = 1;
    }

    public String getProductID(){
        return this.productID;
    }

    public void setProductID(Product p){
        this.productID = p.getId();
    }

    public int getQuantity(){
        return this.quantity;
    }



}
