package src;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;

public class CodePanel extends JPanel implements Observer{

    @Override
    public void update(){
        repaint();
    }
    @Override
    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        if(SingletonDataSrc.getInstance()== null || SingletonDataSrc.getInstance().classList == null)
            return;
        int lineCnt = 15;
        for(String key : SingletonDataSrc.getInstance().classList.keySet()){
            for(String str: SingletonDataSrc.getInstance().classList.get(key)){
                graphic.setColor(Color.black);
                graphic.drawString(str, 5 , lineCnt);
                lineCnt +=15;
            }
            graphic.drawString("", 5 , lineCnt);
        }
    }
    CodePanel(){
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.lightGray);
        setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(this);    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);

        // JScrollPane scrollPane = new JScrollPane();
        // add(scrollPane, BorderLayout.CENTER); 
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    public JPanel getPanel(){
        return this;
    }
}
