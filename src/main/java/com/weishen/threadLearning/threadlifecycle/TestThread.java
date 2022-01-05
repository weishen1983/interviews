package com.weishen.threadLearning.threadlifecycle;

public class TestThread extends Thread{

    private boolean needsBlocked = false;

    public boolean isNeedsBlocked() {
        return needsBlocked;
    }

    public void setNeedsBlocked(boolean needsBlocked) {
        this.needsBlocked = needsBlocked;
    }

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for(int i=1; i<=60; i++) {
                while (needsBlocked) {
                    System.out.println(Thread.currentThread().getName() + " is sleeping......");
                    Thread.sleep(1000);
                }
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName() + " is running (" + i + " out of 60)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
