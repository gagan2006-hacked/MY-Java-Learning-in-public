package com.OSIMP.NONPREMP;

import java.util.ArrayList;
import java.util.List;

public class OS {
    public static int min=1;
    public static int max=10;
    public static int med=5;
   private static volatile OS instance;
   private static  volatile List<Process> readyQ=new ArrayList<>();
   private static ProcessScheduler scheduler;

   private OS(){
       scheduler=new ProcessScheduler();
   }


   public static synchronized OS getInstance(){
       if (instance==null){
           instance=new OS();
       }
       return instance;
   }


   private synchronized void run(){
       if (scheduler.schedule(readyQ)){
       }else {
           throw new RuntimeException("Process is not executed");
       }
   }


   private synchronized void runAll(){
       if (scheduler.scheduleAll(readyQ)){
           return;
       }
       throw new RuntimeException(" a Process is not executed ");
   }

   private synchronized void runAll(int sch){
       if (scheduler.scheduleAll(readyQ,sch)){
           return;
       }
       throw new RuntimeException(" a Process is not executed ");
   }

   public synchronized  void start(){
       if (!readyQ.isEmpty()) {
           run();
       }
   }

   public synchronized void startAll(){
       if (!readyQ.isEmpty()) {
           runAll();
       }
   }


    public synchronized void startAll(int sch){
        if (!readyQ.isEmpty()) {
            runAll(sch);
        }
    }



   public void getProcessInfo(){
       scheduler.getProcessInfo();
   }


   public synchronized void addProcess(Process process){
       if (process!=null){
           readyQ.add(process);
           return;
       }
       throw new RuntimeException("Process is Illegal or valid ");
   }


   public synchronized void addProcess(Job job){
       if (job==null){
           throw new RuntimeException("Process is Illegal or valid ");
       }
       addProcess(new Process(job));
   }


}
