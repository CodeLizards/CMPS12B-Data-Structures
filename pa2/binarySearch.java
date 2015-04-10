//binary search test


public class binarySearch {
   
   public static void main(String[] args){
   String[] X = {"cat", "eat"," people"};   
   System.out.print(binarySearch( X, 0, 2,"eat"));
   }

 public static int binarySearch(String[] A, int p, int r, String target){
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
}
