package com.weishen.threadLearning.synctest;

public class ThreadSyncTest1 {

    //Test1:
    //KFC Store has 10 chickens
    //Consumer Wei tries to consume 10 chickens
    //Consumer Christina tries to consume 5 chickens
    public static void main1(String[] args) {
        KFCStore kfcStore = new KFCStore();
        for(int i=1; i<=10; i++){
            kfcStore.cookingWithOutSync(new Chicken(i));
        }

        Consumer wei = new Consumer(10, kfcStore);
        Consumer christina = new Consumer(5, kfcStore);

        new Thread(wei, "wei").start();
        new Thread(christina, "christina").start();
    }

    //Test2:
    //Producer A starts to cook 50 chicken
    //Consumer A starts to consume 55 chickens
    public static void main(String[] args) throws InterruptedException {
        KFCStore kfcStore = new KFCStore();

        Producer producer = new Producer(50, kfcStore);
        new Thread(producer, "producer A").start();

        Thread.sleep(1000);

        Consumer consumer = new Consumer(55, kfcStore);
        new Thread(consumer, "consumer A").start();

    }

}
