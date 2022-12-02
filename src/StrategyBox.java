package src;

import javax.swing.JOptionPane;

public class StrategyBox extends Strategy{

    @Override
    public void algorithm(int x1, int y1, int x2, int y2) {
        choice = JOptionPane.showInputDialog("Enter Class Name"); //<----- Get user input for class name here
        if (choice == null || choice.length() < 1)
        choice = "Class" + SingletonDataSrc.boxes.size();
        
        String s = "Class " + choice + " Added!";
        SingletonDataSrc.status = s;
        System.out.print(choice);
        SingletonDataSrc.setClassName(choice, x1, y1);
    }


}
