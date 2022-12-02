package src;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuController extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        if( ((JMenuItem) e.getSource()).getText().equals("Save") ){
            try {
                SingletonDataSrc.save();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        else if( ((JMenuItem) e.getSource()).getText().equals("Load") ){
            File file = loadFile();
            //SingletonDataSrc.load(file);
        }
        else if( ((JMenuItem) e.getSource()).getText().equals("New") ){
            SingletonDataSrc.erase();
        }
    }

    public static void saveFile(SingletonDataSrc instance){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        }
    }
    public static File loadFile(){
        JFileChooser fileChooser = new JFileChooser();
        File file = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }
}
