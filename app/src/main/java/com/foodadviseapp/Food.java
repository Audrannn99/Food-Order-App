package com.foodadviseapp;

import java.util.ArrayList;

public  class Food {
    String name;
    float price,rate;
    int cookingTime;
    int imageResourceId;

    public Food(String name, int cookingTime ,
                int price,float rate,int imageResourceId) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.imageResourceId = imageResourceId;
        this.price = price;
        this.rate = rate;
    }
}
