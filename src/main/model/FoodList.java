package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


//Represent list of food

public class FoodList {

    private ArrayList<Food> foodList;  // the list of food recipe title


    /*
     * REQUIRES: food list have a non-zero length.
     *
     * EFFECTS: Constructor of a new foodliist of food item, title of food is set to foodList
     */
    public FoodList() {

        foodList = new ArrayList<>();
    }

    public ArrayList<Food> getFoodList() {

        return foodList;
    }

    /*
     * REQUIRES: food has a non-zero length.
     * Modify :this
     * EFFECTS: the food is added to the list of food
     */

    public void addFood(Food c) {

        foodList.add(c);

    }

    /*
     * REQUIRES: food title  has a non-zero length.
     *
     * EFFECTS: the food  is get from list of food based on the food title
     */

    public Food getFood(String foodTitle) {
        int index = -1;
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getTitle().equalsIgnoreCase(foodTitle)) {
                index = i;
            }
        }
        return (index == -1) ? null : foodList.get(index);
    }


    /*
     *
     * EFFECTS: converts  foodlist to JsonObject--(return Json object)-
     * to help us save the data with the help up value pairs
     */
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("foodlist", foodsToJson());
        return json;
    }


    /*
     * EFFECTS: returns foodlist as JsonArray to help us save the data with the help up value pairs
     */
    private JSONArray foodsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Food t : foodList) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }


}
