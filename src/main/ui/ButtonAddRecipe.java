package ui;

import model.Food;
import model.FoodList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ButtonAddRecipe extends JFrame implements ActionListener {


    private static final String JSON_STORE = "./data/workroom.json";
    private FoodList foodList = new FoodList();
    JTextArea textArea = new JTextArea(20, 20);

    //private JsonWriter jsonWriter;
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    //private JsonReader jsonReader;
    JsonReader jsonReader = new JsonReader(JSON_STORE);
    // foodList = new FoodList();

    JTextField viewRecipeDetails;
    JTextField exit;
    JTextField load;
    JTextField save;
    //button name

    JButton buttonAddRecipe = new JButton();
    JButton buttonViewAllRecipe = new JButton();
    JButton buttonViewRecipeDetails = new JButton();
    JButton buttonExit = new JButton();
    JButton buttonLoad = new JButton();
    JButton buttonSave = new JButton();


    //JTextField outPut;


    ButtonAddRecipe() {


        // Sets JTextArea font and color.
        Font font = new Font("Segoe Script", Font.BOLD, 12);
        textArea.setFont(font);
        textArea.setForeground(Color.BLUE);
        textArea.setBackground(Color.yellow);

        buttonSpecifcation();


        buttonSepcificationtwo();


        this.setLayout(new FlowLayout());


        this.add(buttonViewRecipeDetails);


        this.setLayout(new FlowLayout());


        showInputFoodRecipe();
    }

    private void buttonSepcificationtwo() {
        buttonAddRecipe.setText("Add Recipe");
        buttonViewAllRecipe.setText("View All Recipe");
        buttonViewRecipeDetails.setText("Recipe Details");
        buttonExit.setText("Exit");
        buttonLoad.setText("Load");
        buttonSave.setText("Save");

        this.add(buttonAddRecipe);
        this.add(buttonViewAllRecipe);
        this.add(buttonViewRecipeDetails);
        this.add(buttonExit);
        this.add(buttonLoad);
        this.add(buttonSave);


        //frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        //this.setLayout(null);
        this.setTitle("My personal Project CPSC210");
        this.setSize(800, 800);//sets the x dimension and y dimension  of our frame
        this.setVisible(true);//make frame visible


        this.setLayout(new FlowLayout());
        this.add(buttonAddRecipe);
        this.add(buttonViewAllRecipe);
        this.add(textArea);
    }

    private void buttonSpecifcation() {
        buttonAddRecipe.addActionListener(this);
        buttonViewAllRecipe.addActionListener(this);
        buttonViewRecipeDetails.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonLoad.addActionListener(this);
        buttonSave.addActionListener(this);


        exit = new JTextField();
        load = new JTextField();
        save = new JTextField();


        //Button position
        buttonAddRecipe.setBounds(0, 0, 100, 50);
        buttonViewAllRecipe.setBounds(50, 50, 100, 50);
        buttonViewRecipeDetails.setBounds(0, 100, 100, 50);
        buttonExit.setBounds(100, 150, 100, 50);
        buttonLoad.setBounds(150, 200, 100, 50);
        buttonSave.setBounds(200, 250, 100, 50);
        textArea.setBounds(600, 500, 200, 200);
    }

    private void showInputFoodRecipe() {
        JTextField title = new JTextField(5);
        JTextField time = new JTextField(5);
        JTextField ingredients = new JTextField(5);
        JTextField cookingInstruction = new JTextField(5);
        JTextField stars = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Title:"));
        myPanel.add(title);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Time:"));
        myPanel.add(time);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Ingredients:"));
        myPanel.add(ingredients);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("CookingInstruction:"));
        myPanel.add(cookingInstruction);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Stars:"));
        myPanel.add(stars);


        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter title,time,ingredients,instruction,rating Values", JOptionPane.OK_CANCEL_OPTION);
        showButtonClick(title, time, ingredients, cookingInstruction, stars, result);
    }

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


    @Override
    public void actionPerformed(ActionEvent e) {

        showRecipe(e);
        showMethoidButtonAdd(e);
        showViewRecioeDetails(e);
        showButonSave(e);
        showButtonLoad(e);
        showButtonExit(e);

    }

    private void showButtonExit(ActionEvent e) {
        if (e.getSource() == buttonExit) {

            System.out.println(" You press Exit ");


        }
    }

    private void showButtonLoad(ActionEvent e) {
        if (e.getSource() == buttonLoad) {


            System.out.println("You prsesed load" + load.getText());

            try {
                foodList = jsonReader.read();
                System.out.println("Loaded foodlist from " + JSON_STORE);
            } catch (IOException enn) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }


            textArea.setText(load.getText());


        }
    }

    private void showButonSave(ActionEvent e) {
        if (e.getSource() == buttonSave) {

            System.out.println(" You press Save ");

            try {
                jsonWriter.open();
                jsonWriter.write(foodList);
                jsonWriter.close();
                System.out.println("Saved foodList to " + JSON_STORE);
            } catch (FileNotFoundException em) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }

        }
    }

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
            //myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("cookingInstruction:"));
            myPanel.add(cookingInstruction);
            //myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("stars:"));
            myPanel.add(stars);


            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter title,time,ingredients,instruction,rating Values", JOptionPane.OK_CANCEL_OPTION);
            showButtonClick2(title, time, ingredients, cookingInstruction, stars, result);


        }
    }

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

    private void showRecipe(ActionEvent e) {
        if (e.getSource() == buttonViewAllRecipe) {


            for (int i = 0; i < foodList.getFoodList().size(); i++) {

                textArea.setText(foodList.getFoodList().toString());


            }


        }
    }


}









