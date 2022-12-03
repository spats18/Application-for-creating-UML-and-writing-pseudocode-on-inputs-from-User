package src;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * This class extends the abstract class Strategy.
 * It has abstract methods algorithm and getChoice.
 */
public class StrategyBox extends Strategy{

    /**
     * @param x1 is length parameter of box
     * @param y1 is length parameter of box
     * @param x2 is height parameter of box
     * @param y2 is height parameter of box
     * @param c1 string c1 is for choice one
     * @param c2 string c2 is for choice second
     *
     * This method suggests the data flow and algorithm to draw the box for classes.
     */
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

    /**
     * This method would give choices for drawing classes and boxes.
     *
     */
    @Override
    public void getChoice(){
        choice = JOptionPane.showInputDialog("Enter Class Name");
        if (choice == null || choice.length() == 0)
            choice = "class" + SingletonDataSrc.getInstance().boxes.size();
    }
}
