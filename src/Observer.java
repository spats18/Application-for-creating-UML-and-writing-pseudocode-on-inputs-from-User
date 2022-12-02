package src;

/**
 * This is an Interface for implementing Observer classes.
 */
interface Observer {    

    /**
     * The Update method will be notified via Observable whenever there is 
     * change in the dataset.
     * @param observable The observable object which can be referenced to get the 
     * changed dataset.
     */
    public void update();
}
