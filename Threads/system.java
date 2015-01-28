package Threads;
import LinklisthelperAPIs.Queue_by_list;

public class system {
  
    /** main method
     * @param args
     */
    public static void main(String[] args) {
          
    	
    	
        Queue_by_list<Packet> quForQ1 = new Queue_by_list<Packet>();
        Queue_by_list<Packet> quForQ2 = new Queue_by_list<Packet>();
        Queue_by_list<Token> quForBucket = new Queue_by_list<Token>();
      
        Thread t1= new Thread(new add<Packet>(quForQ1,1300));
        Thread t2 = new Thread(new remove<Packet>(quForQ1, quForBucket,quForQ2));
        Thread t3 = new Thread(new bucketFilter<Token>(quForBucket, 8,500));
        Thread T4 = new Thread(new serevr<Packet>(quForQ2,1000));
         
        t1.start();
        t2.start();
        t3.start();
        T4.start();
   
    }
  
}