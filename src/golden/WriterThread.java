package golden;

/**
 * WriterThread class to write strings from queue
 * @author samer
 */
public class WriterThread implements Runnable {

    static int counter = 0;
    Context ctx;
    private static int SLEEP_TIME = 1000;

    public WriterThread(Context ctx) {
        this.ctx = ctx;
    }
    
    public void run() {
        try {
            write();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static void incrementCounter() {
        //System.out.println(Thread.currentThread().getName() + ": " + counter);
        counter = counter + 1;
    }
    
    /**
     *  write()
     *  1. Increase the counter by 1.
     *  2. Create a String "item {ID}" where ID is the value of the counter.
     *  3. Print or log the event in the format "Produced: item {ID}".
     *  4. Enqueue the item
     *  5. Sleep one second.
     *
     * @throws InterruptedException 
     */
    public void write() throws InterruptedException {
        while (true) {
            try {
                incrementCounter();
                String str = "item" + counter;
                System.out.println("Produced: " + str);
                ctx.add(str);
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
