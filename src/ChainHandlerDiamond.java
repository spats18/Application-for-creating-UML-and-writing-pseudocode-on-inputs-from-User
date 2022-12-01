package src;

public class ChainHandlerDiamond extends ChainHandler{
    
    @Override
    public Line handler(Line line, String choice){
        if(choice.equals("COMPOSITION")){
            LineDecoDiamond lineDia = new LineDecoDiamond();
            lineDia.setLine(line);
            return lineDia;
        }else{
            return successor.handler(line, choice);
        }
    }
}
