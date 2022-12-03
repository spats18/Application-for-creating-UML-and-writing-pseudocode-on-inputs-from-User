package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JOptionPane;

public class SingletonDataSrc extends Observable{
    private static SingletonDataSrc instance;
    public static final String folder="/Users/spats/Documents/GitHub/Final-Project-564/";
    Map<String, int[]> boxes;// array size 2
    LinkedList<int[]> relation;// array size 4
    LinkedList<int[]> triangles;// array size 5
    LinkedList<int[]> diamonds;// array size 5
    LinkedList<int[]> arrows;// array size 5
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
            instance.boxes = new HashMap<>();
            instance.relation = new LinkedList<>();
            instance.triangles = new LinkedList<>();
            instance.diamonds = new LinkedList<>();
            instance.arrows = new LinkedList<>();
            instance.classList = new HashMap<>();
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
        if(instance.boxes == null)
            instance.boxes = new HashMap<>();
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
        String Name = JOptionPane.showInputDialog("Enter File Name");
        PrintWriter out = new PrintWriter(Name+".txt");
        WriteObjectToFile(out);
    }
    private static void WriteObjectToFile(PrintWriter out){
        out.println("boxes");
        if(instance.boxes!=null){
            out.println(instance.boxes.size());
            for(String key : instance.boxes.keySet()){
                out.println(key);
                for(int num : instance.boxes.get(key))
                    out.println(num);
            }
        }
        else 
            out.println(0);

        out.println("relation");
        if(instance.relation!=null){
            out.println(instance.relation.size());
            for(int[] arr : instance.relation){
                for(int num : arr)
                    out.println(num);
            }
        }
        else 
            out.println(0);

        out.println("triangles");
        if(instance.triangles!=null){
            out.println(instance.triangles.size());
            for(int[] arr : instance.triangles){
                for(int num : arr)
                    out.println(num);
            }
        }
        else 
            out.println(0);

        out.println("diamonds");
        if(instance.diamonds!=null){
            out.println(instance.diamonds.size());
            for(int[] arr : instance.diamonds){
                for(int num : arr)
                    out.println(num);
            }
        }
        else 
            out.println(0);

        out.println("arrows");
        if(instance.arrows!=null){
            out.println(instance.arrows.size());
            for(int[] arr : instance.arrows){
                for(int num : arr)
                    out.println(num);
            }
        }
        else 
            out.println(0);

        out.println("classList");
        if(instance.classList!=null){
            out.println(instance.classList.size());
            for(String key : instance.classList.keySet()){
                out.println(key);
                out.println(instance.classList.get(key).size());
                for(String num : instance.classList.get(key))
                    out.println(num);
            }
        }
        else 
            out.println(0);

        out.close();
        System.out.println("The file was successfully saved to a file");
    }
    public static void load(String fileName) throws FileNotFoundException{
        ReadObjectFromFile(folder + fileName);
        instance.notifying();
    }
    public static void ReadObjectFromFile(String filepath) throws FileNotFoundException {

        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        int size = Integer.valueOf(scanner.nextLine());
        if(size!=0){
            //inner size = 2
            instance.boxes = new HashMap<>();
            while(size>0){
                instance.boxes.put(scanner.nextLine(),new int[]{Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine())});
                size--;
            }
        }

        scanner.nextLine();
        size = Integer.valueOf(scanner.nextLine());
        if(size!=0){
            //inner size = 4
            instance.relation = new LinkedList<>();
            while(size>0){
                int[] arr = new int[4];
                for(int i =0; i<4;i++){
                    arr[i] = Integer.valueOf(scanner.nextLine());
                }
                instance.relation.add(arr);
                size--;
            }
        }

        scanner.nextLine();
        size = Integer.valueOf(scanner.nextLine());
        if(size!=0){
            //inner size = 5
            instance.triangles = new LinkedList<>();
            while(size>0){
                int[] arr = new int[5];
                for(int i =0; i<5;i++){
                    arr[i] = Integer.valueOf(scanner.nextLine());
                }
                instance.triangles.add(arr);
                size--;
            }
        }

        scanner.nextLine();
        size = Integer.valueOf(scanner.nextLine());
        if(size!=0){
            //inner size = 5
            instance.diamonds = new LinkedList<>();
            while(size>0){
                int[] arr = new int[5];
                for(int i =0; i<5;i++){
                    arr[i] = Integer.valueOf(scanner.nextLine());
                }
                instance.diamonds.add(arr);
                size--;
            }
        }

        scanner.nextLine();
        size = Integer.valueOf(scanner.nextLine());
        if(size!=0){
            //inner size = 5
            instance.arrows = new LinkedList<>();
            while(size>0){
                int[] arr = new int[5];
                for(int i =0; i<5;i++){
                    arr[i] = Integer.valueOf(scanner.nextLine());
                }
                instance.arrows.add(arr);
                size--;
            }
        }
        
        scanner.nextLine();
        size = Integer.valueOf(scanner.nextLine());
        if(size!=0){
            //inner size = variable
            instance.classList = new HashMap<>(size);
            while(size>0){
                String key = scanner.nextLine();
                instance.classList.put(key, new ArrayList<>());
                int listSize = Integer.valueOf(scanner.nextLine());
                while(listSize>0){
                    instance.classList.get(key).add(scanner.nextLine());
                    listSize--;
                }
                size--;
            }
        }
        scanner.close();
}
}
