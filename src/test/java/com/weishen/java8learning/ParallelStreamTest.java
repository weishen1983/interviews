package com.weishen.java8learning;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class ParallelStreamTest {

    //sum from 1 to 1000000000000
    @Test
    public void testLongSum(){
        Instant start = Instant.now();

        Long sum = LongStream.range(0, 100000000000L)
                .parallel()//fork-join framework as behind logic
                .reduce(0, Long::sum);

        Instant end  = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());
    }
}
