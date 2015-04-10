// FileReverse.java
// elbharri
// lab2
// cmps12b

import java.util.Scanner;
import java.io.*;

class FileReverse{

   public static void main(String [] args) throws IOException{
      Scanner in = null; 
      PrintWriter out = null; 
      String line = null; 
      String[] token = null; 
      int i, n, lineNumber = 0; 
 
      if(args.length < 2){ 
         System.out.println("Usage: FileIO infile outfile"); 
         System.exit(1); 
      } 
 
      in = new Scanner(new File(args[0])); 
      out = new PrintWriter(new FileWriter(args[1])); 
 
      in.useDelimiter("\n"); 
      while( in.hasNext() ){ 
         lineNumber++; 
         line = in.next() + " ";  
         token = line.split("\\s+");
         n = token.length;
         for(i = 0; i<n; i++){
           out.println(stringReverse(token[i], token[i].length()));
         }
         out.println();
      }
      in.close();
      out.close();
   }

   public static String stringReverse(String s, int n){
      String a = " ";
          if(n > 0) {
           a = s.substring(n-1, n) + stringReverse(s, n-1);
             return a;
          }else{
           return a; 
          }
   }
}
