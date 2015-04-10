//Queue.java
   public class Queue implements QueueInterface{
      private class Node{
      	Object item; 
      	Node next;

      	Node(Object x){
      		item = x;
      		next = null; 
      	}
      }

      private Node head, tail; 
      private int numItems;

      public Queue(){
        head = null;
      	tail = null;
      	numItems = 0;
      }

   public boolean isEmpty(){
      return(numItems == 0);
   }

   public int length(){
      return numItems;	
   }
  
   public void enqueue(Object newItem){
      Node N = new Node(newItem);
         if(isEmpty())
            head = N;
         else
            tail.next = N;
         tail = N; 
         numItems++;
   }

   public Object dequeue() throws QueueEmptyException{
      Object x = peek();
      head = head.next;
      if(isEmpty()) 
         tail = null;
      numItems--;
      return x;  
   }

   public Object peek() throws QueueEmptyException{
      if(numItems == 0){
         throw new QueueEmptyException("cannot peek non-existen objects");
      }
      return head.item;
   }
  

   public void dequeueAll() throws QueueEmptyException{
      head = null;
      numItems = 0;
   }

   public String toString(){
      String S = "";
      Node N = head;
      while(N != null ){
         S+= N.item + " ";
         N = N.next;
      } 
         return S;
   }


}
