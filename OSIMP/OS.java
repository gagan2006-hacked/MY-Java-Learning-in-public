package com.OSIMP;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class OS {
    public static int min=1;
    public static int max=10;
    public static int med=5;
   private static volatile OS instance;
   private static  volatile Queue<Process> readyQ=new LinkedBlockingQueue<>();
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
   private synchronized boolean run(){
       if (scheduler.schedule(readyQ)){
           return true;
       }else {
           throw new RuntimeException("Process is not executed");
       }
   }
   private synchronized boolean runAll(){
       if (scheduler.scheduleAll(readyQ)){
           return true;
       }
       throw new RuntimeException(" a Process is not executed ");
   }
   public synchronized  void start(){
       if (!readyQ.isEmpty()) {
           Random random = new Random();
           int r = random.nextInt(0, 2);
           if (r == 0) {
               run();
           } else {
               runAll();
           }
       }
   }
   public synchronized void start(int priority){
       if (!readyQ.isEmpty()) {
           if (priority == min) {
               run();
           } else if (priority == max || priority == med) {
               runAll();
           }
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
