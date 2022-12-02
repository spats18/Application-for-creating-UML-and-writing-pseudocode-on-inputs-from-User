package src;

public class LineConcrete implements Line {

    @Override
    public void operation(int x1, int y1, int x2, int y2){
        SingletonDataSrc.addLine(x1, y1, x2, y2);
    }
}
