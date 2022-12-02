package src;

import javax.swing.*;

import java.awt.*;
/**
 * The main class is the driver class. 
 * It will plot the points on the frame with decorations and mean value.
 * 
 */

class Main extends JFrame{
    static CodePanel cp;
    static DrawPanel dp;
    JPanel root;
    //JPanel topPanel;
    JPanel midPanel;
    JPanel bottomPanel;
    JMenuBar menuBar;
    static JMenu[] menus;
    static JMenuItem[] menuItems;
    static final String[] ITEMS = new String[] {"New", "Save", "Load"};
    static final String[] MENUS = new String[] {"File", "Help"};

    public static void main(String args[]){
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(1000,1000);
		main.setVisible(true);
    }

    public Main(){
        super("CSE564 Final Project");

        menuBar = new JMenuBar();
        menuItems = new JMenuItem[ITEMS.length];
        menus = new JMenu[MENUS.length];
        for(int i = 0; i< ITEMS.length ;i++)
            menuItems[i] = new JMenuItem(ITEMS[i]);

        for(int i = 0; i< MENUS.length ;i++)
            menus[i] = new JMenu(MENUS[i]);

        for(int i = 0; i< menuItems.length ;i++)
            menus[0].add(menuItems[i]);

        for(int i = 0; i< menus.length ;i++)
            menuBar.add(menus[i]);
        setJMenuBar(menuBar);

        root = new JPanel (new BorderLayout(5,5));
        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // topPanel = new JPanel(new FlowLayout());        
        // Button fileButton = new Button ("File");
        // Button helpButton = new Button ("Help");
        // topPanel.add(fileButton);
        // topPanel.add(helpButton);

        bottomPanel = new JPanel(new GridLayout(1,1,0,0)); 
        StatusPanel sp = new StatusPanel();
        bottomPanel.add(sp.getPanel());

        midPanel = new JPanel(new GridLayout(1,2,5,0));

        cp = new CodePanel();
        dp = new DrawPanel(); 
        Controller control = new Controller();
        dp.addMouseListener(control);

       
        SingletonDataSrc.getInstance().addObserver(dp);
        SingletonDataSrc.getInstance().addObserver(cp);
        SingletonDataSrc.getInstance().addObserver(sp);
        SingletonDataSrc.countAssociation = 0;
        SingletonDataSrc.countComposition = 0;
        midPanel.add(cp.getPanel());
        midPanel.add(dp.getPanel()); 

        //root.add(topPanel, BorderLayout.PAGE_START);
        root.add(midPanel, BorderLayout.CENTER);
        root.add(bottomPanel, BorderLayout.PAGE_END);
        add(root);
        setVisible(true);
    }
}