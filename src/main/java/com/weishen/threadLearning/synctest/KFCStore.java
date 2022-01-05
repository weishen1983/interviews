package com.weishen.threadLearning.synctest;

import java.util.LinkedList;
import java.util.Queue;

public class KFCStore {

    private final int MAX_INSTORE_CHICKEN = 20;

    private Queue<Chicken> chickens;

    private boolean isSoldOut = false;

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public Queue<Chicken> getChickens() {
        return chickens;
    }

    public KFCStore() {
        this.chickens = new LinkedList<>();
    }

    public synchronized void cooking(Chicken chicken) throws InterruptedException {
        while(chickens.size() == MAX_INSTORE_CHICKEN) {
            System.out.println("The Chicken Storage is full, waiting consumer to consume...");
            this.wait();
        }

        chickens.add(chicken);
        System.out.println("Cooking is done for chicken " + chicken.getId());

        this.notifyAll();
    }

    public synchronized Chicken consume() throws InterruptedException {
        while(chickens.size()==0){
            System.out.println("Chicken is sold out, waiting producer to cook...");
            this.wait();
        }

        Chicken chicken = chickens.remove();

        this.notifyAll();
        return chicken;
    }

    public void cookingWithOutSync(Chicken chicken){
        if(chickens.size() == MAX_INSTORE_CHICKEN) {
            System.out.println("The Chicken Storage is full, waiting consumer to consume...");
        }
        chickens.add(chicken);
        System.out.println("Cooking is done for chicken " + chicken.getId());
    }

    public Chicken consumeWithOutSync(){
        if(chickens.size()==0){
            System.out.println("Chicken is sold out, waiting producer to cook...");
            return null;
        }
        Chicken chicken = chickens.remove();
        return chicken;
    }
}
