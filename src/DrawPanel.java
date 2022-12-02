package src;

import javax.swing.JPanel;


import java.awt.*;

public class DrawPanel extends JPanel implements Observer {
 
    Line line;

    DrawPanel(){
        setBackground(Color.cyan);
    }

    public JPanel getPanel(){
        return this;
    }
        
    @Override
    public void update() {
       repaint();
    }
    @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        drawRectangles(graphic);
        drawLines(graphic);
        drawTriangles(graphic);
        drawArrows(graphic);
        drawDiamonds(graphic);
    }
    private void drawRectangles(Graphics graphic){
        if(SingletonDataSrc.boxes == null)
            return;
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
    private void drawLines(Graphics graphic) {
        if(SingletonDataSrc.relation == null)
            return;
        for (int i = 0; i < SingletonDataSrc.relation.size(); i++){
            int[] coords = SingletonDataSrc.relation.get(i);
            int x1 = coords[0] ;
            int y1 = coords[1] ;
            int x2 = coords[2] ;
            int y2 = coords[3] ;
            graphic.setColor(Color.black);
            graphic.drawLine(x1, y1, x2, y2);
        }
    }
    private void drawTriangles(Graphics graphic) {
        if(SingletonDataSrc.triangles == null)
            return;
        for(int[] coords : SingletonDataSrc.triangles){
            int x1,x2,x3,y1,y2,y3;
            if(coords[2] == -1){
                x1 = coords[0];         y1 = coords[1];
                x2 = coords[0]+10;      y2 = coords[1];
                x3 = coords[0];         y3 = coords[1]+10;
            }else{
                x1 = coords[0];         y1 = coords[1];
                x2 = coords[0]-10;      y2 = coords[1];
                x3 = coords[0];         y3 = coords[1]-10;
            }
            Polygon tr = new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3); 
            graphic.setColor(Color.cyan);
            graphic.fillPolygon(tr);
            graphic.setColor(Color.black);
            graphic.drawPolygon(tr);
        }
    }
    private void drawDiamonds(Graphics graphic) {
        if(SingletonDataSrc.diamonds == null)
            return;
        for (int[] coords : SingletonDataSrc.diamonds){
            int x1,x2,x3,x4,y1,y2,y3,y4;
            if(coords[2] == -1){
                x1 = coords[0];         y1 = coords[1];
                x2 = coords[0]+8;       y2 = coords[1]+2;
                x3 = coords[0]+8;       y3 = coords[1]+8;
                x4 = coords[0]+2;       y4 = coords[1]+8;
            }else{
                x1 = coords[0];         y1 = coords[1];
                x2 = coords[0]-8;       y2 = coords[1]-1;
                x3 = coords[0]-8;       y3 = coords[1]-8;
                x4 = coords[0]-2;       y4 = coords[1]-8;
            }
            Polygon dia = new Polygon(new int[] {x1, x2, x3, x4}, new int[] {y1, y2, y3, y4}, 4);
            graphic.fillPolygon(dia);
            graphic.drawPolygon(dia);
        }
    }

    private void drawArrows(Graphics graphic) {
        if(SingletonDataSrc.arrows == null)
            return;
        for (int[] coords : SingletonDataSrc.arrows){
            graphic.fillRect(coords[0], coords[1], 5, 5);

           // graphic.fillPolygon(Array of X points, Array of Y points);
        }
        // for (int[] coords : SingletonDataSrc.arrows)
        // {
        //     int x1 = coords[0] ;
        //     int y1 = coords[1] ;
        //     int x2 = coords[2] ;
        //     int y2 = coords[3] ;

        //     double dx = x1 - x2;
        //     double dy = y1 - y2;
        //     double phi = Math.toRadians(40);
        //     int barb = 20;
        //     double theta = Math.atan2(dy, dx);
        //     //System.out.println("theta = " + Math.toDegrees(theta));
        //     double x, y, rho = theta + phi;
        //     for(int j = 0; j < 2; j++)
        // {
        //     x = x1 - barb * Math.cos(rho);
        //     y = y1 - barb * Math.sin(rho);
        //     g.drawLine(x1, y1, (int)x, (int)y);
        //     rho = theta - phi;
        // }
        // }
    }
}