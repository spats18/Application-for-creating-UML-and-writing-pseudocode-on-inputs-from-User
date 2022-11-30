package src;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;

public class CodePanel implements Observer{

    @Override
    public void update(Observable observable) {
        
    }
    JPanel panel;
    CodePanel(){
        panel = new JPanel();//new JPanel(new GridLayout(1,1,0,0));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setSize(300, 500);
        panel.add(scrollPane, BorderLayout.CENTER);
    }
    public JPanel getPanel(){
        return panel;
    }
}
