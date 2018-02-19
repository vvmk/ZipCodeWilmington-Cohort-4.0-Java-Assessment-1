package com.zipcodewilmington.assessment1.part5;

import com.zipcodewilmington.assessment1.part1.BasicStringUtils;

import java.util.ArrayList;

public class Palindrome {

    public Integer countPalindromes(String input) {
        int total = 0;
        for (String s : getAllSubstrings(input)) {
            if (s.equals(BasicStringUtils.reverse(s)))
                total++;
        }
        return total;
    }

    private String[] getAllSubstrings(String input) {
        ArrayList<String> sol = new ArrayList<>();
        for (int startIndex = 0;startIndex<input.length();startIndex++) {
            for (int endIndex = startIndex;endIndex<input.length();endIndex++) {
                sol.add(input.substring(startIndex, endIndex+1)); //String.substring() end index is non inclusive, +1
            }
        }
        System.out.println(sol.toString());
        return sol.toArray(new String[0]);
    }
}
