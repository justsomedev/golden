/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golden;


/**
 *
 * @author samer
 */
public class WriterThread implements Runnable {

    static int counter = 0;
    Context ctx;

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

    static synchronized void incrementCounter() {
        //System.out.println(Thread.currentThread().getName() + ": " + counter);
        counter = counter + 1;
    }

    public void write() throws InterruptedException {
        synchronized(ctx){
            try {
                incrementCounter();
                ctx.add("item" + counter);
                //System.out.println("Pro: item" + counter);
                Thread.sleep(1000);
                ctx.notifyAll();
                
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
