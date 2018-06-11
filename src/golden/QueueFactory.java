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
public class QueueFactory {
    public static Queue make(String type) throws Exception{
        if (type == "fifo"){
            return new ArrayQueue();
        }else if(type=="filo"){
            return new ArrayStack();
        }else{
            throw new Exception("Not");
        }
    }
}
