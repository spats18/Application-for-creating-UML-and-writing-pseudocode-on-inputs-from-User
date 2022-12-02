package src;

import javax.swing.JOptionPane;

public class StrategyLine extends Strategy{
    Line line;
    String[] options ={"Inheritance", "Composition", "Association" };

    @Override
    public void algorithm(int x1, int y1, int x2, int y2) {
        if(y1 < y2){
            boxDirection = 1;
            this.xl = x1;
            this.yl = y1;
            this.xh = x2;
            this.yh = y2;
        }else{
            boxDirection = 0;
            this.xl = x2;
            this.yl = y2;
            this.xh = x1;
            this.yh = y1;
        }
        if(xl < xh){
            this.xl += SingletonDataSrc.WIDTH;
            this.yl += SingletonDataSrc.HEIGHT;
            this.xh -= SingletonDataSrc.WIDTH;
            this.yh -= SingletonDataSrc.HEIGHT;
        }else{
            this.xl -= SingletonDataSrc.WIDTH;
            this.yl += SingletonDataSrc.HEIGHT;
            this.xh += SingletonDataSrc.WIDTH;
            this.yh -= SingletonDataSrc.HEIGHT;
        }
        this.getChoice();
        String s = "Relationship " + choice + " Added!";
        SingletonDataSrc.status = s;
        SingletonDataSrc.addLine(xl, yl, xh, yh);
        this.line = this.drawLines(choice);
        line.operation(xl, yl, xh, yh);
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
    @Override
    public void getChoice() {
        int selection = JOptionPane.showOptionDialog(null, null," Choose Relationship", 0, 3, null, (Object[]) options, (Object) options[2]); 
        choice = options[selection];
    }
}
