package com.weishen.actualinterview.amazon;

import org.junit.Test;
import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example:
 * skill = [3, 4, 3, 1, 6, 5]
 * teamSize = 3
 * maxDiff = 2
 *
 * result = 2
 * [3, 3, 1], [4, 6, 5]
 */
public class CountMaxTeams {

    public int countMaximumTeams(List<Integer> skill, int teamSize, int maxDiff) {
        List<Integer> sortedList = skill.stream().sorted().collect(Collectors.toList());
        Integer[] arrays = new Integer[sortedList.size()];
        arrays = sortedList.toArray(arrays);
        int l = 0, r = teamSize - 1;
        int count = 0;
        while (r < arrays.length) {
            if (arrays[r] - arrays[l] <= 2) {
                l = l + teamSize;
                r = r + teamSize;
                count++;
            } else {
                l++;
                r++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        List<Integer> skill = Arrays.asList(3, 4, 3, 1, 6, 5);
        System.out.println(countMaximumTeams(skill, 3, 2));
    }

}
