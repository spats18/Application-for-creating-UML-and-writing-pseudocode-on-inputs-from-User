package src;
import java.awt.*;
import java.util.*;

public class LineConcrete implements Line {

    @Override
    public void operation(Graphics g) {
        // TODO Auto-generated method stub
        for (int i = 0; i < SingletonDataSrc.lineCoordinates.size(); i++)
        {
            int[] coords = SingletonDataSrc.lineCoordinates.get(i);
            int x1 = coords[0] ;
            int y1 = coords[1] ;
            int x2 = coords[2] ;
            int y2 = coords[3] ;
            g.setColor(Color.white);
            g.drawLine(x1, y1, x2, y2);

        }
        
    }

    
    
}
