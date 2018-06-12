
package golden;

/**
 * Queue interface
 * @author samer
 */
public interface Queue {
    public void enqueue(String str);
    
    public String dequeue()throws InterruptedException ;
    
    public boolean isEmpty();
}
