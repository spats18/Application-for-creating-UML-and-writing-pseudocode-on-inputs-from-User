package src;


abstract class Strategy extends Observable{
    String choice;
    public abstract void algorithm(int x1, int y1, int x2, int y2);
}
