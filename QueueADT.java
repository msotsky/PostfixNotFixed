// Name: Weiting Li, Lopsii Olagoke, Max Sotsky, Ayomide Adekiitan, Ayomide Adekiitan
public interface QueueADT {
    // Queue manipulation operations
    public void enqueue ( Object obj );    // Enqueue element at rear
    public Object dequeue ( );             // Dequeue element from front
    public void clear ( );                 // Remove all elements from queue
    
    // Queue status operations
    public Object peek();		  		   // get item at front without removing
    public boolean isEmpty ( );            // Is Queue empty?
    public boolean isFull ( );             // Is Queue full?
    public String toString( );             // Outputs a String representation of Q
 }
