package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SingletonRadioMenu extends JFrame implements ActionListener{
    private static SingletonRadioMenu instance;
    public static String Relationship; 

    private static final String ASSOCIATION = "Association";
    private static final String INHERITANCE = "Inheritance";
    private static final String COMPOSITION = "Composition";
    
    private SingletonRadioMenu()
    {
        super("Choose Class Relationship");
        JRadioButton option1 = new JRadioButton(ASSOCIATION);
        option1.setActionCommand(ASSOCIATION);
        option1.addActionListener(this);

        JRadioButton option2 = new JRadioButton(INHERITANCE);
        option2.setActionCommand(INHERITANCE);
        option2.addActionListener(this);

        JRadioButton option3 = new JRadioButton(COMPOSITION);
        option3.setActionCommand(COMPOSITION);
        option3.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
 
        setLayout(new FlowLayout());
 
        add(option1);
        add(option2);
        add(option3);
 
        pack();
        setVisible(false);

    }
    public static void getInstance()
    {
        if (instance == null)
        {
           instance = new SingletonRadioMenu(); 
        }
    }

    public static void showMenu()
    {
        instance.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Relationship = e.getActionCommand();
        instance.setVisible(false);
        System.out.println(Relationship);
    }
}
