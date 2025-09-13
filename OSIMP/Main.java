package com.OSIMP;

public class Main {
    public static void main(String[] args) {
        OS os=OS.getInstance();
        os.addProcess(new Job() {
            @Override
            public boolean run() {
                for (int i = 0; i <100; i++) {
                    System.out.println(i);
                }
                return true;
            }

        });
        OS os1=OS.getInstance();
        os.addProcess(new Job() {
            @Override
            public boolean run() {
                for (int i = 100; i >0; i--) {
                    System.out.println(i);
                }
                return true;
            }
        });
        os.start(OS.max);
        os1.start(OS.max);
    }
}
