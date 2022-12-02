package src;

import java.util.*;

public class SingletonDataSrc extends Observable{
    private static SingletonDataSrc instance;
    static Map<String, int[]> boxes;
    static LinkedList<int[]> relation;
    static LinkedList<int[]> triangles;
    static LinkedList<int[]> diamonds;
    static LinkedList<int[]> arrows;
    static LinkedList<String> classList;
    static final int HEIGHT = 15;
    static final int WIDTH = 30;
    static String status;
    private SingletonDataSrc(){
       
    }
    public static SingletonDataSrc getInstance(){
        if(instance == null){
            instance = new SingletonDataSrc();
            boxes = new HashMap<>();
            relation = new LinkedList<>();
            // x1 = -1;
            // x2 = -1;
            // y1 = -1;
            // y2 = -1;
            status = "Welcome!";
        }
        return instance;
    }


    public static boolean inBoxVicinity(int x, int y){
        if(boxes.size()>0)
            for(String key : boxes.keySet()){
                int[] coord = boxes.get(key);
                float ox = coord[0];
                float oy = coord[1];
                if((x <=  ox + WIDTH && x >= ox - WIDTH) && (y <=  oy + HEIGHT && y >= oy - HEIGHT)){
                    return true;
                }
            }
        return false;
    }

    public static void setClassName(String id, int x, int y){
        boxes.put(id, new int[]{x,y});
        instance.notifying();
    }

    public static void insertClass(String className)
    {

    }
    public static void addLine(int x1, int y1, int x2, int y2) {
        relation.add(new int[]{x1,y1,x2,y2});
    }
    public static void addDiamonds(int x, int y) {
        if(diamonds == null)
            diamonds = new LinkedList<>();
        diamonds.add(new int[]{x,y});
        instance.notifying();
    }
    public static void addArrows(int x, int y) {
        if(arrows == null)
            arrows = new LinkedList<>();
        arrows.add(new int[]{x,y});
        instance.notifying();
    }
    public static void addTriangles(int x, int y) {
        if(triangles == null)
            triangles = new LinkedList<>();
        triangles.add(new int[]{x,y});
        instance.notifying();
    }
    public static void addClassList(String str) {
        if(classList == null)
            classList = new LinkedList<>();
        classList.add(str);
        instance.notifying();
    }

}
