package com.weishen.threadLearning;

public class RabbitTurtleRace implements Runnable{

    private String winner;

    @Override
    public void run() {

        for(int i=1; i<=100; i++) {
            String name = Thread.currentThread().getName();
            if(null != this.winner) {
                break;
            }

            if(name.equals("rabbit")) {
                i++;
            }
            if(name.equals("rabbit") && i % 50 == 0) {
                try {
                    System.out.println("rabbit starts sleeping.........zzzzzzzzz.........");
                    Thread.sleep(1000);
                    if(null != this.winner) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " runs " + i + " Steps");

            if(i>=100) {
                this.winner = name;
                System.out.println("Winner is " + name);
                break;
            }
        }

    }
}
