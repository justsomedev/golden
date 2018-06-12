package golden;

import java.util.List;
import java.util.ArrayList;

/**
 * LIFO/FILO based Queue wrapper for Array List, Thread safe
 * @author samer
 */
public class ArrayStack implements Queue {
    
    /**
     * Array list to hold strings
     */
    private List array;
    
    /**
     * Maintain stack top value
     */
    private int top;

    public ArrayStack() {
        this.array = new ArrayList<String>();
        this.top = -1;
    }
    
    /**
     * Check if the queue is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return this.top == -1;
    }
    
    
    /**
     * Add item to the queue, Thread Safe by using synchronized block
     * @param str 
     */
    public void enqueue(String str) {
        synchronized (array) {
            this.array.add(str);
            this.top++;
            array.notifyAll();
        }
    }
    
    /**
     * Remove item from the queue, Thread Safe by using synchronized block
     * @return String
     * @throws InterruptedException 
     */
    public String dequeue() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        String str;
        synchronized (array) {
            str = (String) this.array.get(0);
            this.array.remove(0);
        }
        return str;

    }

}
