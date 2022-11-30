package src;

import javax.swing.JPanel;


import java.awt.*;

public class DrawPanel extends JPanel  {//extends Observable
    Strategy strategy;

    DrawPanel(){
        setBackground(Color.cyan);
        SingletonDataSrc.getInstance();
    }

    public JPanel getPanel(){
        return this;
    }

    public void decideAlgo(int x, int y){
        boolean inVicinity = SingletonDataSrc.inBoxVicinity(x, y);
        
        if(inVicinity){
            //line
            strategy = new StrategyLine();
            
        }else{
            //box
            strategy = new StrategyBox();
            repaint();
            System.out.println("BOX");
        }
    }
    @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        for (int i = 0; i < SingletonDataSrc.coordinates.size(); i++)
        {
            int[] coords = SingletonDataSrc.coordinates.get(i);
            int x = coords[0] - (SingletonDataSrc.WIDTH);
            int y = coords[1] - (SingletonDataSrc.HEIGHT);
            graphic.setColor(Color.yellow);
            graphic.fillRect(x, y, 2 * SingletonDataSrc.WIDTH, 2 * SingletonDataSrc.HEIGHT);

        }
    }
}
