package ui;

import model.Food;
import model.FoodList;
import model.JsonReader;
import model.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Food recipe application
//CITATIONS: I used the code which is available on GITHUB of UBC JsonSerializationDemo with
//minor changes that I have done to the source code for loadfoodlist and savefoodlist methods
public class RecipeApp {


    private static final String JSON_STORE = "./data/workroom.json";
    private FoodList foodList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    /*
     * EFFECTS: Constructor of a Recipe App
     */
    public RecipeApp() throws Exception {

        try {
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonReader = new JsonReader(JSON_STORE);
            foodList = new FoodList();
            Scanner input = new Scanner(System.in);
            runApp(input);
        } catch (Exception e) {
            System.out.println("Please choose the correct option to use the Application!");
        }


    }


    // Modify: Food and Foodlist
    //Require :food title,ingredients,cookingInstruction have a non-zero length and time>0 min,and stars between 1-10
    //food list have a non-zero length
    // EFFECTS: runs the recipe application based on USER INPUT
    private void runApp(Scanner input) throws Exception {
        boolean isExit = false;
        while (!isExit) {
            promptUserOptions();
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    addRecipePlease(foodList);
                    break;
                case 2:
                    viewTileOfAllRecipe(foodList);
                    break;
                case 3:
                    viewTheDetailOfRecipe(foodList);
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    runAppsss(option);
            }
        }
    }


    private void runAppsss(int option) throws Exception {


        switch (option) {
            case 4:
                setRating(foodList);
                break;
            case 6:
                loadFoodList();
                break;
            case 7:
                saveFoodList();
                break;
        }
    }


    // Require: The input number should be 1 to 7.
    // EFFECTS: prompt the option for user to guide them how to use application
    private void promptUserOptions() throws Exception {
        try {
            System.out.println("Please choose one of the below options, Just please type the number between 1-7");
            System.out.println("1. Add recipe");
            System.out.println("2. View all recipe");
            System.out.println("3. View recipe detail");
            System.out.println("4. Rate a recipe");
            System.out.println("5. Exit");
            System.out.println("6. Load");
            System.out.println("7. Save");
        } catch (Exception e) {
            System.out.println("Please only choose number between 1 to 7");
        }
    }

    //Require :food title,ingredients,cookingInstruction have a non-zero length and time>0 min,and stars between 1-10
    //food list have a non-zero length
    // MODIFIES: this
    // EFFECTS: Ask user to add the desired food recipe in detail such as title,time,ingredients,cooking instruction and
    // rating
    private void addRecipePlease(FoodList foodList) throws Exception {
        String title;
        int time;
        String ingredients;
        String cookingInstruction;
        int stars;
        try {
            Scanner input = new Scanner(System.in);  //// Create a Scanner object
            System.out.println("Please write the title of the recipe");
            title = input.nextLine();

            System.out.println("Please write the time required to cook the recipe in minutes");
            time = input.nextInt();
            input.nextLine();

            System.out.println("Please write the ingredients required to cook the recipe");
            ingredients = input.nextLine();

            System.out.println("Please write the cooking instruction, and rate the recipe once you have done!");
            cookingInstruction = input.nextLine();

            stars = input.nextInt();
            input.nextLine();
            Food newRecipe = new Food(title, time, ingredients, cookingInstruction, stars);
            foodList.addFood(newRecipe);
        } catch (Exception e) {
            System.out.println("Please follow the correct format of inputs (Time and rating should be in number!!)");
        }

    }

    //Require:food has a non-zero length
    // EFFECTS: user can see the title of all added food recipe
    public void viewTileOfAllRecipe(FoodList foods) {

        for (int i = 0; i < foods.getFoodList().size(); i++) {
            System.out.println("Recipe title: " + foods.getFoodList().get(i).getTitle());
        }

    }


    // EFFECTS: user can see the detail of the desired recipe
    public void viewTheDetailOfRecipe(FoodList foods) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please write the title of the recipe");
        String title = input.nextLine();

        Food food = foods.getFood(title);
        if (food != null) {
            System.out.println("Recipe title: " + food.getTitle());
            System.out.println("Recipe Cooking Instruction: " + food.getCookingInstruction());
            System.out.println("Food Ingredients:" + food.getIngredients());
            System.out.println("Time required to cook:" + food.getTime());
            System.out.println("Rating of the recipe:" + food.getStars());
        } else {
            System.out.println("No such recipe");
        }


    }

    //Require:food has a non-zero length
    // EFFECTS: user can rate the desired recipe
    public void setRating(FoodList foods) throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please write the title of the recipe");
            String title = input.nextLine();
            Food food = foods.getFood(title);
            System.out.println("Please write the rating of the recipe");
            int stars = input.nextInt();
            food.setStars(stars);


        } catch (Exception e) {
            System.out.println("Please follow the correct format of input! Rating is number");
        }


    }


    // EFFECTS: saves the foodlist to file
    private void saveFoodList() {


        try {
            jsonWriter.open();
            jsonWriter.write(foodList);
            jsonWriter.close();
            System.out.println("Saved foodList to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads foodlist from file
    private void loadFoodList() {
        try {
            foodList = jsonReader.read();
            System.out.println("Loaded foodlist from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
