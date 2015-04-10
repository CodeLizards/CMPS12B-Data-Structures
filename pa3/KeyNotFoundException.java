//KeyNotFoundException.java 
//elbharri
//pa3
//prints out error message when KeyNotFoundException is thrown.

public class KeyNotFoundException extends RuntimeException{
   public KeyNotFoundException(String s){
      super("cannot delete non-existent key");
   }
} 
