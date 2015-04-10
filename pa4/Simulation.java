//Simulation.java
//elbharri
//pa4
//cmps012b

import java.io.*;
import java.util.Scanner;

public class Simulation{

   public static Job getJob(Scanner in){
      String[] s = in.nextLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int d = Integer.parseInt(s[1]);
      return new Job(a, d);
   }

   public static void main(String[] args) throws IOException{
      int n, i,j, time = 0;
      Scanner in = null;
      PrintWriter trc = new PrintWriter(new FileWriter(args[0] + ".trc"));
      PrintWriter rpt = new PrintWriter(new FileWriter(args[0] + ".rpt"));
      Queue Backup = new Queue();
      Queue Storage = new Queue();
      Queue Extra = new Queue();
      //check commandline args

      if(args.length < 1){
         System.out.println("Usage: Simulation input_file ");
         System.exit(1);
      }

      in = new Scanner(new File(args[0]));
      int m = Integer.parseInt(in.nextLine().trim());
      for(i=0; i< m; i++){
         Job J = (getJob(in));
         Backup.enqueue(J);
         Extra.enqueue(J);
         Storage.enqueue(J);
      }
      in.close();
      System.out.println(Backup);
      System.out.println(Storage);
      
 
      trc.println("Trace file: " + args[0] + ".trc");
      trc.println(m + " Jobs: ");
      trc.println(Storage);
      trc.println();

      rpt.println("Report file: " +args[0] + ".rpt");
      rpt.println(m + " Jobs: ");
      rpt.println(Storage);
      rpt.println();
      rpt.println("**********************************************************");

      for(n = 1; n < m; n++){
         trc.println("*****************************");
         trc.println(n + " processors: ");
         trc.println("*****************************");
         int wait = 0;
         int[] waitTimes = new int[m];
         boolean done = false;

        
         Queue[] Processor = new Queue[n+1];
         Queue Next = new Queue();
         for(i = 0; i < n+1; i++){
            Processor[i] = new Queue();
         }   
           Processor[0] = Extra; 
       // System.out.println(Processor[0]);


         trc.println("time= " +time);
         trc.println("0: "+Storage);
         for(i = 1; i < n+1; i++)
            trc.println((i) + ": "+ Processor[i]);
         trc.println();
         while( Storage.length() < m && Storage.length() > 0){
            for(i = 0; i < n; i++){
               if(((Job)Processor[i].peek()).getFinish() == -1){
                  for(i = 1; i < n+1; i++){
                     if(!Processor[i].isEmpty() && (((Job)Processor[i].peek()).getFinish() == -1)){
         	         ((Job)(Processor[i].peek())).computeFinishTime(time);
                     } 
                  }  
            if(done){
               trc.println("time= "+time);
               trc.println("0: " +Storage+Next);
               for(i = 1; i < n+1; i++)
                  trc.println(i+": "+Processor[i]);
               trc.println();
               done = false;
            }  
            time++;
            for(i = 1; i < n+1; i++){
            	if(!Processor[i].isEmpty()){
            	   if(((Job)Processor[i].peek()).getFinish() == time){
            	      waitTimes[wait++] = ((Job)(Processor[i].peek())).getWaitTime();
           	      Next.enqueue(((Job)(Processor[i].dequeue())));
                      done =true;
            	   }
            	}
            }

            while(!Storage.isEmpty() && ((Job)Storage.peek()).getArrival() == time){
               int min = 1000;
               int minIndex = 0;
               for(i = 0; i < n; i++){
                  if(Processor[i].length() < min){
                  	min = Processor[i].length();
                  	minIndex = i;
                  }
               }
               Processor[minIndex].enqueue(Storage.dequeue());
               done  = true;
            }
              
         }
             
      }
   }
 
 
      trc.println("time = "+time);
      trc.println("0: "+Storage+Next);
      for(i=1; i< n+1; i++)
         trc.println((i)+": "+Processor[i]);

      double maxWait = 0;
      double totalWait = 0;
      double averageWait = 0;
      for(i = 0; i < waitTimes.length; i++){
         totalWait += waitTimes[i];
         if(waitTimes[i] > maxWait){
            maxWait = waitTimes[i];
         }
      }
      averageWait = totalWait/waitTimes.length;
      if (n == 1){
         rpt.printf("1 processor: totalWait=%.0f, maxWait=%.0f, averageWait=%.2f\n",
                      totalWait, maxWait, averageWait);
        }else rpt.printf("%d processors: totalWait=%.0f, maxWait=%.0f, averageWait=%.2f\n", n, totalWait, maxWait, averageWait);
     
         
        
        for(i = 1; i < m+1; i++){
           Backup.enqueue(((Job)(Backup.peek())));
           ((Job)(Backup.peek())).resetFinishTime();
           Storage.enqueue(((Job)(Backup.dequeue())));
        }
        Next.dequeueAll();   

     }

     trc.close();
     rpt.close();
   }
 }



