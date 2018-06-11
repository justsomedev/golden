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
public interface Queue {
    public void enqueue(String str);
    
    public String dequeue()throws InterruptedException ;
    
    public boolean isEmpty();
}
