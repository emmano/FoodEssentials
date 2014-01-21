package com.foodessentials.utils.labelapi;

import java.util.List;

/**
 * Created by ortiguelae on 1/19/14.<br>
 */
public class Product {

    private List<Nutrient> mNutrients;

    private List<Allergen> mAllergens;

    private List<Additives> mAdditives;

    public String mCompanyName;

    public String mServingSize;

    public String mProductName;

    public String mFoodCategory;
    public boolean mContainsGluten;


    public List<Additives> getAdditives() {
        return mAdditives;
    }

    public void setAdditives(List<Additives> additives) {
        mAdditives = additives;
    }

    public List<Allergen> getAllergens() {
        return mAllergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        mAllergens = allergens;
    }

    public List<Nutrient> getNutrients() {
        return mNutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        mNutrients = nutrients;
    }
}
