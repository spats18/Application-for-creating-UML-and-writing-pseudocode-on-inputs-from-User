package src;

import java.util.*;

public class LineDecoTriangle extends LineDecorator{
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        super.operation(x1, y1, x2, y2, boxDirection, c1, c2);
        if(boxDirection == 0)
            SingletonDataSrc.addTriangles(x1,y1);
        else
            SingletonDataSrc.addTriangles(x2,y2);
        
        ArrayList<String> toModify = SingletonDataSrc.classList.get(c2);
        toModify.set(0,"Class "+ c2 +" extends "+ c1 +" {");
        SingletonDataSrc.updateClassList(c2, toModify);
    }
}
