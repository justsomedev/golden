/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golden;

import java.util.*;

/**
 *
 * @author samer
 */
public class ArrayStack implements Queue{
    private List array;
    private int top;
    
    public ArrayStack(){
        this.array = new ArrayList<String>();
        this.top = -1;
    }
    
    public boolean isEmpty() {
        return this.top == -1;
    }
    
    public synchronized String dequeue() {
        if(isEmpty())
            throw new UnderFlowException( "Stack is Empty" );
        return (String) this.array.get(this.top--);
    }

   public void enqueue( String str ) {
        this.array.add(str);
        this.top++;
    }
}
