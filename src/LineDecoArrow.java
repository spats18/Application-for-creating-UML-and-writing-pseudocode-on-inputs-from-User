package src;

import java.util.*;

public class LineDecoArrow extends LineDecorator{
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        super.operation(x1, y1, x2, y2, boxDirection, c1, c2);

        if(boxDirection == -1)
            SingletonDataSrc.addArrows(x1,y1, boxDirection);
        else
            SingletonDataSrc.addArrows(x2,y2, boxDirection);
        
            ArrayList<String> toModify = SingletonDataSrc.classList.get(c1);
            toModify.add(1," }");
            toModify.add(1, "\t\t\t"+c2 +" assObject"+ (++SingletonDataSrc.countAssociation)+ " = new "+ c2 +"( ) ;");
            toModify.add(1,"\tmethod"+ (SingletonDataSrc.countAssociation)+ "( ){");
            SingletonDataSrc.updateClassList(c1, toModify);
    }
}
