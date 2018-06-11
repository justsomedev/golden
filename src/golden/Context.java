/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golden;

import java.util.concurrent.Semaphore;

/**
 *
 * @author samer
 */
public class Context {

    public static Semaphore sem = new Semaphore(0);
    public static Semaphore mutex = new Semaphore(1);
    private Queue queue;

    /**
     *
     * @param type
     * @return
     */

    public void setQueue(Queue type) throws Exception {
        this.queue = type;
    }

    public void add(String str) {
        this.queue.enqueue(str);
    }

    public String remove() throws InterruptedException {
        return this.queue.dequeue();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

}
