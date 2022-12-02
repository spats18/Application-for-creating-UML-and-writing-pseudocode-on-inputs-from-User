package src;
import java.awt.*;

public class LineConcrete implements Line {
    int x1, y1, x2, y2;
    public LineConcrete(int x1, int y1, int x2, int y2) {

    }

    @Override
    public void operation(Graphics g) {
        SingletonDataSrc.addLine(x1, y1, x2, y2);
    }
}
