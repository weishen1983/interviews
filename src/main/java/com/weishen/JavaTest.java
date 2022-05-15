package com.weishen;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JavaTest {

    public static final int FIVE_SECONDS = 10000;
    public static final int MAX_Y = 500;
    public static final int MAX_X = 500;

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        String s = "AAAAACCCCC";
        System.out.println(s.substring(0,10));
    }

//    public static void main(String... args) throws Exception {
//        Robot robot = new Robot();
//        Random random = new Random();
//        while (true) {
//            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
//            Thread.sleep(FIVE_SECONDS);
//        }
//    }

}
