package org.androidtown.dietapp;

import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

/**
 * Created by latitude7275 on 2017-09-14.
 */

public class FoodItem {
    public String category;
    public String name;
    public int calorie;
    public int fat;
    public int carbohydrate;
    public int protein;
    public String uid;

    public FoodItem() {


    }

    public FoodItem(String category, String name,int calorie, int carbohydrate, int protein, int fat) {
        uid= UUID.randomUUID().toString();
        this.category = category;
        this.name = name;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.calorie = calorie;
    }

    public void SendtoFirebase(DatabaseReference mRFood){
        mRFood.child(uid).setValue(this);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
