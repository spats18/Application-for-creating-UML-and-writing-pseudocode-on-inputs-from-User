package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

/**
 * The main class is the driver class. 
 * It will plot the points on the frame with decorations and mean value.
 * 
 */
class Main extends JFrame implements MouseListener{
    // static RandomNumbers rndNum;
    // static PlotPanel[] panels = new PlotPanel[3];
    
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
        JPanel right = new JPanel(new GridLayout(1,2,10,0));
        right.setBorder(BorderFactory.createLineBorder(Color.black));
        add(right);

        CodePanel dp2 = new CodePanel();
        right.add(dp2.getPanel());
        DrawPanel dp = new DrawPanel();
        right.add(dp.getPanel());
    }

    /**
     * This is an overridden method to define what should the Main class do
     * when the button is clicked.
     * The method will call the setNumber method of RandomNumbers 
     * to generate the random number.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //rndNum.setNumber();
		repaint();
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