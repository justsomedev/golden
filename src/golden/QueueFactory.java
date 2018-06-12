package golden;

/**
 * Factory method class to build queues based on FIFO or LIFO 
 * @author samer
 */
public class QueueFactory {
    
    /**
     * Factory method to create Queue object
     * @param type
     * @return Queue
     * @throws Exception 
     */
    public static Queue make(String type) throws Exception {
        if (type == "fifo") {
            return new ArrayQueue();
        } else if (type == "filo" || type == "lifo") {
            return new ArrayStack();
        } else {
            throw new Exception("Type not supported, allowd value fifo, filo or lifo");
        }
    }
}
