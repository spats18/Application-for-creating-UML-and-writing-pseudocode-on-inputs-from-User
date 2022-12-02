package src;

public abstract class LineDecorator implements Line {

    protected Line line;

    public void setLine(Line line){
        this.line = line;
    }
    @Override
    public void operation(int x1, int y1, int x2, int y2) {
       if(line !=null){
        line.operation(x1, y1, x2, y2);
       }
    }
    
}
