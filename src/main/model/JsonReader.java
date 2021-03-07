package model;

import model.Food;
import model.FoodList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


// Represents a reader that reads from JSON data stored in file
//CITATIONS: I used the code which is available on GITHUB of UBC JsonSerializationDemo with
//minor changes that I have done to the source code
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads food from file and returns it;
    // throws IOException if an error occurs reading data from file
    public FoodList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFoodlist(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses foodlist from JSON object and returns it
    private FoodList parseFoodlist(JSONObject jsonObject) {
        JSONArray newOne = jsonObject.getJSONArray("foodlist");
        FoodList newTwo = new FoodList();
        addFoods(newTwo, newOne);
        return newTwo;
    }

    // MODIFIES: f and m
    // EFFECTS: parses food from JSON object and adds them to foodlist
    private void addFoods(FoodList f, JSONArray m) {

        for (Object json : m) {
            JSONObject nextFood = (JSONObject) json;
            addFood(f, nextFood);
        }
    }

    // MODIFIES: m and n
    // EFFECTS: parses title,time required to cook, ingredients,
    // coking instruction and recipe rating-(parses newRecipe from JSON object)
    // from JSON object and adds it to foodlist
    private void addFood(FoodList m, JSONObject n) {
        String title = n.getString("title");
        int time = n.getInt("time");
        String ingredients = n.getString("ingredients");
        String cookingInstruction = n.getString("cookingInstruction");
        int stars = n.getInt("stars");
        Food newRecipe = new Food(title, time, ingredients, cookingInstruction, stars);
        m.addFood(newRecipe);


    }


}
