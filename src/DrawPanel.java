package src;

import javax.swing.JPanel;


import java.awt.*;

public class DrawPanel extends JPanel implements Observer {//extends Observable
 
    Line line;

    DrawPanel(){
        setBackground(Color.cyan);
        SingletonDataSrc.getInstance();
    }

    public JPanel getPanel(){
        return this;
    }
    @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        System.out.println("Updating Graphics...");
        drawRectangles(graphic);
        drawLines(graphic);
        drawTriangles(graphic);
        drawArrows(graphic);
        drawDiamonds(graphic);
    }
    
    private void drawDiamonds(Graphics graphic) {
    }

    private void drawArrows(Graphics graphic) {
    }

    private void drawLines(Graphics graphic) {
        for (int i = 0; i < SingletonDataSrc.relation.size(); i++){
            int[] coords = SingletonDataSrc.relation.get(i);
            int x1 = coords[0] ;
            int y1 = coords[1] ;
            int x2 = coords[2] ;
            int y2 = coords[3] ;
            graphic.setColor(Color.white);
            graphic.drawLine(x1, y1, x2, y2);
        }
    }

    private void drawTriangles(Graphics graphic) {
    }

    private void drawRectangles(Graphics graphic){
        System.out.println("Drawing Boxes");
        for (String key : SingletonDataSrc.boxes.keySet())
        {
            int[] coords = SingletonDataSrc.boxes.get(key);
            int x = coords[0] - (SingletonDataSrc.WIDTH);
            int y = coords[1] - (SingletonDataSrc.HEIGHT);
            graphic.setColor(Color.yellow);
            graphic.fillRect(x, y, 2 * SingletonDataSrc.WIDTH, 2 * SingletonDataSrc.HEIGHT);
            graphic.setColor(Color.black);
            graphic.drawString(key, x+5, y+SingletonDataSrc.HEIGHT);
        }
    }

    @Override
    public void update() {
       repaint();
    }
}