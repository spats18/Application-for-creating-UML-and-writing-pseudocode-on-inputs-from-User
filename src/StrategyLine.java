package src;

import javax.swing.JOptionPane;

public class StrategyLine extends Strategy{
    Line line;
    String[] options ={"Inheritance", "Composition", "Association" };

    @Override
    public void algorithm(int x1, int y1, int x2, int y2) {
        super.algorithm(x1, y1 ,x2, y2);
        
        int selection = JOptionPane.showOptionDialog(null, null," Choose Relationship", 0, 3, null, (Object[]) options, (Object) options[2]); 
        choice = options[selection];

        String s = "Relationship " + choice + " Added!";

        SingletonDataSrc.status = s;
        SingletonDataSrc.addLine(x1, y1, x2, y2);
        this.line = this.drawLines(choice);
        line.operation(x1, y1, x2, y2);
    }
    public Line drawLines(String choice) {
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
