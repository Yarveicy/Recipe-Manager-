package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//Represent a test for Food Class

public class FoodTest {

    private Food testFood;

    @BeforeEach
    void runBefore() {
        testFood = new Food("Simple Pizza", 35, " cheeze sausage mushroom bacon Pizza dough" +
                " salt",
                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                        "Oven", 3);

    }


    //TODO: Test constructor
    //TODO; Outcome shows title,time,ingredients, cooking instaruction and time required for the recipe
    @Test
    void testConstructor() {
        assertEquals("Simple Pizza", testFood.getTitle());
        assertEquals(35, testFood.getTime());
        assertEquals(" cheeze sausage mushroom bacon Pizza dough" +
                " salt", testFood.getIngredients());
        assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                "Oven", testFood.getCookingInstruction());
        assertEquals(3, testFood.getStars());
    }


}
