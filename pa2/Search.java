//Search.java
//elbharri
//pa2
//cmps012b

import java.io.*;
import java.util.Scanner;

public class Search{
   public static void main(String [] args) throws IOException {
      int i, output;
      //Check for enough input from user and prints out message if they don't give a file and target
      Scanner in = null;
      if(args.length < 2){
         System.out.println("Usage: FileIO infile target [target2...]");
         System.exit(1);
      } 
      //Scans the file from the user and counts the lines in it
      in = new Scanner(new File(args[0]));
      int lineCount = 0;
      while( in.hasNextLine () ){
         in.nextLine();
         lineCount++;
      }
      in.close();

      //Creates String array the same size as the number of files counted; Creates int array to keep track of line nummbers;
      //Fills the arrays with the contents of the file   
      String[] S = new String[lineCount];
      int[] lineNumber = new int[lineCount];
      Scanner get = new Scanner(new File(args[0]));          
      for(i = 0; i < S.length; i++){
         S[i] = get.nextLine();
         lineNumber[i] = i+1;    
         }
      //Passes the arrays into mergeSort to lexigraphically alphibatalize them and track the changes with the lineNumber array
      //passes Arrays into binarySearch with a for loop to check for all targets put into the command line.
      //Prints statement if found or not; if found uses lineNumber array with the output of binarySearch to see where found. 
      mergeSort(S, lineNumber, 0, lineCount-1); 
      for (i = 1; i < args.length; i++){
         output = binarySearch(S, 0, lineCount-1, args[i]);
         if (output == -1){
            System.out.println(args[i] + " not found. ");
         }else{
            System.out.println(args[i] + " found at line " +lineNumber[output] + "."); 
         }   
         
      } 
   }
   public static void mergeSort(String[] A, int[] lineNumber, int p, int r){
      int q;
      if(p < r) {
         q = (p+r)/2;
         mergeSort(A,lineNumber, p, q);
         mergeSort(A,lineNumber, q+1, r);
         merge(A,lineNumber, p, q, r);
      }
   }

   public static void merge(String [] A, int[] lineNumber, int p, int q, int r){
      int n1 = q-p+1;
      int n2 = r-q;
      String[] L = new String[n1];
      int [] LL = new int[n1];
      String[] R = new String[n2];
      int [] RL = new int[n2];
      int i, j, k;

      for(i=0; i<n1; i++){
          L[i] = A[p+i];
          LL[i] = lineNumber[p+i];
      }
      for(j=0; j<n2; j++){
          R[j] = A[q+j+1];
          RL[j] = lineNumber[q+j+1];
      }
      i = 0; j = 0;
      for(k=p; k<=r; k++){
         if( i<n1 && j<n2 ){
            if( L[i].compareTo(R[j]) < 0){
               A[k] = L[i];
               lineNumber[k] = LL[i];
               i++;
            }else{
               A[k] = R[j];
               lineNumber[k] = RL[j];
               j++;
            }
         }else if( i < n1 ){
            A[k] = L[i];
            lineNumber[k] = LL[i];
            i++;
         }else{
            A[k] = R[j]; 
            lineNumber[k] = RL[j];
            j++;
         }
      }   
   }
   

   static int binarySearch(String[] A, int p, int r, String target){
      int q;
      if(p > r) {
         return -1;
      }else{
         q = (p+r)/2;
         if(target.compareTo(A[q]) == 0){
            return q;
         }else if(target.compareTo(A[q]) < 0){
            return binarySearch(A, p, q-1, target);
         }else{
            return binarySearch(A, q+1, r, target);
         }
      }
   }
//Simple print functions to check if Arrays have the correct contents
   static void printStringArray(String[] A){
      for(int i = 0; i < A.length; i++){
         System.out.print(A[i] + " ");
      }
   }
   static void printIntArray(int[] A){
      for(int i = 0; i < A.length; i++){
         System.out.print(A[i] + " ");
         }
   }

}
   
