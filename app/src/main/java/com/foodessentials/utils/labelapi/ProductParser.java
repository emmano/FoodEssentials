package com.foodessentials.utils.labelapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ortiguelae on 1/19/14.<br>
 */
public class ProductParser {


    public static final List<Product> parseProduct(JSONObject jObject) {

        String mCompanyName;
        String mServingSize;
        String mProductName;
        String mFoodCategory;
        String mServingSizeUOM;
        List<Product> productList = new ArrayList<Product>();
        List<Nutrient> listNutrient;
        List<Allergen> listAllergen;
        List<Additives> listAdditive;
        boolean mContainsGluten = false;
        try {

            for (int productsCounter = 0; productsCounter < jObject.getInt("resultSize");
                    productsCounter++) {
                listNutrient = new ArrayList<Nutrient>();
                listAllergen = new ArrayList<Allergen>();
                listAdditive = new ArrayList<Additives>();
                mFoodCategory = jObject.getJSONArray("productsArray").getJSONObject(productsCounter)
                        .getString("food_category");
                mServingSize = jObject.getJSONArray("productsArray").getJSONObject(productsCounter)
                        .getString("serving_size");
                mServingSizeUOM = jObject.getJSONArray("productsArray")
                        .getJSONObject(productsCounter)
                        .getString("serving_size_uom");
                mProductName = jObject.getJSONArray("productsArray").getJSONObject(productsCounter)
                        .getString("product_name");
                mCompanyName = jObject.getJSONArray("productsArray").getJSONObject(productsCounter)
                        .getString("brand");
                JSONArray jNutrientsArray = jObject.getJSONArray("productsArray")
                        .getJSONObject(productsCounter)
                        .getJSONArray("nutrients");
                JSONArray jAdditivesArray = jObject.getJSONArray("productsArray")
                        .getJSONObject(productsCounter)
                        .getJSONArray("additives");
                JSONArray jAllergensArray = jObject.getJSONArray("productsArray")
                        .getJSONObject(productsCounter)
                        .getJSONArray("allergens");

//TODO move to background Threads
                for (int i = 0; i < jNutrientsArray.length(); i++) {

                    Nutrient nutrient = new Nutrient();
                    nutrient.nutrientName = jNutrientsArray.getJSONObject(i)
                            .getString("nutrient_name");
                    nutrient.nutrientValue = jNutrientsArray.getJSONObject(i)
                            .getString("nutrient_value");
                    nutrient.nutrientUom = jNutrientsArray.getJSONObject(i)
                            .getString("nutrient_uom");
                    nutrient.nutrientFeLevel = jNutrientsArray.getJSONObject(i)
                            .getString("nutrient_fe_level");
                    listNutrient.add(nutrient);


                }

                for (int i = 0; i < jAdditivesArray.length(); i++) {

                    Additives additive = new Additives();
                    additive.additiveName = jAdditivesArray.getJSONObject(i)
                            .getString("additive_name");
                    additive.additiveValue = jAdditivesArray.getJSONObject(i)
                            .getString("additive_value");
                    additive.additiveRedIngredients = jAdditivesArray.getJSONObject(i)
                            .getString("additive_red_ingredients");
                    additive.additiveYellowIngridients = jAdditivesArray.getJSONObject(i)
                            .getString("additive_yellow_ingredients");
                    listAdditive.add(additive);


                }

                for (int i = 0; i < jAllergensArray.length(); i++) {

                    Allergen allergen = new Allergen();
                    allergen.allergenName = jAllergensArray.getJSONObject(i)
                            .getString("allergen_name");

                    allergen.allergenValue = jAllergensArray.getJSONObject(i)
                            .getString("allergen_value");
                    if (allergen.allergenName.equals("Gluten")
                            && Integer.parseInt(allergen.allergenValue) > 0) {
                        mContainsGluten = true;
                    }

                    allergen.allergenRedIngredients = jAllergensArray.getJSONObject(i)
                            .getString("allergen_red_ingredients");
                    allergen.allergenYellowIngridients = jAllergensArray.getJSONObject(i)
                            .getString("allergen_yellow_ingredients");
                    listAllergen.add(allergen);


                }
                Product product = new Product();
                product.setNutrients(listNutrient);
                product.setAdditives(listAdditive);
                product.setAllergens(listAllergen);
                product.mFoodCategory = mFoodCategory;
                product.mServingSize = mServingSize + " " + mServingSizeUOM;
                product.mCompanyName = mCompanyName;
                product.mProductName = mProductName;
                product.mContainsGluten = mContainsGluten;
                productList.add(product);


            }


        } catch (JSONException e) {

            e.printStackTrace();
        }

        return productList;
    }


}
