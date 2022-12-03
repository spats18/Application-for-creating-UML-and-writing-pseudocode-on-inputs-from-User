package src;

import javax.swing.JOptionPane;

/**
 * This StrategyLine class extends the abstract class Strategy.
 * It has abstract methods algorithm and getChoice.
 *
 */
public class StrategyLine extends Strategy{
    Line line;
    String[] options ={"Inheritance", "Composition", "Association" };

    /**
     * @param x1 is length parameter of box
     * @param y1 is length parameter of box
     * @param x2 is height parameter of box
     * @param y2 is height parameter of box
     * @param c1 string c1 is for choice one
     * @param c2 string c2 is for choice second
     *
     * This method sets the data such as height and length of box to draw
     * the line from one class to another class.
     */
    @Override
    public void algorithm(int x1, int y1, int x2, int y2, String c1, String c2) {
        if(y1 < y2){
            boxDirection = 1;
            this.xl = x1;
            this.yl = y1;
            this.xh = x2;
            this.yh = y2;
        }else{
            boxDirection = -1;
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
        this.line = this.drawLines(choice);
        SingletonDataSrc.getInstance().updateStatus(choice + " between "+c1+" and "+c2+" Added!");
        line.operation(xl, yl, xh, yh, boxDirection, c1, c2);
    }

    /**
     * @param choice choice is the choice which user wants to make the relationship between the classes.
     * It will give all the data to decoratedLine
     * @return It will return decoratedLine which will draw the required line
     */
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

    /**
     * This method would give choices for drawing lines and relationships between the classes.
     *
     */
    @Override
    public void getChoice() {
        int selection = 0;
        selection = JOptionPane.showOptionDialog(null, null," Choose Relationship", 0, 3, null, (Object[]) options, null); 
        choice = options[selection];
    }
}
