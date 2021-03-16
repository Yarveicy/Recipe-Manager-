package ui;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    JButton button;


    MyFrame() {


        JLabel label1 = new JLabel();//create label for redPanel
        label1.setText("Hi");
        label1.setVerticalAlignment(JLabel.BOTTOM);//set alignment at TOP
        label1.setHorizontalAlignment(JLabel.RIGHT);//set alignment at TOP
        label1.setBounds(0, 0, 250, 250);

        JPanel redPanel = new JPanel();//create red panel
        redPanel.setBounds(0, 0, 250, 750);
        redPanel.setBackground(Color.red);
        redPanel.setLayout(new BorderLayout());//set border for red layout

        JPanel bluePanel = new JPanel();//create blue panel
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(200, 0, 200, 750);
        bluePanel.setLayout(new BorderLayout());//set border for blue layout


        JPanel greenPanel = new JPanel();//create green panel
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(400, 0, 200, 750);
        greenPanel.setLayout(new BorderLayout());//set border for green layout


        JFrame frame = new JFrame(); //creates a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        frame.setLayout(null);
        frame.setSize(750, 750);//sets the x dimension and y dimension  of our frame
        frame.setVisible(true);//make frame visible
        frame.setTitle("Food Recipe Application");//set title of the frame
        redPanel.add(label1);//add label to redPanel
        frame.add(redPanel);//add redPanel to frame
        frame.add(bluePanel);//add bluePanel to frame
        frame.add(greenPanel);//add greenPanel to frame
        greenPanel.add(label1);
        redPanel.add(label1);

        // void ButtonAddRecipes();
        //frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        frame.setLayout(null);
        frame.setSize(500, 500);//sets the x dimension and y dimension  of our frame
        frame.setVisible(true);//make frame visible
        //frame.add(button);


        //this.setResizable(false);//prevent frame from being resize
        //this.setVisible(true);//make frame visible
        //ImageIcon image = new ImageIcon("1200px-Concord_Pacific_Master_Plan_Area.jpg");//create image icon
        // this.setIconImage(image.getImage());//change icon of frame
        //this.getContentPane().setBackground(Color.white);//change color of background*/


    }


}


