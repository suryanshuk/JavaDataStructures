package Threads;
import LinklisthelperAPIs.Queue_by_list;

/**
 * @author Suryanshu
 *
 * @param <T> is a generic variable
 */

public class add<T> implements Runnable {
      
    Queue_by_list<Packet> ref;
    long lambda;
    timeStamp time = new timeStamp();
    
/**constructor method of add class
 * @param passed Q1 list is passed
 * @param limit  is Q1 holding capacity
 */
public add(Queue_by_list<Packet> passed,long rate_of_packets)
{
    ref = passed;
    lambda = rate_of_packets;
}
      
      
        @Override
        public void run() {
            
            addToQ1(); 
         
        }
         
        /**method to add packets to Q1
         * 
         */
        public  void addToQ1()
        {
            while(true)
            {
            	//providing mutex lock for Q1 to wait and notify
            
                Packet packet = new Packet();
                ref.enqueue(packet);
                System.out.println("packet " + packet.getid()+ " is added to q1");
                time.getTime();
                System.out.println("THIS IS Q1 :");
                ref.display();
        
                synchronized (ref) {
                	
                	if(ref.getsize()>0)
						ref.notifyAll();
                }
                try{
                	Thread.sleep(lambda);
                }
                catch(InterruptedException e)
                {
                	e.printStackTrace();
                }
            }
        }
         
        
  
    }