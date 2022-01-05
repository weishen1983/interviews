package com.weishen.threadLearning;

public class RabbitTurtleRaceTest{

    public static void main(String[] args) {
        RabbitTurtleRace rabbitTurtleRace = new RabbitTurtleRace();

        new Thread(rabbitTurtleRace, "rabbit").start();
        new Thread(rabbitTurtleRace, "turtle").start();
    }
}
