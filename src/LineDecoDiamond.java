package src;

import java.util.*;
public class LineDecoDiamond extends LineDecorator{
    
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        super.operation(x1, y1, x2, y2, boxDirection, c1, c2);

        if(boxDirection == 0)
            SingletonDataSrc.addDiamonds(x2,y2);
        else
            SingletonDataSrc.addDiamonds(x1,y1);

    ArrayList<String> toModify = SingletonDataSrc.classList.get(c1);
    toModify.add(1,"    "+c2 +" composeObject"+ (++SingletonDataSrc.countComposition)+ "= new "+ c2 +"( ) ;");
    SingletonDataSrc.updateClassList(c1, toModify);
    }

}
