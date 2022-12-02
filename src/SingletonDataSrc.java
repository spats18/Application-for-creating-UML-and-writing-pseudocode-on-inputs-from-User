package src;

import java.util.*;

public class SingletonDataSrc extends Observable{
    private static SingletonDataSrc instance;
    Map<String, int[]> boxes;
    LinkedList<int[]> relation;
    LinkedList<int[]> triangles;
    LinkedList<int[]> diamonds;
    LinkedList<int[]> arrows;
    Map<String, ArrayList<String>> classList;
    static final int HEIGHT = 15;//half
    static final int WIDTH = 30;// half
    String status;
    int countAssociation;
    int countComposition;
    
    private SingletonDataSrc(){
       
    }
    public static SingletonDataSrc getInstance(){
        if(instance == null){
            instance = new SingletonDataSrc();
            instance.status = "Welcome! Click anywhere in the right panel to start creating classes.";
        }
        return instance;
    }
    public Pair inBoxVicinity(int x, int y){
        if(instance.boxes == null)
            instance.boxes = new HashMap<>();
        if(instance.boxes.size()>0)
            for(String key : instance.boxes.keySet()){
                int[] coord = instance.boxes.get(key);
                float ox = coord[0];
                float oy = coord[1];
                if((x <=  ox + WIDTH && x >= ox - WIDTH) && (y <=  oy + HEIGHT && y >= oy - HEIGHT)){
                    return new Pair(true, key);
                }
            }
        return new Pair(false, "");
    }

    public void setClassName(String id, int x, int y){
        instance.boxes.put(id, new int[]{x,y});
        instance.notifying();
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        if(instance.relation == null)
            instance.relation = new LinkedList<>();
        instance.relation.add(new int[]{x1,y1,x2,y2});
    }
    public void addDiamonds(int x, int y, int boxDirection, int slope, int yIntercept) {
        if(instance.diamonds == null)
            instance.diamonds = new LinkedList<>();
        instance.diamonds.add(new int[]{x,y,boxDirection, slope, yIntercept});
        instance.notifying();
    }
    public void addArrows(int x, int y, int boxDirection,int slope, int yIntercept) {
        if(instance.arrows == null)
            instance.arrows = new LinkedList<>();
            instance.arrows.add(new int[]{x,y,boxDirection, slope, yIntercept});
        instance.notifying();
    }
    public void addTriangles(int x, int y, int boxDirection, int slope, int yIntercept) {
        if(instance.triangles == null)
            instance.triangles = new LinkedList<>();
        instance.triangles.add(new int[]{x,y,boxDirection,slope, yIntercept});
        instance.notifying();
    }
    public void addClassList(String str, ArrayList<String> toAdd ) {
        if(instance.classList == null)
            instance.classList = new HashMap<>();
        instance.classList.put(str, toAdd);
        instance.notifying();
    }
    public void updateClassList(String str, ArrayList<String> toAdd ) {
        if(instance.classList == null)
            instance.classList = new HashMap<>();
        instance.classList.put(str, toAdd);
        instance.notifying();
    }
    public void updateStatus(String str) {
            instance.status = new String(str);
        instance.notifying();
    }
    public void erase(){
        instance.eraseRepo(); 
        instance.notifying();
    }
    private void eraseRepo() {
        instance.boxes = null;
        instance.relation = null;
        instance.triangles = null;
        instance.diamonds = null;
        instance.arrows = null;
        instance.classList = null;
    }
}
