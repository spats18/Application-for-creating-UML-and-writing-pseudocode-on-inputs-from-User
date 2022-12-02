package src;

import javax.swing.JOptionPane;

public class StrategyLine extends Strategy{
    Line line;

    String[] options ={"Inheritance", "Composition", "Association" };

    @Override
    public void algorithm(int x1, int y1, int x2, int y2) {

        //SingletonRadioMenu.showMenu();
        int selection = JOptionPane.showOptionDialog(null, null," Choose Relationship", 0, 3, null, (Object[]) options, (Object) options[0]); 
        choice = options[selection];
        String s = "Class " + choice + " Added!";
        this.choice = null;//will add radio here.
        SingletonDataSrc.addLine(x1, y1, x2, y2);
        this.line = this.drawLines(choice, x1, y1, x2, y2);
        SingletonDataSrc.status = s;
    }
    public Line drawLines(String choice, int x1, int y1, int x2, int y2) {
        Line line = new LineConcrete(x1, y1, x2, y2);
        ChainHandler chainHandler1 = new ChainHandlerTriangle();
        ChainHandler chainHandler2 = new ChainHandlerDiamond();
        ChainHandler chainHandler3 = new ChainHandlerArrow();
        chainHandler1.setSuccessor(chainHandler2);
        chainHandler2.setSuccessor(chainHandler3);
        Line decoratedLine = chainHandler1.handler(line ,choice);
        return decoratedLine;
    }
}
