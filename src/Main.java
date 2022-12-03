package src;

import javax.swing.*;

import java.awt.*;
/**
 * The main class is the driver class. 
 * It will plot the points on the frame with decorations and mean value.
 */

class Main extends JFrame{
    static CodePanel cp;
    static DrawPanel dp;
    JPanel root;
    JPanel midPanel;
    JScrollPane scroll;
    JPanel bottomPanel;
    JMenuBar menuBar;
    static JMenu file, help;
    static JMenuItem m1, m2, m3, m4;
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
        m1 = new JMenuItem("New");
        m2 = new JMenuItem("Save");
        m3 = new JMenuItem("Load");
        m4 = new JMenuItem("Team Members");
        file = new JMenu("File");
        help = new JMenu("Help");
        file.add(m1);
        file.add(m2);
        file.add(m3);
        menuBar.add(file);
        menuBar.add(help);
        help.add(m4);
        MenuController menuControl = new MenuController();
        m1.addActionListener(menuControl);
        m2.addActionListener(menuControl);
        m3.addActionListener(menuControl);
        m4.addActionListener(menuControl);
        setJMenuBar(menuBar);

        root = new JPanel (new BorderLayout(5,5));
        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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
        SingletonDataSrc.getInstance().countAssociation = 0;
        SingletonDataSrc.getInstance().countComposition = 0;
        cp.setPreferredSize(new Dimension((int) cp.getPreferredSize().getWidth() + 1000, (int)(cp.getPreferredSize().getHeight() + 3000)));
        scroll = new JScrollPane(cp);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        midPanel.add(scroll);
        midPanel.add(dp.getPanel());

        //root.add(topPanel, BorderLayout.PAGE_START);
        root.add(midPanel, BorderLayout.CENTER);
        root.add(bottomPanel, BorderLayout.PAGE_END);
        add(root);
        setVisible(true);
    }
}