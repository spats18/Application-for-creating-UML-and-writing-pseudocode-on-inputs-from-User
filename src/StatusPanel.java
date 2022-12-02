package src;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

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
    @Override
    public void update() {
        repaint();
    }
    @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        graphic.setColor(Color.black);
        graphic.drawString(SingletonDataSrc.getInstance().status, 75 , 14);
    }
    public Component getPanel() {
        return this;
    }
}
