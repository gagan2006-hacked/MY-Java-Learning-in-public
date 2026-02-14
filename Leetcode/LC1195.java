package com.Leetcode;

import java.util.function.IntConsumer;

public class LC1195 {
    public static void main(String[] args) throws InterruptedException {
        int n = 15; // you can change this value to test
        FizzBuzz fb = new FizzBuzz(n);

        Thread t1 = new Thread(() -> {
            try {
                fb.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread t2 = new Thread(() -> {
            try {
                fb.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread t3 = new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread t4 = new Thread(() -> {
            try {
                fb.number((x) -> System.out.print(x + " "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("\nAll threads finished execution!");
    }
}
class FizzBuzz {
    private int n;
    public FizzBuzz(int n) {
        this.n = n;
    }
    int point=1;
    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (point<=n) {
            while (point <= n&&!(point % 3 == 0 && point % 5 != 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            if (point>n)break;
            printFizz.run();
            point++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (point<=n) {
            while (point <= n&&!(point % 3 != 0 && point % 5 == 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }            if (point>n)break;

            printBuzz.run();
            point++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (point<=n){
            while (point <= n&&!(point%3==0&&point%5==0)){
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }            if (point>n)break;

            printFizzBuzz.run();point++;notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
       while (point<=n) {
            while (point <= n&&!(point % 3 != 0 && point % 5 != 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
           if (point>n)break;
           printNumber.accept(point);
           point++;notifyAll();
        }
    }
}
