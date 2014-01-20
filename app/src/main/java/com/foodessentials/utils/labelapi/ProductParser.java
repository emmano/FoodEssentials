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



    public static final Product parseProduct(JSONObject jObject) {
        List<Nutrient> listNutrient = new ArrayList<Nutrient>();
        List<Allergen> listAllergen = new ArrayList<Allergen>();
        List<Additives> listAdditive = new ArrayList<Additives>();

        try {

            JSONArray jNutrientsArray = jObject.getJSONArray("productsArray").getJSONObject(0).getJSONArray("nutrients");
            JSONArray jAdditivesArray = jObject.getJSONArray("productsArray").getJSONObject(0).getJSONArray("additives");
            JSONArray jAllergensArray = jObject.getJSONArray("productsArray").getJSONObject(0).getJSONArray("allergens");


            for (int i = 0; i < jNutrientsArray.length() ;i++) {

                Nutrient nutrient = new Nutrient();
                nutrient.nutrientName = jNutrientsArray.getJSONObject(0).getString("nutrient_name");
                nutrient.nutrientValue = jNutrientsArray.getJSONObject(0).getString("nutrient_value");
                nutrient.nutrientUom = jNutrientsArray.getJSONObject(0).getString("nutrient_uom");
                nutrient.nutrientFeLevel = jNutrientsArray.getJSONObject(0).getString("nutrient_fe_level");
                listNutrient.add(nutrient);


            }

            for (int i = 0; i < jAdditivesArray.length() ;i++) {

                Additives additive = new Additives();
                additive.additiveName = jAdditivesArray.getJSONObject(0).getString("additive_name");
                additive.additiveValue = jAdditivesArray.getJSONObject(0).getString("additive_value");
                additive.additiveRedIngredients = jAdditivesArray.getJSONObject(0).getString("additive_red_ingredients");
                additive.additiveYellowIngridients = jAdditivesArray.getJSONObject(0).getString("additive_yellow_ingredients");
                listAdditive.add(additive);


            }

            for (int i = 0; i < jAdditivesArray.length() ;i++) {

                Allergen allergen = new Allergen();
                allergen.allergenName = jAllergensArray.getJSONObject(0).getString("allergen_name");
                allergen.allergenValue = jAllergensArray.getJSONObject(0).getString("allergen_value");
                allergen.allergenRedIngredients = jAllergensArray.getJSONObject(0).getString("allergen_red_ingredients");
                allergen.allergenYellowIngridients = jAllergensArray.getJSONObject(0).getString("allergen_yellow_ingredients");
                listAllergen.add(allergen);


            }





        } catch (JSONException e) {
            e.printStackTrace();
        }

        Product product = new Product();
        product.mNutrients = listNutrient;
        product.mAdditives = listAdditive;
        product.mAllergens = listAllergen;
        return product;
    }


}
