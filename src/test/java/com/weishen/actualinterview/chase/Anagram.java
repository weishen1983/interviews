package com.weishen.actualinterview.chase;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        String sortedSChars = Stream.of(s.split("") )
                .sorted()
                .collect(Collectors.joining());
        String sortedTChars = Stream.of(t.split("") )
                .sorted()
                .collect(Collectors.joining());
        return sortedSChars.equals(sortedTChars);
    }

    @Test
    public void test() {
        String s = "abc";
        String t = "cba";
        Assert.assertTrue(isAnagram(s, t));
    }

}
