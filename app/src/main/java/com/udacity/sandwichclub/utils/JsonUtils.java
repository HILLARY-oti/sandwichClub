package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich;
        JSONObject name;
        String mainName = null;
        List<String> alsoKnownAs = null;
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = null;

        try {
            JSONObject some = new JSONObject(json);
            name = some.getJSONObject("name");
            mainName = name.getString("mainName");

            JSONArray alsoKnownAs_Me = name.getJSONArray("alsoKnownAs");
            alsoKnownAs = new ArrayList<>();
            image = some.getString("image");
            if (alsoKnownAs_Me.length() != 0){
                for (int i = 0; i < alsoKnownAs_Me.length(); i++) {
                    alsoKnownAs.add(alsoKnownAs_Me.getString(i));
                }
            }

            placeOfOrigin = some.getString("placeOfOrigin");
            description = some.getString("description");


            JSONArray ingredients_JA = some.getJSONArray("ingredients");
            ingredients = new ArrayList<>();

            if (ingredients_JA.length() != 0) {
                for (int i = 0; i < ingredients_JA.length(); i++) {
                    ingredients.add(ingredients_JA.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        return sandwich;
    }
}