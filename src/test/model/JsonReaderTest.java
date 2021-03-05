package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    //    @BeforeEach
//    void runBefore() {
//
//        Food pizza1 = new Food("Simple Pizza", 35, " cheeze sausage mushroom bacon Pizza dough" +
//                " salt",
//                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
//                        "Oven", 3);
//
//
//        Food pizza2 = new Food("Complicated Pizza", 40, " cheeze sausage mushroom bacon Pizza dough" +
//                " salt",
//                "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
//                        "Oven", 34);
//
//
//    }
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            FoodList wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFoodList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFoodList.json");
        try {
            FoodList wr = reader.read();

            //assertEquals([], wr.getFoodList());
            assertTrue(wr.getFoodList().isEmpty());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFoodList.json");
        try {

            FoodList foods = reader.read();
            assertFalse(foods.getFoodList().isEmpty());
            assertEquals(2, foods.getFoodList().size());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}

