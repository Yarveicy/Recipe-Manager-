package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;


//ButtonExiting  class which Represent buttons that help us to Exit the application using frames and actions with click
//which extends Button Term
public class ButtonExiting extends ButtonTerm {


    public ButtonExiting(JButton buttonExit) {
        this.buttonExit = buttonExit;
    }

    JButton buttonExit = new JButton("Exit");//Represent the new Button object

    //Modify: this
    //Effect: Once the exit button clicked the application is closed by the system
    @Override
    protected void buttonClickHandler(ActionEvent e) {
        if (e.getSource() == buttonExit) {

            System.out.println(" You press Exit ");
            System.exit(0);


        }
    }
}
