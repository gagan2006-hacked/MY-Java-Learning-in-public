package com.OSIMP.NONPREMP;

public class PCB {
    private int pid=-1;
    private String processState="NEW";
    private int priority=5;
    private static int noOfProcess=0;
    public static int min=1;
    public static int max=10;
    public static int med=5;
    public PCB(){
        pid=noOfProcess+1;
        processState="READY";
        noOfProcess++;
    }

    public int getPid() {
        return pid;
    }

    public String getProcessState() {
        return processState;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }
}
