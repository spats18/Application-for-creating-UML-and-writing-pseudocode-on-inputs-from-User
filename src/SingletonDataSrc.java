package src;

import java.util.LinkedList;
import java.util.List;

public class SingletonDataSrc {
    private static SingletonDataSrc instance;
    static LinkedList<int[]> coordinates;
    static float boxHeight = 15;
    static float boxWidth = 25;
    private SingletonDataSrc(){
       
    }
    public static SingletonDataSrc getInstance(){
        if(instance == null){
            instance = new SingletonDataSrc();
        }
        return instance;
    }

    public static boolean inBoxVicinity(float fx, float fy){
        int x = (int) Math.floor(fx);
        int y = (int) Math.floor(fy);
        for(int[] coord : coordinates){
            float ox = coord[0];
            float oy = coord[1];
            if((x <=  ox + boxWidth && x >= ox - boxWidth) && (y <=  oy + boxHeight && y >= oy - boxHeight)){
                return true;
            }
        }
        coordinates.add(new int[]{x,y});
        return false;
    }

}
