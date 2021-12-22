package com.weishen.java8learning;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/*
New operation "->"
Left: parameters from an abstract method
Right: way to implement the abstract method

Grammar Format 1:
no parameter and no return value for the abstract method
() -> System.out.println("Hello Lambda!");

Grammar Format 2:
one parameter and no return value for the abstract method
(s) -> System.out.println(s);
s -> System.out.println(s);

Grammar Format 3:
More than one parameter and has return value and there are multiple lines in Lambda Method
(x,y) -> {
    System.out.println("Hello testGrammar3");
    return x.compareTo(y);
};
(x,y) -> Integer.compare(x,y);

Functional Interface: one interface who should only have one abstract method


*/
public class JavaLambdaGrammarTest {

    @Test
    public void testGrammar1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("Hello Lambda!");
        r2.run();
    }

    @Test
    public void testGrammar2(){
        Consumer<String> con1 = (s) -> System.out.println(s);
        //If only one parameter, then you can use lambda without bracket
        Consumer<String> con2 = s -> System.out.println(s);
        con1.accept("Hello testGrammar2");
        con2.accept("Hello testGrammar2 without bracket");
    }

    @Test
    public void testGrammar3(){
        Comparator<Integer> c1 = (x,y) -> {
            System.out.println("Hello testGrammar3");
            return Integer.compare(x,y);
        };
        System.out.println(c1.compare(1, 2));

        //if only have one statement and has return value. then you can use lambda without bracket and return key word
        Comparator<Integer> c2 = (x,y) -> Integer.compare(x,y);
        System.out.println(c2.compare(2, 1));
    }

    //Use Lambda to convert a string to uppercase and lowercase
    @Test
    public void testLambdaFunciton1(){
        String source = "Hello Lambda";
        System.out.println(convertString(source, s -> s.toUpperCase() ));
        System.out.println(convertString(source, s -> s.toLowerCase() ));
    }

    private String convertString(String s, MyFunction mf){
        return mf.getValue(s);
    }

    //Use Lambda to get the sum and product of two number
    @Test
    public void testLambdaFunciton2(){
        calculate(10L, 20L, (num1, num2) -> num1 + num2);
        calculate(10L, 20L, (num1, num2) -> num1 * num2);
    }

    private void calculate(Long num1, Long num2, NumberCalculation<Long, Long> nc){
        System.out.println(nc.calculate(num1, num2));
    }

}
