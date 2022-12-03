package src;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class StrategyBox extends Strategy{

    @Override
    public void algorithm(int x1, int y1, int x2, int y2, String c1, String c2) {
        this.xl = x1;
        this.yl = y1;
        this.getChoice();
        SingletonDataSrc.getInstance().updateStatus("Class " + choice + " Added!");
        SingletonDataSrc.getInstance().setClassName(choice, xl, yl);
        ArrayList<String> toAdd = new ArrayList<>(Arrays.asList(new String[]{"Class "+ choice +" {", "}"}));
        SingletonDataSrc.getInstance().updateClassList(choice, toAdd);
    }

    @Override
    public void getChoice(){
        choice = JOptionPane.showInputDialog("Enter Class Name");
        if (choice == null || choice.length() == 0)
            choice = "class" + SingletonDataSrc.getInstance().boxes.size();
    }
}
