package src;

import java.util.*;

public class LineDecoTriangle extends LineDecorator{
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        super.operation(x1, y1, x2, y2, boxDirection, c1, c2);

        int slope = (y2-y1)/(x2-x1);
        int yIntercept =  y2 - (slope * x2);
        if(boxDirection == -1)
            SingletonDataSrc.getInstance().addTriangles(x1,y1, boxDirection, slope, yIntercept);
        else
            SingletonDataSrc.getInstance().addTriangles(x2,y2, boxDirection, slope, yIntercept);
        
        ArrayList<String> toModify = SingletonDataSrc.getInstance().classList.get(c1);
        toModify.set(0,"Class "+ c1 +" extends "+ c2 +" {");
        SingletonDataSrc.getInstance().updateClassList(c1, toModify);
    }
}
