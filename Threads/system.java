package Threads;
import LinklisthelperAPI.*;

public class system {
  
    /**
     * @param args
     */
    public static void main(String[] args) {
          
       Queue_by_list<Packet> queue= new Queue_by_list<>();
            Packet p = new Packet();
         queue.enqueue(p);
       
        Runnable run = new add<>(queue);
      Runnable runner = new remove<>(queue);
          
        
        Thread t1 = new Thread(run);
       Thread t2 = new Thread(runner);
          
        t1.setName("forArrival");
          
        t2.setName("forDeparture");
          
        t2.start();
        t1.start();
    }
  
}