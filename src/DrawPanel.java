package src;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.*;

public class DrawPanel extends JPanel  {//extends Observable
    Strategy strategy;
    Line line;

    DrawPanel(){
        setBackground(Color.cyan);
        SingletonDataSrc.getInstance();
    }

    public JPanel getPanel(){
        return this;
    }
    public void decideAlgo(int x, int y, String choice){
        boolean inVicinity = SingletonDataSrc.inBoxVicinity(x, y);
        
        if(inVicinity){
            //strategy = new StrategyLine(this);
            SingletonDataSrc.addLine(x, y);
            strategy.algorithm();
            repaint();
            SingletonDataSrc.status = "New Line Added!";
            
        }else{
            //box
            //strategy = new StrategyBox(this);
            repaint();

            System.out.print(choice);

            String className = JOptionPane.showInputDialog("Enter Class Name"); //<----- Get user input for class name here
            if (className == null || className.length() < 1)
                className = "Class" + SingletonDataSrc.coordinates.size();

            String s = "Class " + className + " Added!";
            SingletonDataSrc.status = s;
            System.out.print(className);
        }
    }

       @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        System.out.println("Updating Graphics...");
        drawRectangles(graphic);
    }
    
    private void drawRectangles(Graphics g)
    {
        System.out.println("Drawing Boxes");
        for (int i = 0; i < SingletonDataSrc.coordinates.size(); i++)
        {
            int[] coords = SingletonDataSrc.coordinates.get(i);
            int x = coords[0] - (SingletonDataSrc.WIDTH);
            int y = coords[1] - (SingletonDataSrc.HEIGHT);
            g.setColor(Color.yellow);
            g.fillRect(x, y, 2 * SingletonDataSrc.WIDTH, 2 * SingletonDataSrc.HEIGHT);
        }
    }
}