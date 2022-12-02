package src;
import java.awt.*;

public abstract class LineDecorator implements Line {

    protected Line line;
    protected int x1, y1;

    public void setLine(Line line){
        this.line = line;
    }
    @Override
    public void operation(Graphics g) {
       if(line !=null){
        line.operation(g);
       }
    }
    
}
