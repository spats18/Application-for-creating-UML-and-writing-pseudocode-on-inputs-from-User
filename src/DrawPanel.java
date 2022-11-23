package src;

import javax.swing.JPanel;
import java.awt.*;

public class DrawPanel extends JPanel {//extends Observable
    JPanel panel;
    DrawPanel(){
        panel = new JPanel(new GridLayout(1,1,0,0)); 
        panel.setBackground(Color.cyan);
    }
    public JPanel getPanel(){
        return panel;
    }

    public void decideAlgo(int x, int y){
        boolean inVicinity = SingletonDataSrc.inBoxVicinity(x, y);
        Strategy strategy;
        if(inVicinity){
            //line
            strategy = new StrategyLine();

        }else{
            //box
            strategy = new StrategyBox();
            super.repaint();
        }
    }
    @Override
    public void paintComponent(Graphics graphic){
        int[] coords = SingletonDataSrc.coordinates.getLast();
        int x = coords[0] - (SingletonDataSrc.WIDTH);
        int y = coords[1] - (SingletonDataSrc.HEIGHT);
        graphic.fillRect(x, y, 2 * SingletonDataSrc.WIDTH, 2 * SingletonDataSrc.HEIGHT);
        graphic.setColor(Color.yellow);
    }
}
