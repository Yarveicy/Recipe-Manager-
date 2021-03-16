package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTextField extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;


    AddTextField() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //we also add icon picture
        button = new JButton("Submit");
        //button.setBounds(0, 0, 100, 50);
        button.addActionListener(this);


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));//add to
        textField.setFont(new Font("Consolas",Font.PLAIN,35));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.white);
        textField.setText("Food Title");
        //textField.setEditable(false);
        this.add(textField);
        this.add(button);


        this.pack();//pack the frame ---textfield should aff before packing
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {

            //setTitle(textField.getText());

            System.out.println("Welcome " + textField.getText());
            button.setEnabled(false);
            textField.setText("food");

            ;

            //textField.getText();
        }


    }


}
