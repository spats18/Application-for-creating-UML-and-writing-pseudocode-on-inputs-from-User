package src;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;

public class CodePanel implements Observer{

    @Override
    public void update(Observable observable) {
        
    }
    JPanel panel;
    CodePanel(){
        panel = new JPanel(new GridLayout(1,1,0,0));
        // JScrollPane scrollPane = new JScrollPane(panel); 
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // scrollPane.setBounds(50, 30, 300, 50);
    }
    public JPanel getPanel(){
        return panel;
    }
}
