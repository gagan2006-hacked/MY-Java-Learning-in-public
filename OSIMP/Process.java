package com.OSIMP;

public class Process extends PCB implements Job {
   private PCB block;
    private Job jobToDo;

    public Process(){
        super();
    }

    public Process(Job job){
        super();
        jobToDo=job;
    }
    public Process(Process p){
        jobToDo=p;
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
    public void setPriority(int priority) {
        super.setPriority(priority);
    }
}

