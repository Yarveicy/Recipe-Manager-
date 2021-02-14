package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

//Represent a test for FoodList Class

public class FoodListTest {


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

        Food pizza1 = new Food("Simple Pizza", 35, " cheeze sausage mushroom bacon Pizza dough" +
                " salt",
                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                        "Oven", 3);


        Food pizza2 = new Food("Complicated Pizza", 40, " cheeze sausage mushroom bacon Pizza dough" +
                " salt",
                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                        "Oven", 34);


    }


    //TODO: Test foodlist and addfood
    //TODO; Outcome shows added foods are added to the foodlist if they are available
    @Test
    void testFoodList() {


        FoodList testFoodlist2 = new FoodList();
        testFoodlist2.addFood(pizza1);
        testFoodlist2.addFood(pizza2);
        assertEquals(pizza1, testFoodlist2.getFood("Simple Pizza"));
        assertEquals(pizza2, testFoodlist2.getFood("Complicated Pizza"));
        assertEquals(null, testFoodlist2.getFood("Not available"));

    }

    //TODO: Test getffid and addfood
    //TODO; Outcome shows added foods are in the list and arraylist size increases by adding food
    @Test
    void testGetFoodList() {

        FoodList testFoodlist2 = new FoodList();
        testFoodlist2.addFood(pizza1);
        testFoodlist2.addFood(pizza2);
        ArrayList newVariable = testFoodlist2.getFoodList();
        assertEquals(2, newVariable.size());
        assertTrue(newVariable.contains(pizza1));
        assertTrue(newVariable.contains(pizza2));

    }


}
