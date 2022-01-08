package com.weishen.threadLearning;

public class ThreadByInterface implements Runnable{

    @Override
    public void run() {
        for(int i=1; i<=100; i++) {
            System.out.println("Running the sub thread ------ " + i);
        }
    }

    public static void main(String[] args) {
        ThreadByInterface thread = new ThreadByInterface();
        //new Thread(thread).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=100; i++) {
                    System.out.println("Running the sub thread ------ " + i);
                }
            }
        }).start();

        new Thread(() -> {
            for(int i=1; i<=100; i++) {
                System.out.println("Running the sub thread ------ " + i);
            }
        }).start();

        for(int i=1; i<=100; i++) {
            System.out.println("Running the main thread ------ " + i);
        }
    }
}
