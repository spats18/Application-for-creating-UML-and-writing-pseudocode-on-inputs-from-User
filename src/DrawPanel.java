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

    public void decideAlgo(float x, float y){
        boolean inVicinity = SingletonDataSrc.inBoxVicinity(x, y);
        Strategy strategy;
        if(inVicinity){
            //line
            strategy = new StrategyLine();

        }else{
            //box
            strategy = new StrategyBox();

        }
    }
    @Override
    public void paintComponent(Graphics graphic){
        int[] coords = SingletonDataSrc.coordinates.getLast();
        graphic.fillRect(coords[0], coords[1], 50, 30);
        graphic.setColor(Color.yellow);
    }
}
