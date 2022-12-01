package src;
import java.awt.*;


public class LineDecoArrow extends LineDecorator{
    @Override
    public void operation(Graphics g){
        super.operation(g);
        g.setColor(Color.white);
        for (int i = 0; i < SingletonDataSrc.lineCoordinates.size(); i++)
        {
            int[] coords = SingletonDataSrc.lineCoordinates.get(i);
            int x1 = coords[0] ;
            int y1 = coords[1] ;
            int x2 = coords[2] ;
            int y2 = coords[3] ;

            double dx = x1 - x2;
            double dy = y1 - y2;
            double phi = Math.toRadians(40);
            int barb = 20;
            double theta = Math.atan2(dy, dx);
            //System.out.println("theta = " + Math.toDegrees(theta));
            double x, y, rho = theta + phi;
            for(int j = 0; j < 2; j++)
        {
            x = x1 - barb * Math.cos(rho);
            y = y1 - barb * Math.sin(rho);
            g.drawLine(x1, y1, (int)x, (int)y);
            rho = theta - phi;
        }
        }
    }
}
