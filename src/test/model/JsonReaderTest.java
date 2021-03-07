package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Represent a test for JsonReader
public class JsonReaderTest {


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

