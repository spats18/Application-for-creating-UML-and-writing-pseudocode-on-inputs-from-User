package src;

import javax.swing.JOptionPane;

public class StrategyBox extends Strategy{

    @Override
    public void algorithm(int x1, int y1, int x2, int y2) {
        super.algorithm(x1, y1, x2, y2);
        choice = JOptionPane.showInputDialog("Enter Class Name");
        
        if (choice == null || choice.length() == 0)
            choice = "Class" + SingletonDataSrc.boxes.size();

        String s = "Class " + choice + " Added!";
        SingletonDataSrc.status = s;
        SingletonDataSrc.setClassName(choice, x1, y1);
    }


}
