package src;

/**
 * This is an Interface for implementing Observer classes.
 */
interface Observer {    

    /**
     * The Update method will be notified via Observable whenever there is 
     * change in the dataset.
     *
     */
    public void update();
}
