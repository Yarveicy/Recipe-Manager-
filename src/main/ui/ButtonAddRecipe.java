package ui;

import model.Food;
import model.FoodList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//CITATION: I got an idea from examples available with Oracle,net and Edex.

//ButtonAddRecipe class which Represent buttons that help us to save,load,add food recipe,
// show recipe details and clos the application using frames and actions with click

public class ButtonAddRecipe extends JFrame implements ActionListener {


    private static final String JSON_STORE = "./data/workroom.json";//Represent the location of the saved files
    private FoodList foodList = new FoodList();// create foodlist object
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);
    JTextArea textArea = new JTextArea(20, 20);//Represent the text Area for showing result
    JButton buttonAddRecipe = new JButton("AddRecipe");//Represent the new Button object
    JButton buttonViewAllRecipe = new JButton("ViewAllRecipe");//Represent the new Button object
    JButton buttonViewRecipeDetails = new JButton("Details");//Represent the new Button object
    JButton buttonExit = new JButton("Exit");//Represent the new Button object
    JButton buttonLoad = new JButton("Load");//Represent the new Button object
    JButton buttonSave = new JButton("Save");//Represent the new Button object
    File wavFile = new File("./data/DanceMonkey.wav");//Represent the location of the audio file
    AudioClip sound;



    // Modify: this
    // Effect: Constructor for new ButtonAddRecipe object which creates buttons in frames and make them visible to users
    // and users can interact with buttons with program
    ButtonAddRecipe() {


        JFrame frame = new JFrame("CPSC 210"); //Represent the object of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Represent operation on frame
        frame.setSize(400, 400);//Represent the frame size
        frame.setLayout(new GridLayout(3, 3));//Represent Layout of frame
        frame.add(buttonAddRecipe, BorderLayout.CENTER);//Represent the adding the addRecipe button to frame
        frame.add(buttonViewAllRecipe, BorderLayout.WEST);//Represent the adding the addRecipe button to frame
        frame.add(buttonViewRecipeDetails, BorderLayout.EAST);//Represent the adding the view detail rec button to frame
        frame.add(buttonSave, BorderLayout.NORTH);//Represent the adding the Save button to frame
        frame.add(buttonLoad, BorderLayout.SOUTH);//Represent the adding the Load button to frame
        frame.add(buttonExit, BorderLayout.CENTER);//Represent the adding the Exit button to frame
        frame.setVisible(true);//Represent setting frame visibility

        buttonAddRecipe.addActionListener(this);//Represent adding action to buttonAddRecipe
        buttonViewAllRecipe.addActionListener(this);//Represent adding action to buttonViewAllRecipe
        buttonViewRecipeDetails.addActionListener(this);//Represent adding action to buttonAddRecipe
        buttonExit.addActionListener(this);//Represent adding action to buttonViewRecipeDetails
        buttonLoad.addActionListener(this);//Represent adding action to buttonLoad
        buttonSave.addActionListener(this);//Represent adding action to buttonSave


        //Refactor Method- Based on the discussion in Friday office hour, I explained the details of the method below
        resultFrame();


        ///Refactor Method- Based on the discussion in Friday office hour, I explained the details of the method below
        showInputFoodRecipe();


    }


    // Modify: this
    // Effect: Create result frame with defined size ,layout,text area to show the results with the pre-defined
    // font size and set the frame to visible to show the results to the user

    private void resultFrame() {
        JFrame frame2 = new JFrame("Result CPSC 210");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 400);
        frame2.setLayout(new GridLayout(1, 1));
        frame2.add(textArea);
        Font font = new Font("Segoe Script", Font.BOLD, 20);
        textArea.setFont(font);
        frame2.setVisible(true);
    }

    // Modify: this
    // Effect: Create input panel for adding the one food details to food recipe- food having an title,
    // time required to cook, ingredients, coking instruction and recipe rating-


    private void showInputFoodRecipe() {
        JTextField title = new JTextField(5);//Represent the textField to help us adding the title of the food
        JTextField time = new JTextField(5);//Represent the textField to help us adding the time req of the food
        JTextField ingredients = new JTextField(5);//Represent the textField for ingredients of the food
        JTextField cookingInstruction = new JTextField(5);//Represent the textField for Cook instruc of the food
        JTextField stars = new JTextField(5);//Represent the textField for rating of the food

        JPanel myPanel = new JPanel();//Create panel Object
        myPanel.add(new JLabel("Title:"));//Adding Lable
        myPanel.add(title);//Represent adding title to panel
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Time:"));//Adding Lable
        myPanel.add(time);//Represent adding time to panel
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Ingredients:"));//Adding Lable
        myPanel.add(ingredients);//Represent adding ingredients to panel
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("CookingInstruction:"));//Adding Lable
        myPanel.add(cookingInstruction);//Represent adding cooking instruction  to panel
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Stars:"));//Adding Lable
        myPanel.add(stars);//Represent adding rating  to panel


        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter title,time,ingredients,instruction,rating Values", JOptionPane.OK_CANCEL_OPTION);
        showButtonClick(title, time, ingredients, cookingInstruction, stars, result);
    }


    // REQUIRES: food title,ingredients,cookingInstruction have a non-zero length and type string and time>0 min,and
    // star is positive integer
    // Modify: this
    // Effect: if Ok button is clicked all the input related to food such as title,ingredients,cookingInstruction
    // time>0 min,and stars will create food object and then add to the food list

    private void showButtonClick(JTextField title, JTextField time, JTextField ingredients,
                                 JTextField cookingInstruction, JTextField stars, int result) {
        if (result == JOptionPane.OK_OPTION) {

            String titleString = title.getText();
            String ingredientString = ingredients.getText();
            int timesNum = Integer.parseInt(time.getText());
            String cookingInstructionString = cookingInstruction.getText();
            int starsNum = Integer.parseInt(stars.getText());

            Food newRecipe = new Food(titleString, timesNum, ingredientString, cookingInstructionString, starsNum);
            foodList.addFood(newRecipe);


        }
    }


    //Modify: this
    //Effect: Each button provide the different tasks such as show,load,save,exit and load recipe based on the
    //user actions. Which help us to relate the program and the order of the user.

    @Override
    public void actionPerformed(ActionEvent e) {
        //Refactor Method Based on the discussion in Friday office hour, I explained the details of the method below
        showRecipe(e);
        //Refactor Method Based on the discussion in Friday office hour, I explained the details of the method below
        showMethoidButtonAdd(e);
        //Refactor Method Based on the discussion in Friday office hour, I explained the details of the method below
        showViewRecioeDetails(e);
        //Refactor Method Based on the discussion in Friday office hour, I explained the details of the method below
        showButonSave(e);
        //Refactor Method Based on the discussion in Friday office hour, I explained the details of the method below
        showButtonLoad(e);
        //Refactor Method Based on the discussion in Friday office hour, I explained the details of the method below
        showButtonExit(e);

    }


    //Modify: this
    //Effect: Once the exit button clicked the application is closed by the system

    private void showButtonExit(ActionEvent e) {
        if (e.getSource() == buttonExit) {

            System.out.println(" You press Exit ");
            System.exit(0);


        }
    }


    //Modify: this
    //Effect: Once the load button clicked the application is laoding the list of the previous food which are saved and
    //music will play

    private void showButtonLoad(ActionEvent e) {
        if (e.getSource() == buttonLoad) {


            System.out.println("You prsesed load");

            try {
                foodList = jsonReader.read();
                System.out.println("Loaded foodlist from " + JSON_STORE);
                textArea.setText("You Clicked On Load Button");
                sound = Applet.newAudioClip(wavFile.toURL());
                sound.play();

            } catch (IOException enn) {
                System.out.println("Unable to read from file: " + JSON_STORE);
                textArea.setText("You Clicked On Load Button");
            }


        }
    }


    //Modify: this
    //Effect: Once the Save button clicked the application will save all the changes that we made to the list of food
    // and play the music

    private void showButonSave(ActionEvent e) {
        if (e.getSource() == buttonSave) {

            System.out.println(" You press Save ");

            try {
                jsonWriter.open();
                jsonWriter.write(foodList);
                jsonWriter.close();
                System.out.println("Saved foodList to " + JSON_STORE);
                textArea.setText("You Clicked On Save Button");


                sound.play();

            } catch (FileNotFoundException em) {
                System.out.println("Unable to write to file: " + JSON_STORE);
                textArea.setText("You Clicked On Save Button");


            }

        }
    }


    //Modify: this
    //Effect: Once the recipe details button clicked the application will ask the user to write the name of the
    //desired food and if available the application will show the detail of the food recipe, otherwise mentioned
    //not such a recipe


    private void showViewRecioeDetails(ActionEvent e) {
        if (e.getSource() == buttonViewRecipeDetails) {

            JTextField title = new JTextField(5);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("title:"));
            myPanel.add(title);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter title", JOptionPane.OK_CANCEL_OPTION);
            Food food = foodList.getFood(title.getText());


            if (result == JOptionPane.OK_OPTION) {
                System.out.println("title : " + title.getText());

                if (food != null) {

                    textArea.setText(food.toString());


                } else {
                    textArea.setText("NOt SUCH A RECIPE");
                }


            }


        }
    }


    // Modify: this
    // Effect: Create input panel for adding the one food details to food recipe- food having an title,
    // time required to cook, ingredients, coking instruction and recipe rating

    private void showMethoidButtonAdd(ActionEvent e) {
        if (e.getSource() == buttonAddRecipe) {


            JTextField title = new JTextField(5);
            JTextField time = new JTextField(5);
            JTextField ingredients = new JTextField(5);
            JTextField cookingInstruction = new JTextField(5);
            JTextField stars = new JTextField(5);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("title:"));
            myPanel.add(title);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("time:"));
            myPanel.add(time);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("ingredients:"));
            myPanel.add(ingredients);
            myPanel.add(new JLabel("cookingInstruction:"));
            myPanel.add(cookingInstruction);
            myPanel.add(new JLabel("stars:"));
            myPanel.add(stars);


            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter title,time,ingredients,instruction,rating Values", JOptionPane.OK_CANCEL_OPTION);
            showButtonClick2(title, time, ingredients, cookingInstruction, stars, result);


        }
    }

    // REQUIRES: food title,ingredients,cookingInstruction have a non-zero length and time>0 min,and star is positive
    // Modify: this
    // Effect: if Ok button is clicked all the input related to food such as title,ingredients,cookingInstruction
    // time>0 min,and stars will creat foo object and then add to the food list

    private void showButtonClick2(JTextField title, JTextField time, JTextField ingredients,
                                  JTextField cookingInstruction, JTextField stars, int result) {
        if (result == JOptionPane.OK_OPTION) {

            String titleString = title.getText();
            String ingredientString = ingredients.getText();
            int timesNum = Integer.parseInt(time.getText());
            String cookingInstructionString = cookingInstruction.getText();
            int starsNum = Integer.parseInt(stars.getText());
            Food newRecipe = new Food(titleString, timesNum, ingredientString, cookingInstructionString, starsNum);
            foodList.addFood(newRecipe);
            textArea.setText(foodList.getFoodList().toString());


        }
    }


    //Modify: this
    //Effect: Once the view all recipe clicked, the application will show all food recipe which are available

    private void showRecipe(ActionEvent e) {
        if (e.getSource() == buttonViewAllRecipe) {
            textArea.setText("");


            for (int i = 0; i < foodList.getFoodList().size(); i++) {

                textArea.append(foodList.getFoodList().get(i).toString() + "\n");


            }


        }
    }


}






