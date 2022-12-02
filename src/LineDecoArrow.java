package src;


public class LineDecoArrow extends LineDecorator{
    @Override
    public void operation(int x1, int y1, int x2, int y2){
        super.operation(x1, y1, x2, y2);

        SingletonDataSrc.addArrows(x1, y1);
    }
}
