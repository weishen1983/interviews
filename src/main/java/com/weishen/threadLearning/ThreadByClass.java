package com.weishen.threadLearning;

public class ThreadByClass extends Thread{

    @Override
    public void run(){
        for(int i=1; i<=100; i++) {
            System.out.println("Running the sub thread ------ " + i);
        }
    }

    public static void main(String[] args) {
        ThreadByClass thread = new ThreadByClass();
        thread.start();

        for(int i=1; i<=100; i++) {
            System.out.println("Running the main thread ------ " + i);
        }
    }
}
