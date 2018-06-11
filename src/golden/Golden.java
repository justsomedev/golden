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
            
            Thread rt = new Thread(new ReaderThread(ctx));
            rt.start();
            
            Thread rt1 = new Thread(new ReaderThread(ctx));
            rt1.start();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
