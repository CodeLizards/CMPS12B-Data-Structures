// Extrema.java
// elbharri
// pa1
// Finds the max and min in an array
// cs12b

public class Extrema{

   static int maxArray(int[] A, int p, int r){
      int q, a, b; 
      if(p < r) {
      q = (p+r)/2;
      a = maxArray(A, p, q);
      b = maxArray(A, q+1, r);
         if (a>b){
         return a;
         }else{
          return b;
         } 
      }else{
       return A[p];
      }
   }   

   static int minArray(int[] A, int p, int r){
      int q, a, b;
      if(p < r) {
      q =(p+r)/2;
      a = minArray(A, p, q);
      b = minArray(A, q+1, r);
         if(a<b){
         return a;
         }else{
         return b;
         }
      }else{
      return A[p];
      }
   }

   public static void main(String[] args){
      int[] B = {-1, 2, 6, 3, 9, 2, -3, -2, 11, 5, 7};
      System.out.println( "max = " + maxArray(B, 0, B.length-1) );
      System.out.println( "min = " + minArray(B, 0, B.length-1) );
   }

}
