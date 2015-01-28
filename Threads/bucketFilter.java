package Threads;
import LinklisthelperAPIs.Queue_by_list;

/**
 * @author Suryanshu
 *
 * @param <T> is a generic variable
 */
public class bucketFilter<T> implements Runnable {
 
    Queue_by_list<Token> ref;
    int limit;
    int size;
    long rate;
    /**
     * @param list Another queue to store tokens
     * @param depth is bucket capacity
     */
    public bucketFilter(Queue_by_list<Token> list, int depth , long rate_of_token_arrival)
    {
        ref = list;
        limit= depth;
        rate = rate_of_token_arrival;
    }
     
     
    @Override
    public void run() {
         
        addToBucket();
    }
     
     
     
     
    /**method to add token to bucket
     * 
     */
    public void addToBucket()
    {
        while(true)
        {
        	//take token into bucket when it is not full
            if(ref.getsize()!=limit)
            {
        Token token = new Token();
        ref.enqueue(token);
        System.out.println("token is dropped into bucket");
        }
             
            else
            {
                System.out.println("token is discarded");
            }
        try{
            Thread.sleep(rate);
        }
        catch(InterruptedException e){ e.printStackTrace();}
    }
         
    }
     
    /**method remove token from bucket
     * @return token from the bucket
     */
    public Token removeFromBucket()
    {
        return ref.dequeue();
    }
     
    /** gives size of bucket at current point of time
     * @return size of bucket
     */
    public  int getsizeOfBucket()
    {
        return ref.getsize();
    }
     
     
 
}