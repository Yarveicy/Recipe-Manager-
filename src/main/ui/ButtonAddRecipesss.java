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


public class ButtonAddRecipesss extends JFrame implements ActionListener {


    private static final String JSON_STORE = "./data/workroom.json";
    private FoodList foodList = new FoodList();
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);
    JTextArea textArea = new JTextArea(20, 20);


    JButton buttonAddRecipe = new JButton("AddRecipe");
    JButton buttonViewAllRecipe = new JButton("ViewAllRecipe");
    JButton buttonViewRecipeDetails = new JButton("Details");
    JButton buttonExit = new JButton("Exit");
    JButton buttonLoad = new JButton("Load");
    JButton buttonSave = new JButton("Save");



    File wavFile = new File("./data/DanceMonkey.wav");
    AudioClip sound;





    ButtonAddRecipesss() {

///////////////////////////////
        JFrame frame = new JFrame("CPSC 210");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));
        frame.add(buttonAddRecipe, BorderLayout.CENTER);
        frame.add(buttonViewAllRecipe, BorderLayout.WEST);
        frame.add(buttonViewRecipeDetails, BorderLayout.EAST);
        frame.add(buttonSave, BorderLayout.NORTH);
        frame.add(buttonLoad, BorderLayout.SOUTH);
        frame.add(buttonExit, BorderLayout.CENTER);
        frame.setVisible(true);

        buttonAddRecipe.addActionListener(this);
        buttonViewAllRecipe.addActionListener(this);
        buttonViewRecipeDetails.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonLoad.addActionListener(this);
        buttonSave.addActionListener(this);
//////////////////////////////////////////////////
        resultFrame();


/////////////////////////////////////////////////
        showInputFoodRecipe();


    }

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
            System.exit(0);



        }
    }

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


            //textArea.setText(load.getText());


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
                textArea.setText("You Clicked On Save Button");



                sound.play();

            } catch (FileNotFoundException em) {
                System.out.println("Unable to write to file: " + JSON_STORE);
                textArea.setText("You Clicked On Save Button");


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

                    //textArea.setText(food.getTitle().toString());
                    // textArea.setText(food.getCookingInstruction().toString());


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
            textArea.setText("");


            for (int i = 0; i < foodList.getFoodList().size(); i++) {

                //textArea.setText(foodList.getFoodList().toString());
                //textArea.setText(getFoodList().toString() + "\n");

                textArea.append(foodList.getFoodList().get(i).toString() + "\n");
                //textArea.setText(foodList.getFoodList().get(i).toString() + "\n");


            }


        }
    }


}






