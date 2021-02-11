package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

//Represent a test for FoodList Class

public class FoodListTest {

    FoodList testFoodlist = new FoodList();
    FoodList testFoodlist2 = new FoodList();


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
        FoodList testFoodlist = new FoodList();
        FoodList testFoodlist2 = new FoodList();


        Food pizza1 = new Food("Simple Pizza", 35, " cheeze sausage mushroom bacon Pizza dough" +
                " salt",
                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                        "Oven", 3);


        Food pizza2 = new Food("Complicated Pizza", 40, " cheeze sausage mushroom bacon Pizza dough" +
                " salt",
                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                        "Oven", 34);


    }

    //TODO: Test empty Arraylist
    //TODO; Outcome shows the array size 0
    @Test
    void testFoodList() {


        FoodList testFoodlist2 = new FoodList();
        testFoodlist2.addFood(pizza1);
        testFoodlist2.addFood(pizza2);
        assertEquals(pizza1, testFoodlist2.getFood("Simple Pizza"));
        assertEquals(pizza2, testFoodlist2.getFood("Complicated Pizza"));

    }


}
