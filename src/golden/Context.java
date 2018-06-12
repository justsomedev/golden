
package golden;

/**
 * Context class to implement Strategy pattern
 * @author samer
 */
public class Context {

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
