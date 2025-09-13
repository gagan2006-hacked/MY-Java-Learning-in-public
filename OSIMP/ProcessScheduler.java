package com.OSIMP;

import java.util.Queue;

public class ProcessScheduler {
    int priority;
    private Process process;
    public boolean schedule(Queue<Process> rQ){
        if (rQ.isEmpty()){
            return false;
        }
        process=rQ.poll();
        return process.run();
    }
    public boolean scheduleAll(Queue<Process> rQ){
        if (rQ.isEmpty())return false;
        return fcfs(rQ);
    }

    private boolean fcfs(Queue<Process> rQ) {
        boolean t=true;
        while (!rQ.isEmpty()){
            process=rQ.poll();
            t=t&&process.run();
        }
        return t;
    }
    public void getProcessInfo(){
        System.out.println(process);
    }

}
