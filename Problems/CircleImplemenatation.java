package Problems;
import LinklisthelperAPI.*;
public class CircleImplemenatation {

	/**
	 * @param N the size of the circle
	 * @param M is the size of the pointer to be interated
	 * @return
	 */
	public int CircleWinner(int N,int M){
		
		Queue_by_list<Integer> queue=new Queue_by_list<Integer>();
		
		//create or populate the queue
		for(int i=0;i<N;i++){
			queue.enqueue(i);
		}
		
		int count=1; //why
		

		while(queue.getsize()!=1)
		{
			//System.out.println(queue.getsize());
			
			
			// programatically if u can improve;
			if(count==M)
			{
				queue.dequeue();
				count=1;
			}
			
			else
				
			{
				queue.enqueue(queue.dequeue().intValue());
				count++;
			}
			
		}
		
	
		
		
		
		return queue.dequeue().intValue();
	}
}
