package com.Leetcode;

public class LC1115 {
    public static void main(String[] args) {
        FooBar b=new FooBar(2);
        Thread t=new Thread(()->{
            try {
                b.foo(()-> System.out.print("Foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread=new Thread(()->{
                try {
                    b.bar(()-> System.out.print("Boo"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });
        t.start();thread.start();
    }

}
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    boolean foo=false;
    boolean boo=false;
    public synchronized void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (foo) {
                    try {
                        wait();
                    } catch (InterruptedException e) {

                    }
                }
                printFoo.run();
                foo=true;
                boo=false;
                notify();
            }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (!foo) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            printBar.run();
            boo=true;
            foo=false;
            notify();

        }
    }
}
