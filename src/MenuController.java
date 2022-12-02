package src;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuController extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        if( ((JMenuItem) e.getSource()).getText().equals("Save") ){
            saveFile( (Main) e.getSource());
        }
        else if( ((JMenuItem) e.getSource()).getText().equals("Load") ){
            loadFile( (Main) e.getSource());
        }
        else if( ((JMenuItem) e.getSource()).getText().equals("New") ){
            SingletonDataSrc.getInstance().erase();
        }
        
    }

    public static void saveFile(Main main){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(main) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        }
        // save to file
    }
    public static void loadFile(Main main){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(main) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        }
        // save to file
    }
}
