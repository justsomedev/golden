/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golden;

import java.util.*;


/**
 *
 * @author samer
 */
public class ArrayQueue implements Queue {

    private List array;
    private int front;
    private int back;
    private int count;

    public ArrayQueue() {
        this.array = Collections.synchronizedList(new ArrayList<String>());
        this.count = 0;
        this.front = 0;
        this.back = -1;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void enqueue(String x) {
        
            this.array.add(x);
            this.back = back + 1;
            this.count++;
            
        
    }

    public String dequeue() throws InterruptedException {
       
            String x = (String) this.array.get(this.front);
            this.array.remove(this.front);
            this.front = (front + 1);
            this.count--;
            return x;
        
    }

}
