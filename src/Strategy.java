package src;


public class Strategy extends Observable{
    String choice;
    DrawPanel panel;
    Strategy(DrawPanel panel){
        this.panel = panel;
    }
    public void algorithm(){
    }
}
