package src;

import java.util.*;

public class LineDecoTriangle extends LineDecorator{
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        super.operation(x1, y1, x2, y2, boxDirection, c1, c2);
        if(boxDirection == -1)
            SingletonDataSrc.addTriangles(x1,y1, boxDirection);
        else
            SingletonDataSrc.addTriangles(x2,y2, boxDirection);
        
        ArrayList<String> toModify = SingletonDataSrc.classList.get(c1);
        toModify.set(0,"Class "+ c1 +" extends "+ c2 +" {");
        SingletonDataSrc.updateClassList(c1, toModify);
    }
}
