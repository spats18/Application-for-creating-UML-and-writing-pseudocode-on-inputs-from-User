package src;

import java.util.LinkedList;

public class SingletonDataSrc {
    private static SingletonDataSrc instance;
    static LinkedList<int[]> coordinates;
    static LinkedList<int[]> lineCoordinates;
    static LinkedList<String> CodePanelData;
    static final int HEIGHT = 15;
    static final int WIDTH = 25;
    static String status;
    static int x1, x2, y1, y2;
    private SingletonDataSrc(){
       
    }
    public static SingletonDataSrc getInstance(){
        if(instance == null){
            instance = new SingletonDataSrc();
            coordinates = new LinkedList<>();
            lineCoordinates = new LinkedList<>();
            x1 = -1;
            x2 = -1;
            y1 = -1;
            y2 = -1;
            status = "Welcome!";
        }
        return instance;
    }

    public static void addLine(int x, int y)
    {
        if (x1 < 0 && y1 < 0)   
        {   
            x1 = x; y1 = y;
        }

        else 
        {
            x2 = x; y2 = y;
            for(int[] line : lineCoordinates){
                float ox1 = line[0];
                float oy1 = line[1];
                float ox2 = line[2];
                float oy2 = line[3];
                if((x <=  ox1 + WIDTH && x >= ox1 - WIDTH) && (y <=  oy1 + HEIGHT && y >= oy1 - HEIGHT) && (x <=  ox2 + WIDTH && x >= ox2 - WIDTH) && (y <=  oy2 + HEIGHT && y >= oy2 - HEIGHT)){
                    return;
                }
            }
            lineCoordinates.add(new int[]{x1,y1,x2,y2}); // <------- XY pairs
            SingletonRadioMenu.showMenu();
            x1 = -1;
            x2 = -1;
            y1 = -1;
            y2 = -1;
        }

    }

    public static boolean inBoxVicinity(int x, int y){
        if(coordinates.size()>0)
            for(int[] coord : coordinates){
                float ox = coord[0];
                float oy = coord[1];
                if((x <=  ox + WIDTH && x >= ox - WIDTH) && (y <=  oy + HEIGHT && y >= oy - HEIGHT)){
                    return true;
                }
            }
        coordinates.add(new int[]{x,y});
        return false;
    }

}
