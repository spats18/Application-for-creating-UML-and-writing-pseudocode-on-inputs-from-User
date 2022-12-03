package src;


abstract class Strategy{
    String choice;
    int boxDirection;// icon at low = -1 (downward), high = 1 (upward)
    int xl, yl, xh, yh;
    public abstract void algorithm(int x1, int y1, int x2, int y2, String c1, String c2);
    public abstract void getChoice();
}
