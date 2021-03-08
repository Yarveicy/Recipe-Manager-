package model;

import org.json.JSONArray;
import org.json.JSONObject;


//Represent a food having an title, id, time required to cook, ingredients, coking instruction and recipe rating

public class Food {
    private String title;                   // the recipe title
    private int id;                         // recipe id
    private static int nextRecipeId = 1;    // Keep track of number of recipe id
    private int time;                       // the time in minutes to cook
    private String ingredients;             // Different Ingredients
    private String cookingInstruction;      // Cooking instruction
    private int stars;                      // Recipe rating

    /*
     * REQUIRES: food title,ingredients,cookingInstruction have a non-zero length and time>0 min,and stars .
     *
     * EFFECTS:  Constructor of  new food ;title of food is set to title;
     *          food id is a  positive integer not assigned to any other food,
     *          ingredient of food is set to ingredients, time is a positive integer that assigned to time,
     *          food stars is a  positive integer rating of food that assigned to stars,ingredients of food is set
     *          to ingredients, cookingInstruction is set to cooking Instruction for food
     */

    public Food(String title, int time, String ingredients, String cookingInstruction, int stars) {
        this.id = nextRecipeId++;
        this.title = title;
        this.time = time;
        this.ingredients = ingredients;
        this.cookingInstruction = cookingInstruction;
        this.stars = stars;

    }

    public String getTitle() {

        return title;
    }

    public int getTime() {

        return time;
    }


    public String getIngredients() {

        return ingredients;
    }

    public String getCookingInstruction() {

        return cookingInstruction;
    }

    public int getStars() {

        return stars;
    }

    public void setStars(int stars) {

        this.stars = stars;
    }


    /*
     * Modifies Json
     * EFFECTS: converts  title,time required to cook, ingredients, coking instruction and recipe rating
     * to a JsonObject-(return Json object)- to help us save the data with the help of value pairs.
     */

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("time", time);
        json.put("ingredients", ingredients);
        json.put("cookingInstruction", cookingInstruction);
        json.put("stars", stars);
        return json;
    }
}




