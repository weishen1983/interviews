package com.weishen.threadLearning.synctest;

public class Producer implements Runnable{

    private int maxCookingChicken;

    private KFCStore kfcStoreToCook;

    public Producer(int maxCookingChicken, KFCStore kfcStoreToCook) {
        this.maxCookingChicken = maxCookingChicken;
        this.kfcStoreToCook = kfcStoreToCook;
    }

    @Override
    public void run() {
        for(int i=0; i<maxCookingChicken; i++) {
            try {
                kfcStoreToCook.cooking(new Chicken(i+1));
                if(i==maxCookingChicken-1){
                    kfcStoreToCook.setSoldOut(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
