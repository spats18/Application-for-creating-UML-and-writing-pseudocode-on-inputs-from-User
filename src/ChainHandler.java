package src;

/**
 * This ChainHandler class is Abstract class
 * It has setSuccessor and handler abstract methods.
 */
public abstract class ChainHandler {
    protected ChainHandler successor;

    public void setSuccessor(ChainHandler successor){
        this.successor = successor;
    }
    public abstract Line handler(Line line, String choice);
}
