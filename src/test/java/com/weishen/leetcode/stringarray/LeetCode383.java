package com.weishen.leetcode.stringarray;

import java.util.*;

/**
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i=0; i<ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                if (map.get(ransomNote.charAt(i)) == 1) {
                    map.remove(ransomNote.charAt(i));
                } else {
                    map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();

        HashMap<Character, Integer> ransomNoteMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        for (int i = 0; i < ransomNoteChars.length; i++) {
            char key = ransomNoteChars[i];
            if (ransomNoteMap.containsKey(key)) {
                ransomNoteMap.put(key, ransomNoteMap.get(key) + 1);
            } else {
                ransomNoteMap.put(key, 1);
            }
        }

        for (int i = 0; i < magazineChars.length; i++) {
            char key = magazineChars[i];
            if (magazineMap.containsKey(key)) {
                magazineMap.put(key, magazineMap.get(key) + 1);
            } else {
                magazineMap.put(key, 1);
            }
        }

        for (char key : ransomNoteMap.keySet()) {
            if (!magazineMap.containsKey(key) || magazineMap.get(key).intValue() < ransomNoteMap.get(key).intValue()) {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();
        List<Character> magazineCharList = new LinkedList<>();
        for (int i = 0; i < magazineChars.length; i++) {
            magazineCharList.add(magazineChars[i]);
        }

        for (int i = 0; i < ransomNoteChars.length; i++) {
            char ransomCHar = ransomNoteChars[i];
            boolean findRansomChar = false;
            for (int j = 0; j < magazineCharList.size(); j++) {
                Character magazineChar = magazineCharList.get(j);
                if (magazineChar.charValue() == ransomCHar) {
                    findRansomChar = true;
                    magazineCharList.remove(magazineChar);
                    break;
                }
            }
            if (!findRansomChar) {
                return false;
            }
        }

        return true;
    }
}
