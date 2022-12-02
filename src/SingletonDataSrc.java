package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.JOptionPane;

public class SingletonDataSrc extends Observable implements Serializable{
    private static SingletonDataSrc instance;
    public static final String folder="/Users/spats/Documents/GitHub/Final-Project-564/";
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
    //static int fileCount;
    
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
    public static void erase(){
        eraseRepo(); 
        instance.notifying();
    }
    private static void eraseRepo() {
        instance.boxes = null;
        instance.relation = null;
        instance.triangles = null;
        instance.diamonds = null;
        instance.arrows = null;
        instance.classList = null;
    }
    public static void save() throws FileNotFoundException{
        WriteObjectToFile();
    }
    private static void WriteObjectToFile() throws FileNotFoundException {
        try {
            String Name = JOptionPane.showInputDialog("Enter File Name");
            FileOutputStream fileOut = new FileOutputStream(Name+".dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(instance);
            objectOut.close();
            System.out.println("The file was successfully saved to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void load(String fileName){
        SingletonDataSrc savedInstance = ReadObjectFromFile(folder+ fileName);
        instance.boxes = savedInstance.boxes;
        instance.relation = savedInstance.relation;
        instance.triangles = savedInstance.triangles;
        instance.diamonds = savedInstance.diamonds;
        instance.arrows = savedInstance.arrows;
        instance.classList = savedInstance.classList;
        eraseRepo(); 
        System.out.println(instance.boxes);
        instance.notifying();
    }
    public static SingletonDataSrc ReadObjectFromFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            SingletonDataSrc obj = (SingletonDataSrc) objectIn.readObject();
            System.out.println("The file has been read");
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
