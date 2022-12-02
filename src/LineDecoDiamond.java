package src;
public class LineDecoDiamond extends LineDecorator{
    
    @Override
    public void operation(int x1, int y1, int x2, int y2){
        super.operation(x1, y1, x2, y2);

        // int x = x2 - SingletonDataSrc.WIDTH/2;
        // int y = y2 - SingletonDataSrc.HEIGHT/2;

        SingletonDataSrc.addDiamonds(x1, y1);
    }

}
