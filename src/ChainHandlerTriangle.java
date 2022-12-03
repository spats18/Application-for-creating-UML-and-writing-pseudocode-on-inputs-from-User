package src;

/**
 *
 */
public class ChainHandlerTriangle extends ChainHandler{
    
    @Override
    public Line handler(Line line, String choice){
        if(choice.equals("Inheritance")){
            LineDecoTriangle lineTri = new LineDecoTriangle();
            lineTri.setLine(line);
            return lineTri;
        }else{
            return successor.handler(line, choice);
        }
    }
}
