package src;

/**
 *  This Pair class connects the two classes with the required relationship.
 */
public class Pair{
    boolean inVicinity;
    String className;
    Pair(boolean inVicinity, String className){
        this.inVicinity = inVicinity;
        this.className = className;
    }
}
