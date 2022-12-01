package src;

public abstract class LineDecorator implements Line {

    protected Line line;

    public void setLine(Line line){
        this.line = line;
    }
    @Override
    public void operation() {
       if(line !=null){
        line.operation();
       }
    }
    
}
