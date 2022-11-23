package src;

import java.util.LinkedList;

public class SingletonDataSrc {
    private static SingletonDataSrc instance;
    static LinkedList<int[]> coordinates;
    static final int HEIGHT = 15;
    static final int WIDTH = 25;
    private SingletonDataSrc(){
       
    }
    public static SingletonDataSrc getInstance(){
        if(instance == null){
            instance = new SingletonDataSrc();
        }
        return instance;
    }

    public static boolean inBoxVicinity(int x, int y){
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
