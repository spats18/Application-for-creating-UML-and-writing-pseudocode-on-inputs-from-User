package src;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;

public class CodePanel extends JPanel implements Observer{

    @Override
    public void update(){
        repaint();
    }
    CodePanel(){
        
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setSize(300, 500);
        add(scrollPane, BorderLayout.CENTER);
    }
    public JPanel getPanel(){
        return this;
    }
}
