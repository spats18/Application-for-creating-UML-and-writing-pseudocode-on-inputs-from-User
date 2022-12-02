package src;

import java.util.*;

public class SingletonDataSrc extends Observable{
    private static SingletonDataSrc instance;
    static Map<String, int[]> boxes;
    static LinkedList<int[]> relation;
    static LinkedList<int[]> triangles;
    static LinkedList<int[]> diamonds;
    static LinkedList<int[]> arrows;
    static Map<String, ArrayList<String>> classList;
    static final int HEIGHT = 15;//half
    static final int WIDTH = 30;// half
    static String status;
    static int countAssociation;
    static int countComposition;
    
    private SingletonDataSrc(){
       
    }
    public static SingletonDataSrc getInstance(){
        if(instance == null){
            instance = new SingletonDataSrc();
            boxes = new HashMap<>();
            relation = new LinkedList<>();
            status = "Welcome! Click anywhere in the right panel to start creating classes.";
        }
        return instance;
    }
    public static Pair inBoxVicinity(int x, int y){
        if(boxes.size()>0)
            for(String key : boxes.keySet()){
                int[] coord = boxes.get(key);
                float ox = coord[0];
                float oy = coord[1];
                if((x <=  ox + WIDTH && x >= ox - WIDTH) && (y <=  oy + HEIGHT && y >= oy - HEIGHT)){
                    return new Pair(true, key);
                }
            }
        return new Pair(false, "");
    }

    public static void setClassName(String id, int x, int y){
        boxes.put(id, new int[]{x,y});
        instance.notifying();
    }

    public static void addLine(int x1, int y1, int x2, int y2) {
        relation.add(new int[]{x1,y1,x2,y2});
    }
    public static void addDiamonds(int x, int y, int boxDirection) {
        if(diamonds == null)
            diamonds = new LinkedList<>();
        diamonds.add(new int[]{x,y,boxDirection});
        instance.notifying();
    }
    public static void addArrows(int x, int y, int boxDirection) {
        if(arrows == null)
            arrows = new LinkedList<>();
        arrows.add(new int[]{x,y,boxDirection});
        instance.notifying();
    }
    public static void addTriangles(int x, int y, int boxDirection) {
        if(triangles == null)
            triangles = new LinkedList<>();
        triangles.add(new int[]{x,y,boxDirection});
        instance.notifying();
    }
    public static void addClassList(String str, ArrayList<String> toAdd ) {
        if(classList == null)
            classList = new HashMap<>();
        classList.put(str, toAdd);
        instance.notifying();
    }
    public static void updateClassList(String str, ArrayList<String> toAdd ) {
        if(classList == null)
            classList = new HashMap<>();
        classList.put(str, toAdd);
        instance.notifying();
    }
    public static void updateStatus(String str) {
        status = new String(str);
        instance.notifying();
    }
}
