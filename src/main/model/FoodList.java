package model;

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


}
