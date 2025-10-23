package com.OSIMP.NONPREMP;

import java.util.List;


public class ProcessScheduler {
    int priority;
    private Process process;
    public static final int FCFS=1;
    public static final int SJF=2;
    public static final int PRI=3;

    public boolean schedule(List<Process> rQ){
        if (rQ.isEmpty()){
            return false;
        }
        process=rQ.removeFirst();
        return process.run();
    }

    public void getProcessInfo(){
        System.out.println(process);
    }


    public boolean scheduleAll(List<Process> rQ){
        if (rQ.isEmpty())return false;
        return fcfs(rQ);
    }


    public boolean scheduleAll(List<Process> rQ, int scheduler){
        if (rQ.isEmpty())return false;
        if (scheduler==FCFS){
            return fcfs(rQ);
        } else if (scheduler==SJF) {
            return sjf(rQ);
        }else if (scheduler==PRI){

        }
        return false;
    }


    private boolean fcfs(List<Process> rQ) {
        boolean t=true;
        while (!rQ.isEmpty()){
            process=rQ.removeFirst();
            t=t&&process.run();
        }
        return t;
    }
    private boolean sjf(List<Process>rQ){
        boolean t=true;
        while (!rQ.isEmpty()){
            process=findSJ(rQ);
            t=t&&process.run();
            rQ.remove(process);
        }
        return t;
    }
    private Process findSJ(List<Process>rQ){
        int bt=Integer.MAX_VALUE;
        int ind=0;
        for (int i = 0; i < rQ.size(); i++) {
            if (bt>rQ.get(i).getBt()){
                ind=i;
            }
        }
        return rQ.get(ind);
    }

    private  boolean pri(List<Process>rQ){
        boolean t=true;
        while (!rQ.isEmpty()){
            process=findPRI(rQ);
            t=t&&process.run();
            rQ.remove(process);
        }
        return t;
    }

    private Process findPRI(List<Process> rQ) {
        int bt=0;
        int ind=0;
        for (int i = 0; i < rQ.size(); i++) {
            if (bt<rQ.get(i).getPriority()){
                ind=i;
            }
        }
        return rQ.get(ind);
    }


}
