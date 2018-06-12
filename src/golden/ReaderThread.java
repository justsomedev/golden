package golden;

import java.util.Random;

/**
 * ReaderThread class to read strings from queue
 * @author samer
 */
public class ReaderThread implements Runnable {

    private Context ctx;
    private static int MIN_SLEEP_TIME = 500;
    private static int MAX_SLEEP_TIME = 2000;

    public ReaderThread(Context ctx) {
        this.ctx = ctx;
    }

    public void run() {
        try {
            read();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Generate random integer between 500 and 2000
     * @return integer
     */
    public int randomSleepAmount() {
        Random random = new Random();
        int result = random.nextInt(MAX_SLEEP_TIME - MIN_SLEEP_TIME) + MIN_SLEEP_TIME;
        return result;
    }
    
    /**
     * Read string from the queue 
     * format {Thread-name: string}
     * @throws InterruptedException 
     */
    public void read() throws InterruptedException {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + ctx.remove());
                Thread.sleep(randomSleepAmount());
            } catch (Exception e) {
            }
        }

    }
}
