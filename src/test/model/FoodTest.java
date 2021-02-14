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
    //TODO; Outcome shows title,time,ingredients, cooking instruction and time required for the recipe
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


    //TODO: Test gettitle
    //TODO; Outcome shows title of the food
    @Test
    void testGetTitle() {
        assertEquals("Simple Pizza", testFood.getTitle());

    }


    //TODO: Test gettime
    //TODO; Outcome shows time required for coooking food
    @Test
    void testGetTime() {
        assertEquals(35, testFood.getTime());

    }


    //TODO: Test get Ingredients
    //TODO; Outcome shows ingredients required for coooking food
    @Test
    void testGetIngredients() {
        assertEquals(" cheeze sausage mushroom bacon Pizza dough" +
                " salt", testFood.getIngredients());

    }

    //TODO: Test get CookingInstruction
    //TODO; Outcome shows instruction required for coooking food
    @Test
    void testGetCookingInstruction() {
        assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                "Oven", testFood.getCookingInstruction());

    }

    //TODO: Test getstars
    //TODO; Outcome shows stars for food
    @Test
    void testGetStars() {
        assertEquals(3, testFood.getStars());

    }

    //TODO: Test getId
    //TODO; Outcome shows id for food
    @Test
    void testGetId() {
        assertEquals(3, testFood.getId());

    }

    //TODO: Test setstars
    //TODO; Outcome shows rating for food
    @Test
    void testSetStars() {
        testFood.setStars(5);
        assertEquals(5, testFood.getStars());

    }

}
