package src;

public abstract class ChainHandler {
    protected ChainHandler successor;

    public void setSuccessor(ChainHandler successor){
        this.successor = successor;
    }
    public abstract Line handler(Line line, String choice);
}
