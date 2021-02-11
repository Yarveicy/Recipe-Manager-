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
    void testFood() {
        assertEquals("Simple Pizza", testFood.getTitle());
        assertEquals(35, testFood.getTime());
        assertEquals(" cheeze sausage mushroom bacon Pizza dough" +
                " salt", testFood.getIngredients());
        assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                "Oven", testFood.getCookingInstruction());
        assertEquals(3, testFood.getStars());


    }

    @Test
    void testGetTitle() {
        assertEquals("Simple Pizza", testFood.getTitle());

    }

    @Test
    void testGetTime() {
        assertEquals(35, testFood.getTime());

    }

    @Test
    void testGetIngredients() {
        assertEquals(" cheeze sausage mushroom bacon Pizza dough" +
                " salt", testFood.getIngredients());

    }

    @Test
    void testGetCookingInstruction() {
        assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                "Oven", testFood.getCookingInstruction());

    }


    @Test
    void testGetStars() {
        assertEquals(3, testFood.getStars());

    }


    @Test
    void testGetId() {
        assertEquals(3, testFood.getId());

    }

    @Test
    void testSetStars() {
        testFood.setStars(5);
        assertEquals(5, testFood.getStars());

    }

}
