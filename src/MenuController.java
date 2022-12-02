package src;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuController extends AbstractAction{

    static final String[] TEAM = new String[]{"Sannidhya", "Karan", "Aashka", "Sarthak", "Thy", "Darshan"};
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
            File folder = new File(SingletonDataSrc.folder);
            List<String> files = new ArrayList<>();
            for(File file: folder.listFiles()){
                String name= file.getName();

                if(name.contains(".dat"))
                    files.add(name);
            }
            String[] listOfFiles = new String[files.size()]; 
            int i =0;
            for(String file: files){
                listOfFiles[i++] = file;
            }
            int selection = JOptionPane.showOptionDialog(null, null," Choose a file", 0, 3, null, (Object[]) listOfFiles, null); 
            String file = listOfFiles[selection];
            System.out.print(file);
            SingletonDataSrc.load(file);
        }
        else if( ((JMenuItem) e.getSource()).getText().equals("New") ){
            SingletonDataSrc.erase();
        }
        else{
            JOptionPane.showMessageDialog(null, TEAM, "Team", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
