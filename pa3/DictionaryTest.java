//DictionaryTest.java

public class DictionaryTest{

   public static void main(String[] args){
      String v;
      Dictionary Test = new Dictionary();
      Test.insert("knock", "knock");
      Test.insert("who's", "there?");
      Test.insert("Canoe1", "is here.");
      Test.insert("Canoe2", "who?");
      Test.insert("Canoe help me", "with my homework");
      System.out.println(Test);

      v = Test.lookup("who's");
      System.out.println("key = who's " + (v == null? "not found":("value = " + v)));
      v = Test.lookup("hello");
      System.out.println("key = hello " + (v == null? "not found":("value = " + v)));
  
      Test.delete("Canoe1");
      Test.delete("Canoe2");
      System.out.println(Test);

      System.out.println(Test.isEmpty());
      System.out.println(Test.size());
      Test.makeEmpty();
      System.out.println(Test.isEmpty());
      System.out.println(Test);

  }     
}

//Testing output
//knock knock
//who's there?
//Canoe1 is here.
//Canoe2 who?
//Canoe help me with my homework

//key = who's value = there?
//key = hello not found
//knock knock
//who's there?
//Canoe help me with my homework

//false
//3
//true
