package Threads;
import java.text.SimpleDateFormat;
import java.util.Date;

import LinklisthelperAPI.*;


 
public class add<T> implements Runnable {
      
    Queue_by_list<Packet> ref;
public add(Queue_by_list<Packet> passed)
{
    ref = passed;
}
      
      
        @Override
        public void run() {
             
            for(int i=0;i<100;i++)
            {
                try{
                Packet packet = new Packet();
                System.out.println("packet" +packet.getId()+" is created");
                
                Thread.sleep(1000);
                ref.enqueue(packet);
                
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                
                
                System.out.println("packet" +packet.getId()+" is added at" +sdf.format(d));
               
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
             
             
              
        }
          
        
  
    }