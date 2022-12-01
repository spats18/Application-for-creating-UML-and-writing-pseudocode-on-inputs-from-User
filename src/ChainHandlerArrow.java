package src;

public class ChainHandlerArrow extends ChainHandler{
    
    @Override
    public Line handler(Line line, String choice){
        LineDecoArrow lineArr = new LineDecoArrow();
        lineArr.setLine(line);
        return lineArr;
    }
}