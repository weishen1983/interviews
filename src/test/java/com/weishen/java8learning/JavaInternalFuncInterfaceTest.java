package com.weishen.java8learning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Java 8 four core functional interface

1. Consumer<T>
    void accept(T t);

2. Supplier<T>
    T get();

3. Function<T, R>
    R apply(T t);

4. Predicate<T>
    boolean test(T t)

 */
public class JavaInternalFuncInterfaceTest {

    //Consumer<T>
    @Test
    public void testConsumer(){
        purchase(10000, money -> System.out.println("Purchase a laptop with money:" + money));
    }

    public void purchase(double money, Consumer<Double> con){
        con.accept(money);
    }

    //Supplier<T>
    @Test
    public void testSupplier(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        System.out.println(numList.toString());
    }

    //Create n integers, and put it into collection
    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            numList.add(n);
        }
        return numList;
    }

    //Function<T, R>
    @Test
    public void testFunction(){
        String result = operateString("  abcdef ", s -> s.trim());
        System.out.println(result);

        result = operateString("  abcdef ", s -> s.trim().substring(2, 5));
        System.out.println(result);
    }

    public String operateString(String source, Function<String, String> function) {
        return function.apply(source);
    }

    //Predicate<T>
    @Test
    public void testPredicate(){
        List<String> srcList = Arrays.asList("abc", "abcde", "abcdef", "abcdefg", "ab");
        List<String> resultList = filterStrList(srcList, s -> s.length() > 3);
        System.out.println(resultList.toString());
    }

    //Filter string list
    public List<String> filterStrList(List<String> srcList, Predicate<String> predicate){
        List<String> resultList = new ArrayList<>();
        for(String srcStr : srcList) {
            if(predicate.test(srcStr)) {
                resultList.add(srcStr);
            }
        }
        return resultList;
    }
}
