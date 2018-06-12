
package golden;


/**
 *
 * @author samer
 */
public class Golden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Queue queue = QueueFactory.make("fifo");
            Context ctx = new Context();
            ctx.setQueue(queue);
            
            Thread wt = new Thread(new WriterThread(ctx));
            wt.start();
            
            Thread t1 = new Thread(new ReaderThread(ctx));
            t1.setName("t1");
            t1.start();
            
            Thread t2 = new Thread(new ReaderThread(ctx));
            t2.setName("t2");
            t2.start();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
