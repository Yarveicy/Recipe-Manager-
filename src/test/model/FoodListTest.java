package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

//Represent a test for FoodList Class

public class FoodListTest {

    private ArrayList<Food> testFoodlist;


    Food pizza1 = new Food("Simple Pizza", 35, " cheeze sausage mushroom bacon Pizza dough" +
            " salt",
            "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                    "Oven", 3);


    Food pizza2 = new Food("Complicated Pizza", 40, " cheeze sausage mushroom bacon Pizza dough" +
            " salt",
            "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                    "Oven", 34);

    @BeforeEach
    void runBefore() {
        testFoodlist = new ArrayList<Food>();


    }

    //TODO: Test empty Arraylist
    //TODO; Outcome shows the array size 0
    @Test
    void testFoodList() {


        assertEquals(0, testFoodlist.size());

    }


    //TODO: Test add to the list
    //TODO; Outcome shows by adding food size of the arraylist will change
    @Test
    void testAddFoodNotEmptyList() {

        testFoodlist.add(pizza1);
        testFoodlist.add(pizza2);

        assertEquals(2, testFoodlist.size());

    }


    //TODO: Test get the added  food from the arraylist
    //TODO; Outcome shows the food in the list
    @Test
    void testGetFood() {

        testFoodlist.add(pizza1);
        testFoodlist.add(pizza2);
        assertEquals(pizza1, testFoodlist.get(0));
        assertEquals(pizza2, testFoodlist.get(1));

    }


}
