package src;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Controller implements MouseListener{
    
    int x1, y1, x2, y2;
    boolean firstClick = true;
    boolean drawBox = true;
    String[] relationClasses;
    Strategy strategy;

    public void decideAlgo(int x1, int y1, int x2, int y2, String c1, String c2){
        
        if(drawBox){
            strategy = new StrategyBox();
            strategy.algorithm(x1, y1, x2,y2, c1, c2);
        }else{
            strategy = new StrategyLine();
            strategy.algorithm(x1, y1, x2, y2,c1,c2);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Pair vicinityPair = SingletonDataSrc.inBoxVicinity(e.getX(), e.getY());

        if(firstClick && !vicinityPair.inVicinity){
            drawBox = true;
            this.decideAlgo(e.getX(), e.getY(), -1, -1, null, null);
        }
        else if(vicinityPair.inVicinity){
            if(firstClick){
                relationClasses = new String[2];
                relationClasses[0] = vicinityPair.className;
                firstClick = false;
            }
            else {
                firstClick = true;
                relationClasses[1] = vicinityPair.className;
                drawBox = false;
                int[] a = SingletonDataSrc.boxes.get(relationClasses[0]); 
                int[] b = SingletonDataSrc.boxes.get(relationClasses[1]); 
                this.decideAlgo(a[0], a[1], b[0], b[1], relationClasses[0], relationClasses[1]);
            }
        }
        else 
            firstClick = true;
        //bottomPanel.setText(SingletonDataSrc.status);
        // if (e.getSource() == dp.getPanel()){
        //     System.out.println("At Draw Panel");
        //     flag = false;
        // }
        // else if (e.getSource() == cp.getPanel()){
        //     System.out.println("At Code Panel");
        // }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
