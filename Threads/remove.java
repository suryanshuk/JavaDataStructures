package Threads;
import LinklisthelperAPIs.Queue_by_list;

/**class to process all the removal processes
 * @author Suryanshu
 *
 * @param <T> is a generic variable
 */
public class remove<T> implements Runnable{
  
     Queue_by_list<Packet> refToq1;
     Queue_by_list<Token> bucketqueue;
     Queue_by_list<Packet> refToq2;
     timeStamp time = new timeStamp();
    
     
     /**constructor method to initialize all the queues
     * @param passedList Q1 list paased by the system class
     * @param passedBucket Token bucket passed by the system class
     * @param q2list Q2 list passed by the system class
     */
    public remove(Queue_by_list<Packet> passedList , Queue_by_list<Token> passedBucket ,Queue_by_list<Packet> q2list)
     {
         refToq1 = passedList;
         bucketqueue = passedBucket;
         refToq2 = q2list;
     }
           
           
             @Override
               public void run() {
                  
                 while(true)
                 {
                	 //providing mutex lock to Q1 list 
                	 synchronized (refToq1) {
                		 if(refToq1.getsize()==0)
							try {
								refToq1.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                	 }
					
                    try{
                    	
                      Packet packet= removeFromQ1();
                      
                      //checking if the bucket has enough tokens in the bucket or not
                 if(enoughTokens(packet))
                 {
                     for(int i=0;i<packet.getLimit();i++)
                         packet.intoPacket(bucketqueue.dequeue());
                      
                     System.out.println("tokens have been added to packet");
                      
                     refToq2.enqueue(packet);
                     System.out.println("packet " +packet.getid()+" is added to Q2");
                   time.getTime();
               
                 }
                  
                 else{
                 refToq1.enqueue(packet);
                 System.out.println("packet " + packet.getid()+" is again added to q1");
                 refToq1.display();
                 }
                 
                 Thread.sleep(1500);
                 
                    }
                      
               catch(InterruptedException e)
                 {
                     e.printStackTrace();
                 } } }
                
              
              
              
              
             /**removes packet from Q1
             * @return PACKETS
             */
            public Packet removeFromQ1()
             {
                 Packet packet = refToq1.dequeue();
                 System.out.println("packet "+packet.getid()+ "is removed from q1");
                 return packet;
             }
              
              
             /**CHECKS IF BUCKET HAS ENOUGH TOKENS OR NOT
             * @param packet checking is done for a particular packet
             * @return true or false
             */
            public Boolean enoughTokens(Packet packet)
             {
                 if(bucketqueue.getsize()< packet.getLimit())
                     return false;
                  
                 else
                     return true;
                      
             }
               
             
       
         }