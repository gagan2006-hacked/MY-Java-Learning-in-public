package com.OSIMP.NONPREMP;


import java.util.Random;

public class Process extends PCB implements Job {
   private PCB block;
    private Job jobToDo;
    private int bt;

    public int getBt() {
        return bt;
    }

    public Process(){
        super();
        bt=new Random().nextInt(1,100);
    }

    public Process(Job job){
        super();
        jobToDo=job;
        bt= new Random().nextInt(1,100);
    }
    public Process(Process p){
        jobToDo=p;
        bt= new Random().nextInt(1,100);
    }

    @Override
    public boolean run(){
        this.setProcessState("RUNNING");
        if (jobToDo==null){
            return false;
        }
        if (jobToDo.run()){
            this.setProcessState("TERMINATED");
            return true;
        }
       return false;
    }
    @Override
    public String toString(){
        StringBuffer b=new StringBuffer();
        b.append("[ ").append("pid:").append(this.getPid()).append(",");
        b.append("Process State:").append(this.getProcessState()).append(",");
        b.append("Priority:").append(this.getPriority()).append(" ]");
        return b.toString();
    }
    public int getPriority(){
        return super.getPriority();
    }
    public void setPriority(int priority) {
        super.setPriority(priority);
    }
}

