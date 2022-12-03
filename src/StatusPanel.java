package src;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

/**
 * This StatusPanel class extends the JPanel and implements the Observer.
 * It has abstract methods update and paintComponent.
 */
public class StatusPanel extends JPanel implements Observer{

    StatusPanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());
        JLabel label = new JLabel(" Status Bar: ");
        label.setHorizontalAlignment(SwingConstants.LEFT);
        Font font = new Font("Dialog", Font.BOLD,12);
        label.setFont(font);
        add(label);
        setBackground(Color.white);
    }

    /**
     * The Update method will be notified via Observable whenever there is
     * change in the dataset and then repaint.
     *
     */
    @Override
    public void update() {
        repaint();
    }

    /**
     * @param graphic the <code>Graphics</code> object to protect for drawing the component
     * It will set the component and draw the component
     */
    @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        graphic.setColor(Color.black);
        graphic.drawString(SingletonDataSrc.getInstance().status, 75 , 14);
    }

    /**
     * @return It will return the panel
     */
    public Component getPanel() {
        return this;
    }
}
