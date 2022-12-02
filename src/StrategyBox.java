package src;

import javax.swing.JOptionPane;

public class StrategyBox extends Strategy{

    @Override
    public void algorithm(int x1, int y1, int x2, int y2) {
        this.xl = x1;
        this.yl = y1;
        this.getChoice();
        String s = "Class " + choice + " Added!";
        SingletonDataSrc.status = s;
        SingletonDataSrc.setClassName(choice, xl, yl);
        SingletonDataSrc.addClassList("Class "+ choice +" {");
        SingletonDataSrc.addClassList("}\n");
    }

    @Override
    public void getChoice(){
        choice = JOptionPane.showInputDialog("Enter Class Name");
        if (choice == null || choice.length() == 0)
            choice = "Class" + SingletonDataSrc.boxes.size();
    }
}
