package src;

import java.util.*;

public class LineDecoArrow extends LineDecorator{
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        super.operation(x1, y1, x2, y2, boxDirection, c1, c2);
        SingletonDataSrc.addArrows(x1, y1);
        if(boxDirection == 0)
            SingletonDataSrc.addArrows(x1,y1);
        else
            SingletonDataSrc.addArrows(x2,y2);
        
            ArrayList<String> toModify = SingletonDataSrc.classList.get(c2);
            toModify.add(1," }");
            toModify.add(1, "       "+c1 +" assObject"+ (++SingletonDataSrc.countAssociation)+ " = new "+ c1 +"( ) ;");
            toModify.add(1,"    method"+ (SingletonDataSrc.countAssociation)+ "( ){");
            SingletonDataSrc.updateClassList(c2, toModify);
    }
}
