//Dictionary.java
//elbharri
//pa3

public class Dictionary implements DictionaryInterface {

   //private inner Node class
   private class Node {
      String key;
      String value;
      Node next;
     
      //node constructor 
      Node(String x, String y){
         key = x;
         value = y;
         next = null;

      }
   }

   private Node head, tail;
   private int numItems;
   public Dictionary(){
      head = null;
      tail = null;
      numItems = 0;
   }
   
   //isEmpty()
   //returns true if Dictionary is empty, false otherwise
   //pre: none
   public boolean isEmpty(){
      return(numItems == 0);
   }
   
   //size()
   //returns the number of entries in this Dictionary
   //pre: none
   public int size(){
      return numItems;
   }
   
   //lookup()
   //returns value associated key, or null reference if no such key exists
   //pre: none
   public String lookup(String key){
      Node N = head;
      while(N != null){
         if(key.equals(N.key))
            break;
         N = N.next;
      } 
      if(N == null){
         return null;
      }else{
         return  N.value; 
      }
   }

   //insert()
   //inserts new(key,value) pair into this Dictionary
   //pre: lookup(key)==null
   public void insert(String key, String value) throws KeyCollisionException{  
      if(lookup(key) != null)
         throw new KeyCollisionException("cannot insert duplicate key"); 
      if (numItems == 0){
          head = tail= new Node(key,value);
      }else{
      	   Node N = new Node(key, value);
           tail.next = N;
           tail = N;
      }
      numItems++; 
   }
 
   //helper function to return Node where key was found
  public Node findkey(String key){
      Node N = head;
      while(N != null){
         if(key.equals(N.key))
            break;
         N = N.next;
      }
      if(N == null){
         return null;
      }else{
         return  N;
      }
   }
   
   //delete()
   //deletes pair with the given key
   //pre: lookup(key) != null
   public void delete(String key) throws KeyNotFoundException{
      if (lookup(key) == null)
         throw new KeyNotFoundException("cannot delete non-existent keys");
      Node Found = findkey(key); 
      Node H = head;
      Node T = tail; 
         if(Found.equals(H)){
            Node A = head;
            head = head.next;
            A.next = head; 
         }else{
            while(H != null && H.next != null){
               if(Found.equals(H.next)){
                  Node C = H;
                  Node D = C.next;
                  C.next = D.next; 
                  H = C;
                }
            H = H.next;
            }
         }
         numItems--;
   }
  
   //makeEmpty()
   //pre: none        
   public void makeEmpty(){
      head = null;
      numItems = 0;
   }

   //toString()
   //returns a String representation of this Dictionary
   //overrides Object's toString() method
   //pre: none
   public String toString() {
      String S = ""; 
      Node N = head;
      while(N != null){
          S+= N.key + " " + N.value + "\n";
          N = N.next;
       }
          return S;

   }
} 
  
