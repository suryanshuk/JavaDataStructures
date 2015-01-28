package Threads;

import LinklisthelperAPIs.Queue_by_list;

/** thread class for server processing
 * @author Suryanshu
 *
 * @param <T> is a generic variable;
 */
public class serevr<T> implements Runnable{

	Queue_by_list<Packet> Q2 ; 
	long mu;
	
	/** constructor method 
	 * @param list Q2 list is initialized
	 */
	public serevr(Queue_by_list<Packet> list ,long rate_of_server_)
	{
		Q2= list;
		mu = rate_of_server_;
	}
	
	@Override
	public void run() {
		
		
		removeFromQ2();
		
	}
	

	/**removes packets from Q2
	 * 
	 */
	public void removeFromQ2()
	{
		while(true)
		{
			try{
				//CHECKS IF Q2 IS EMPTY OR NOT
				if(Q2.getsize()!=0)
				{
					Q2.dequeue();
				System.out.println("server is taking packet out of Q2");
				Thread.sleep(mu);
				}
				
				else{
					System.out.println("server is waiting for packets to arrive");
					Thread.sleep(mu);
				}
				
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}


}
