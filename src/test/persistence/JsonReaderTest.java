package persistence;



import model.FoodList;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

//Represent a test for JsonReader
public class JsonReaderTest {


    //TODO: Test Reader for not available file
    //TODO; Outcome shows the file does not exist
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


    //TODO: Test Reader for empty file
    //TODO; Outcome shows the file is empty
    @Test
    void testReaderEmptyFoodList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFoodList.json");
        try {
            FoodList wr = reader.read();

            assertTrue(wr.getFoodList().isEmpty());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    //TODO: Test Reader for general file
    //TODO; Outcome shows the file is available
    @Test
    void testReaderGeneralFoodlist() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFoodList.json");
        try {

            FoodList foods = reader.read();
            assertFalse(foods.getFoodList().isEmpty());
            assertEquals(2, foods.getFoodList().size());
            assertEquals(35, foods.getFood("Simple Pizza").getTime());
            assertEquals(3, foods.getFood("Simple Pizza").getStars());
            assertEquals("Simple Pizza", foods.getFood("Simple Pizza").getTitle());
            assertEquals("Please add all the ingredients on the pizza topping. Then, put the pizza in theOven"
                    , foods.getFood("Simple Pizza").getCookingInstruction());
            assertEquals(" cheeze sausage mushroom bacon Pizza dough salt",
                    foods.getFood("Simple Pizza").getIngredients());

            //assertEquals(1, foods.getFood("Simple Pizza").getId());
            foods.getFood("Simple Pizza").setStars(5);
            assertEquals(5, foods.getFood("Simple Pizza").getStars());
            assertFalse(foods.toJson().isEmpty());




        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}

