package src;

public class StrategyLine extends Strategy{

    public StrategyLine(DrawPanel drawPanel) {
        super(drawPanel);
    }

    @Override
    public void algorithm() {
        panel.repaint();
    }
    public Line drawlines(String choice) {
        Line line = new LineConcrete();
        ChainHandler chainHandler1 = new ChainHandlerTriangle();
        ChainHandler chainHandler2 = new ChainHandlerDiamond();
        ChainHandler chainHandler3 = new ChainHandlerArrow();
        chainHandler1.setSuccessor(chainHandler2);
        chainHandler2.setSuccessor(chainHandler3);
        Line decoratedLine = chainHandler1.handler(line ,choice);
        return decoratedLine;
    }
}
