package com.weishen.threadLearning.synctest;

public class Consumer implements Runnable{

    private int consumeNumberOfChicken;

    private KFCStore kfcStoreToConsume;

    public Consumer(int consumeNumberOfChicken, KFCStore kfcStoreToConsume) {
        this.consumeNumberOfChicken = consumeNumberOfChicken;
        this.kfcStoreToConsume = kfcStoreToConsume;
    }

    @Override
    public void run() {
        for (int i = 0; i < consumeNumberOfChicken; i++) {
            try {
                if(kfcStoreToConsume.isSoldOut() && kfcStoreToConsume.getChickens().isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " leaves since the chicken is sold out......");
                    return;
                }
                Chicken chicken = kfcStoreToConsume.consume();
                System.out.println(Thread.currentThread().getName() + " consumes chicken " + chicken.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
