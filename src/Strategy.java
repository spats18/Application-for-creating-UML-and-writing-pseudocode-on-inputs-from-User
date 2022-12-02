package src;


abstract class Strategy extends Observable{
    String choice;
    int boxDirection;// icon at low = 0, high = 1
    int xl, yl, xh, yh;
    public abstract void algorithm(int x1, int y1, int x2, int y2);
    public abstract void getChoice();
}
