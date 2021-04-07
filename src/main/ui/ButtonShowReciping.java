package ui;

import model.FoodList;

import javax.swing.*;
import java.awt.event.ActionEvent;


//ButtonShowReciping class which Represent buttons that help us to show Recipe by clicking on the Show Recipe button
//which extends ButtonTerm/
public class ButtonShowReciping extends ButtonTerm  {


    private FoodList foodList = new FoodList();// create foodlist object;
    JTextArea textArea = new JTextArea(20, 20);//Represent the text Area for showi
    JButton buttonViewAllRecipe = new JButton("ViewAllRecipe");//Re


    public ButtonShowReciping(FoodList foodList, JTextArea textArea, JButton buttonViewAllRecipe) {
        this.foodList = foodList;
        this.textArea = textArea;
        this.buttonViewAllRecipe = buttonViewAllRecipe;
    }

    //Modify: this
    //Effect: Once the view all recipe clicked, the application will show all food recipe which are available

    @Override
    protected void buttonClickHandler(ActionEvent e) {
        if (e.getSource() == buttonViewAllRecipe) {
            textArea.setText("");


            for (int i = 0; i < foodList.getFoodList().size(); i++) {

                textArea.append(foodList.getFoodList().get(i).toString() + "\n");


            }


        }
    }
}
