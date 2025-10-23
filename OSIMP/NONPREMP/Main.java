package com.OSIMP.NONPREMP;

public class Main {
    public static void main(String[] args) {
        OS os=OS.getInstance();
        os.addProcess(()->{
            System.out.println("hi");
            return true;
        });
        OS os1=OS.getInstance();
        os1.addProcess(()->{
            System.out.println("Hello");
            return true;
        });
        os.startAll(ProcessScheduler.SJF);
    }
}
