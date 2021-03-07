package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//Represent a test for JsonWriter
public class JsonWriterTest {


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


    @Test
    void testWriterInvalidFile() {

        try {
            FoodList wr = new FoodList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }


    }

    @Test
    void testWriterEmptyFoodList() {

        try {
            FoodList pizzza = new FoodList();
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyFoodList.json");
            writer.open();
            writer.write(pizzza);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderEmptyFoodList.json");
            pizzza = reader.read();

            assertEquals(0, pizzza.getFoodList().size());
            assertTrue(pizzza.getFoodList().isEmpty());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }


    }

    @Test
    void testWriterGeneralFoodList() {
        try {

            Food pizza1 = new Food("Simple Pizza", 35, " cheeze sausage mushroom bacon Pizza dough" +
                    " salt",
                    "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                            "Oven", 3);


            Food pizza2 = new Food("Complicated Pizza", 40, " cheeze sausage mushroom bacon Pizza dough" +
                    " salt",
                    "Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                            "Oven", 34);


            FoodList foods = new FoodList();
            foods.addFood(pizza1);
            foods.addFood(pizza2);

            JsonWriter writer = new JsonWriter("./data/testReaderGeneralFoodList.json");
            writer.open();
            writer.write(foods);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderGeneralFoodList.json");
            foods = reader.read();

            assertEquals("Complicated Pizza", pizza2.getTitle());
            assertEquals("Simple Pizza", pizza1.getTitle());
            assertEquals(35, pizza1.getTime());
            assertEquals(40, pizza2.getTime());

            assertEquals(" cheeze sausage mushroom bacon Pizza dough" +
                    " salt", pizza2.getIngredients());
            assertEquals(" cheeze sausage mushroom bacon Pizza dough" +
                    " salt", pizza1.getIngredients());
            assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                    "Oven", pizza2.getCookingInstruction());
            assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in the" +
                    "Oven", pizza1.getCookingInstruction());
            assertEquals(3, pizza1.getStars());
            assertEquals(34, pizza2.getStars());

            assertEquals(2, foods.getFoodList().size());



        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}






