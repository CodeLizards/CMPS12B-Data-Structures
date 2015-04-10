//QueueTest.java

public class QueueTest{
   public static void main(String[] args){
   String v;
   Queue A = new Queue();
   A.enqueue("I");
   A.enqueue("for");
   A.enqueue("1");
   A.enqueue("hope");
   A.enqueue("this works!");
   System.out.println(A);
    
    v =(String)A.peek();
    System.out.println(v==null? "not found": v + "\n");
    
    v = (String)A.dequeue();
    v = (String)A.dequeue();
    v = (String)A.dequeue();
    System.out.println(A);
   
   System.out.println(A.isEmpty());
   System.out.println(A.length());
   A.dequeueAll();
   System.out.println(A.isEmpty());
   System.out.println(A);

   }
}
