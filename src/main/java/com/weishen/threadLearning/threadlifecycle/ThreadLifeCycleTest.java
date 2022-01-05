package com.weishen.threadLearning.threadlifecycle;

public class ThreadLifeCycleTest {

    public static void main(String[] args) throws InterruptedException {
        TestThread t1 = new TestThread("THREAD 1");
        TestThread t2 = new TestThread("THREAD 2");

        t1.start();
        t2.start();
        t2.setNeedsBlocked(true);
        System.out.println("t2 starts to sleeping......");

        Thread.sleep(5000);
        System.out.println("Main thread is waking up t2.........");
        t2.setNeedsBlocked(false);

    }
}
