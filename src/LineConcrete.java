package src;

public class LineConcrete implements Line {
    String choice;
    @Override
    public void operation(int x1, int y1, int x2, int y2, int boxDirection, String c1, String c2){
        SingletonDataSrc.addLine(x1, y1, x2, y2);
    }
}
