package com.weishen.java8learning;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
Method Reference:
方法引用是LAMBDA表达式的另一种表达形式
如果LAMBDA体中的内容有方法已经实现了，就可以使用方法饮用

主要有三种语法格式：
1. object::instance method name
2. Class::static method name
3. Class::instance method name

注意：
1. LAMBDA体中调用方法的参数列表与返回值类型，要与函数是借口种抽象方法的参数列表和返回类型保持一致
2. 如果LAMBDA参数列表中的第一参数是实力方法的调用者，而第二个蚕食是实力方法的参数时，可以使用Class::instance method name

Constructor Reference:
Class::new
注意：
需要调用的构造器的参数列表要与函数是借口种抽象方法的参数列表保持一致
*/
public class JavaMethodRefTest {

    //object::instance method name
    @Test
    public void test1(){
        Consumer<String> con1 = x -> System.out.println(x);
        //public void println(String x)
        //void accept(T t); T is String here
        //两个方法输入参数类型和返回参数类型一样，就可以用方法引用
        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    //object::instance method name
    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        Supplier<Integer> sup2 = emp::getAge;
        System.out.println(sup2.get());
    }

    //Class::static method name
    @Test
    public void test3(){
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        int result1 = com1.compare(1, 2);
        System.out.println(result1);

        Comparator<Integer> com2 = Integer::compare;
        int result2 = com2.compare(1, 2);
        System.out.println(result2);
    }

    //Class::instance method name
    //Compare if two string are the same
    @Test
    public void test4(){
        BiPredicate<String, String> biPredicate1 = (x, y) -> x.equals(y);
        System.out.println(biPredicate1.test("abc", "abc"));

        BiPredicate<String, String> biPredicate2 = String::equals;
        System.out.println(biPredicate2.test("abc", "abc"));
    }

    //Class::new
    @Test
    public void test5(){
        Supplier<Employee> supplier1 = () -> new Employee();
        Supplier<Employee> supplier2 = Employee::new;
    }

    //Class::new
    @Test
    public void test6(){
        BiFunction<String, Integer, Employee> biFunction1 = (name, age) -> new Employee(name, age);
        BiFunction<String, Integer, Employee> biFunction2 = Employee::new;
    }

}
