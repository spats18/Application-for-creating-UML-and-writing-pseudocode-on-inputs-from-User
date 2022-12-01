package src;


public class StrategyBox extends Strategy{

    public StrategyBox(DrawPanel drawPanel) {
        super(drawPanel);
    }
    @Override
    public void algorithm() {
        panel.repaint();
    }


}
