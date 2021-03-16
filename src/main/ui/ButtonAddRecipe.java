package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddRecipe extends JFrame implements ActionListener {
    JButton buttonAddRecipe;
    JButton buttonViewAllRecipe;
    JButton buttonViewRecipeDetails;
    JButton buttonRateRecipe;
    JButton buttonExit;
    JButton buttonLoad;
    JButton buttonSave;
    JTextField textField;
    JTextField ViewAllRecipe;
    JTextField ViewRecipeDetails;
    JTextField RateRecipe;
    JTextField Exit;
    JTextField Load;
    JTextField Save;


    //Jlable lable;  We can add in future

    ButtonAddRecipe() {


        buttonAddRecipe = new JButton();
        buttonViewAllRecipe = new JButton();
        buttonViewRecipeDetails = new JButton();
        buttonRateRecipe = new JButton();
        buttonExit = new JButton();
        buttonLoad = new JButton();
        buttonSave = new JButton();
        //AddActionListener
        buttonAddRecipe.addActionListener(this);
        buttonViewAllRecipe.addActionListener(this);
        buttonViewRecipeDetails.addActionListener(this);
        buttonRateRecipe.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonLoad.addActionListener(this);
        buttonSave.addActionListener(this);

        //TextField

        textField = new JTextField();
        ViewAllRecipe = new JTextField();
        ViewRecipeDetails = new JTextField();
        RateRecipe = new JTextField();
        Exit = new JTextField();
        Load = new JTextField();
        Save = new JTextField();


        this.add(textField);
        this.add(buttonSave);


        //Button position
        buttonAddRecipe.setBounds(0, 0, 100, 50);
        buttonViewAllRecipe.setBounds(0, 50, 100, 50);
        buttonViewRecipeDetails.setBounds(0, 100, 100, 50);
        buttonRateRecipe.setBounds(0, 150, 100, 50);
        buttonExit.setBounds(0, 200, 100, 50);
        buttonLoad.setBounds(0, 250, 100, 50);
        buttonSave.setBounds(0, 300, 100, 50);


        //buttonViewAllRecipe.add(this);


        //Button inside name
        buttonAddRecipe.setText("Add Recipe");
        buttonViewAllRecipe.setText("View All Recipe");
        buttonViewRecipeDetails.setText("Recipe Details");
        buttonRateRecipe.setText("Rate");
        buttonExit.setText("Exit");
        buttonLoad.setText("Load");
        buttonSave.setText("Save");


        buttonAddRecipe.setFocusable(false);

        //button.addActionListener(e -> StringIndexOutOfBoundsE);
        //button.setIcon(icon);
        buttonAddRecipe.setHorizontalTextPosition(JButton.CENTER);//Text position
        buttonAddRecipe.setVerticalTextPosition(JButton.BOTTOM);//Text position
        buttonAddRecipe.setFont(new Font("Comic sans", Font.BOLD, 10));
        buttonAddRecipe.setIconTextGap(-15);
        buttonAddRecipe.setForeground(Color.black);
        buttonAddRecipe.setBackground(Color.LIGHT_GRAY);
        buttonAddRecipe.setBorder(BorderFactory.createEtchedBorder());
        //button.setEnabled(false);;//disable button


        //frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setLayout(null);
        this.setSize(500, 500);//sets the x dimension and y dimension  of our frame
        this.setVisible(true);//make frame visible


        this.add(buttonAddRecipe);
        this.add(buttonViewAllRecipe);
        this.add(buttonViewRecipeDetails);
        this.add(buttonRateRecipe);
        this.add(buttonExit);
        this.add(buttonLoad);
        this.add(buttonSave);

        /////////////////////////////////
        this.setLayout(new FlowLayout());

        //we also add icon picture
        buttonSave = new JButton("AddRecipe");
        //button.setBounds(0, 0, 100, 50);
        buttonSave.addActionListener(this);


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 40));//add to
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.white);
        textField.setText("Food Title");
        //textField.setEditable(false);
        this.add(textField);
        this.add(buttonAddRecipe);


        /////////////////////////////////


        /////////////////////////////////
        this.setLayout(new FlowLayout());

        //we also add icon picture
        //buttonSave = new JButton("AddRecipe");
        //button.setBounds(0, 0, 100, 50);
        //buttonSave.addActionListener(this);


        //textField = new JTextField();
        ViewAllRecipe.setPreferredSize(new Dimension(100, 40));//add to
        ViewAllRecipe.setFont(new Font("Consolas", Font.PLAIN, 35));
        ViewAllRecipe.setForeground(new Color(0x00FF00));
        ViewAllRecipe.setBackground(Color.BLACK);
        ViewAllRecipe.setCaretColor(Color.white);
        ViewAllRecipe.setText("View All");
        //textField.setEditable(false);
        this.add(ViewAllRecipe);
        this.add(buttonViewAllRecipe);


        /////////////////////////////////










        /////////////////////////////////
        this.setLayout(new FlowLayout());

        //we also add icon picture
        buttonSave = new JButton("Submit");
        //button.setBounds(0, 0, 100, 50);
        buttonSave.addActionListener(this);


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 40));//add to
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.white);
        textField.setText("Food Title");
        //textField.setEditable(false);
        this.add(textField);
        this.add(buttonSave);


        /////////////////////////////////

        this.pack();//pack the frame ---textfield should aff before packing

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddRecipe) {
            System.out.println("Hello! " + textField.getText());


        }

        if (e.getSource() == buttonViewAllRecipe) {

            System.out.println("2 " + textField.getText());
        }
        if (e.getSource() == buttonViewRecipeDetails) {

            System.out.println("3 " + textField.getText());
        }
        if (e.getSource() == buttonRateRecipe) {

            System.out.println("4 " + textField.getText());
        }
        if (e.getSource() == buttonExit) {

            System.out.println("5 " + textField.getText());
        }
        if (e.getSource() == buttonLoad) {

            System.out.println("6 " + textField.getText());
        }
        if (e.getSource() == buttonSave) {

            System.out.println("7 " + textField.getText());
        }

    }
}






