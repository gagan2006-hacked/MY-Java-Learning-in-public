package com.Leetcode;

import java.util.function.IntConsumer;

public class LC1116 {
    private int n;
    private int number = 1;

    public LC1116(int n) {
        this.n = n;
    }

    private boolean printZero = true;  // zero starts first
    private boolean printOdd = false;
    private boolean printEve = false;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!printZero) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            printNumber.accept(0);

            // Decide who prints next: odd or even
            if ((number & 1) == 1) { // odd number next
                printOdd = true;
            } else { // even number next
                printEve = true;
            }
            printZero = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (number <= n) {
            while (!printEve) {
                wait();
                if (number > n) return; // safeguard exit
            }
            printNumber.accept(number);
            number++;
            printEve = false;
            printZero = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (number <= n) {
            while (!printOdd) {
                wait();
                if (number > n) return; // safeguard exit
            }
            printNumber.accept(number);
            number++;
            printOdd = false;
            printZero = true;
            notifyAll();
        }
    }


}

