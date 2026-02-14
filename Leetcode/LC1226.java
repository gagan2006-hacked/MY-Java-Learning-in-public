package com.Leetcode;

import java.util.HashSet;

public class LC1226 {

}
class DiningPhilosophers {
    HashSet<Integer>set;
    public DiningPhilosophers() {
        set=new HashSet<>();
    }
    private Object lock=new Object();

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int adjLeft=(philosopher==0)? 4 :philosopher-1;
        int adjRight=(philosopher==4)? 0 :philosopher +1;
        synchronized (lock){
            while (set.contains(adjLeft)||set.contains(adjRight)){
                lock.wait();
            }
            set.add(philosopher);
            set.add(adjLeft);
            set.add(adjRight);
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
        synchronized (lock){
            set.remove(philosopher);
            set.remove(adjLeft);
            set.remove(adjRight);
            lock.notifyAll();
        }
    }
}