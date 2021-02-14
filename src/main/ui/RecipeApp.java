package ui;

import model.Food;
import model.FoodList;

import java.util.Scanner;


// Food recipe application
public class RecipeApp {


    /*
     * EFFECTS: Constructor of a Recipe App
     */
    public RecipeApp() {
        FoodList foodList = new FoodList();
        Scanner input = new Scanner(System.in);
        runApp(foodList, input);
    }

    // Modify: Food and Foodlist
    //Require :food title,ingredients,cookingInstruction have a non-zero length and time>0 min,and stars between 1-10
    //food list have a non-zero length
    // EFFECTS: runs the recipe application based on USER INPUT
    private void runApp(FoodList foodList, Scanner input) {
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
                case 4:
                    setRating(foodList);
                    break;
                case 5:
                    isExit = false;
                    break;
            }
        }
    }

    // Require: The input number should be 1,2,3,4 or 5.
    // EFFECTS: prompt the option for user to guide them how to use application
    private void promptUserOptions() {
        System.out.println("Please choose one of the below options, Just please type the number between 1-5");
        System.out.println("1. Add recipe");
        System.out.println("2. View all recipe");
        System.out.println("3. View recipe detail");
        System.out.println("4. Rate a recipe");
        System.out.println("5. Exit");
    }

    //Require :food title,ingredients,cookingInstruction have a non-zero length and time>0 min,and stars between 1-10
    //food list have a non-zero length
    // MODIFIES: this
    // EFFECTS: Ask user to add the desired food recipe in detail such as title,time,ingredients,cooking instruction and
    // rating
    private void addRecipePlease(FoodList foodList) {
        String title;
        int time;
        String ingredients;
        String cookingInstruction;
        int stars;

        Scanner input = new Scanner(System.in);  //// Create a Scanner object
        System.out.println("Please write the title of the recipe");
        title = input.nextLine();

        System.out.println("Please write the time required to cook the recipe in minutes");
        time = input.nextInt();
        input.nextLine();

        System.out.println("Please write the ingredients required to cook the recipe");
        ingredients = input.nextLine();


        System.out.println("Please write the cooking instruction");
        cookingInstruction = input.nextLine();

        System.out.println("Please rate this recipe from 1 to 10");
        stars = input.nextInt();
        input.nextLine();

        Food newRecipe = new Food(title, time, ingredients, cookingInstruction, stars);
        foodList.addFood(newRecipe);


    }

    //Require:food has a non-zero length
    // EFFECTS: user can see the title of all added food recipe
    public void viewTileOfAllRecipe(FoodList foods) {

        for (int i = 0; i < foods.getFoodList().size(); i++) {
            System.out.println(foods.getFoodList().get(i).getTitle());
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
            System.out.println(food.getCookingInstruction());
            System.out.println(food.getIngredients());
            System.out.println(food.getTime());
            System.out.println(food.getStars());
        } else {
            System.out.println("No such recipe");
        }


    }

    //Require:food has a non-zero length and rating should be between 1 to 10
    // EFFECTS: user can rate the desired recipe
    public void setRating(FoodList foods) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please write the title of the recipe");
        String title = input.nextLine();
        Food food = foods.getFood(title);
        System.out.println("Please write the rating of the recipe");
        int stars = input.nextInt();


        food.setStars(stars);


    }


}
