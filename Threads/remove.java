package Threads;
import LinklisthelperAPI.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class remove<T> implements Runnable{
  
     Queue_by_list<Packet> ref;
     public remove(Queue_by_list<Packet> passed)
     {
         ref = passed;
     }
           
           
             @Override
             public void run() {
                  
                while(ref.getsize()!=0)
                {
                    try
                    {
                    	Thread.sleep(1500);
                        ref.dequeue();
                        
                        
                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                        System.out.println("packet has been removed at" +sdf.format(d) );
                         
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                     
                }
                  
                  
                   
             }
               
             
       
         }