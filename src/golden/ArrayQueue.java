package golden;

import java.util.List;
import java.util.ArrayList;


/**
 * FIFO based Queue wrapper for Array List, Thread safe
 * @author samer
 */
public class ArrayQueue implements Queue {
    
    /**
     * Array list to hold strings
     */
    private List array;
    
    /**
     * Counter for items in array
     */
    private int count;
    
    public ArrayQueue() {
        this.array = new ArrayList<String>();
        this.count = 0;
    }
    
    /**
     * Check if the queue is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    /**
     * Add item to the queue, Thread Safe by using synchronized block
     * @param  str 
     */
    public  void enqueue(String str) {
        synchronized(array){
            this.array.add(str);
            this.count++;
            array.notifyAll();
        }
    }
    
    /**
     * Remove item from the queue, Thread Safe by using synchronized block
     * @return String
     * @throws InterruptedException 
     */
    public  String dequeue() throws InterruptedException {
            while(isEmpty()){
                wait();
            }
            String str;
            synchronized (array) {
                 str= (String) this.array.get(0);
                this.array.remove(0);
                this.count--;
            }
            return str;

    }

}
