package src;

import java.util.*;

/**
 * The Observable is an abstract class. 
 * It will be observed by the Observer.
 * It will notify all its observers whenever there's a change in dataset. 
 */
abstract class Observable {
    List<Observer> observers = new ArrayList<>();

    /**
     * This method will add the Observer to the list.
     * @param observer the Observer object to be added.
     */
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    /**
     * This method will remove the Observer from the list.
     * @param observer the Observer object to be removed.
     */
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    /**
     * This method will notify all its Observers about the change in the dataset.
     */
    public void notifying(){
        for( Observer ob : observers)
            ob.update();
    }
}
