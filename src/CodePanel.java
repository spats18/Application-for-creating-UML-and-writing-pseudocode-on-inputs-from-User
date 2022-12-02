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
        if(SingletonDataSrc.classList == null)
            return;
        int lineCnt = 15;
        for(String key : SingletonDataSrc.classList.keySet()){
            for(String str: SingletonDataSrc.classList.get(key)){
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
        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
    }
    public JPanel getPanel(){
        return this;
    }
}
