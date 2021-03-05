package ui;

import model.Food;
import model.FoodList;
import org.json.JSONArray;
import org.json.JSONObject;


public class Practice {
    @SuppressWarnings("checkstyle:LocalVariableName")
    public static void main(String[] args) {
        Food pizza = new Food("Pizza", 1, "cheese tomato", "Put in oven", 5);
        Food pizza2 = new Food("Pizza2", 2, "cheese tomato bread", "Put in oven 2", 5);
//        FoodList foodList = new FoodList();
//        foodList.addFood(pizza);
//        foodList.addFood(pizza2);

        JSONArray jsonArray = new JSONArray();

        //////////////////////////////////////////////

        JSONObject foodJsonObject = new JSONObject();
        foodJsonObject.put("title", pizza.getTitle());
        foodJsonObject.put("ingredients", pizza.getIngredients());

        jsonArray.put(foodJsonObject);


        //////////////////////////////////////////


        JSONObject foodJsonObject2 = new JSONObject();
        foodJsonObject2.put("title", pizza2.getTitle());
        foodJsonObject2.put("ingredients", pizza2.getIngredients());

        jsonArray.put(foodJsonObject2);
//
//
//
//
//
        System.out.println(((JSONObject) jsonArray.get(0)).getString("title"));

//        System.out.println(jsonArray.get(0).getClass());


        JSONObject food2 = new JSONObject();

        food2.put("title", pizza2.getTitle());
        food2.put("time",pizza2.getTime());
        food2.put("ingredient",pizza2.getIngredients());
        food2.put("cookingInstruction",pizza2.getCookingInstruction());
        food2.put("stars",pizza2.getStars());

        JSONArray foodarray = new JSONArray();

        foodarray.put(food2);

        System.out.println(foodarray.get(0).toString());



    }


}
