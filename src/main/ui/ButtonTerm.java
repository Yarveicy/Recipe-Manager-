package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//ButtonTerm is abstract class which has abstract method buttonClickhandler which helps us to reduce duplication in
//code and also help us have action event with buttons and response to GUI based on the implementation
// we can have different actions
public abstract class ButtonTerm {


    //Effect: by click, some event will happen , it depends on the implementation in other classses.
    //because this is abstract method
    protected abstract void buttonClickHandler(ActionEvent e);


}
