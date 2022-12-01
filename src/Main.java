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
    JPanel root;
    JPanel topPanel;
    JPanel midPanel;
    JTextPane bottomPanel;

    /**
     * main method is the driver method to start the plotting of points.
     */
    public static void main(String args[]){
        SingletonDataSrc.getInstance();
        SingletonRadioMenu.getInstance();
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
        cp.addMouseListener(this);
        dp = new DrawPanel(); 
        dp.addMouseListener(this);
        
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

    /**
     * This is an overridden method to define what should the Main class do
     * when the button is clicked.
     * The method will call the setNumber method of RandomNumbers 
     * to generate the random number.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        // //dp.decideAlgo(x,y);
        // System.out.println(x+","+y);   

        if (e.getSource() == dp.getPanel())
        {
            System.out.println("At Draw Panel");
            dp.decideAlgo(x, y);
            

        }
        else if (e.getSource() == cp.getPanel())
        {
            System.out.println("At Code Panel");
        }
        bottomPanel.setText(SingletonDataSrc.status);
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