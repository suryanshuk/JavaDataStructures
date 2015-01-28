package Threads;


import LinklisthelperAPIs.Queue_by_list;

/** packet class
 * @author Suryanshu
 *
 */
public class Packet {
  
      
    private static int id=0;
    int size = 5;
     public int getSize() {
        return size;
    }
 
    Queue_by_list<Token> q;
    
    
    /** packet itself is a queue to store the tokens ("THIS IS OPTIONAL")
     * 
     */
    public Packet()
    {
        q = new Queue_by_list<Token>();
        q.setLimit(5);
        this.id = id+1;
       
    }
    /** GIVES THE ID OF THE PACKET
     * @return id of the packet
     */
    public synchronized int getid()
    {
        return this.id;
    }
     
    /**storing tokens into packet
     * @param data is the token passed
     */
    public void intoPacket(Token data)
    {
        q.enqueue(data);
    }
     
    /**gives the limit of the packet
     * @return limit of the packet
     */
    public int getLimit()
    {
        return q.getLimit();
    }
}