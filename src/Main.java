package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * The main class is the driver class. 
 * It will plot the points on the frame with decorations and mean value.
 * 
 */
class Main extends JFrame implements MouseListener{
    static CodePanel cp;
    static DrawPanel dp;
    Strategy strategy;
    JPanel root;
    JPanel topPanel;
    JPanel midPanel;
    JTextPane bottomPanel;
    int x1, y1, x2, y2;
    boolean firstClick = true;
    boolean drawBox = true;
    String[] relationClasses;
    /**
     * main method is the driver method to start the plotting of points.
     */
    public static void main(String args[]){
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(1000,800);
		main.setVisible(true);
    }

    /**
     * This is the constructor for the Main class.
     * It will listen when the button is clicked.
     * and will plot the points on the frame with decorations and mean value.
     */
    public Main(){
        super("CSE564 Final Project");
        root = new JPanel (new BorderLayout(10,10));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        topPanel = new JPanel(new FlowLayout());        
        Button fileButton = new Button ("File");
        Button helpButton = new Button ("Help");
        topPanel.add(fileButton);
        topPanel.add(helpButton);

        midPanel = new JPanel(new GridLayout(1,2,10,0));

        cp = new CodePanel();
        //cp.addMouseListener(this);
        dp = new DrawPanel(); 
        dp.addMouseListener(this);

        SingletonDataSrc.getInstance().addObserver(dp);
        SingletonDataSrc.getInstance().addObserver(cp);
        SingletonDataSrc.countAssociation = 0;
        SingletonDataSrc.countComposition = 0;
        midPanel.add(cp.getPanel()); //component 0
        midPanel.add(dp.getPanel()); //component 1
        
        bottomPanel = new JTextPane();
        bottomPanel.setText(SingletonDataSrc.status);
        
        root.add(topPanel, BorderLayout.PAGE_START);
        root.add(midPanel, BorderLayout.CENTER);
        root.add(bottomPanel, BorderLayout.PAGE_END);
        add(root);
        setVisible(true);
    }
    public void decideAlgo(int x1, int y1, int x2, int y2, String c1, String c2){
        
        if(drawBox){
            strategy = new StrategyBox();
            strategy.algorithm(x1, y1, x2,y2, c1, c2);
        }else{
            strategy = new StrategyLine();
            strategy.algorithm(x1, y1, x2, y2,c1,c2);
            SingletonDataSrc.status = "New Line Added!";
        }
    }
    /**
     * This is an overridden method to define what should the Main class do
     * when the button is clicked.
     * The method will call the setNumber method of RandomNumbers 
     * to generate the random number.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Pair vicinityPair = SingletonDataSrc.inBoxVicinity(e.getX(), e.getY());
        
        if(firstClick){
            x1 = e.getX();
            y1 = e.getY();
            x2 = -1;
            y2 = -1;
        }
        else{
            x2 = e.getX();
            y2 = e.getY();
        }

        if(firstClick && !vicinityPair.inVicinity){
            drawBox = true;
            this.decideAlgo(x1, y1, x2, y2, null, null);
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
        bottomPanel.setText(SingletonDataSrc.status);
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