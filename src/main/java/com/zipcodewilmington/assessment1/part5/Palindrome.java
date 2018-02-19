package com.zipcodewilmington.assessment1.part5;

import com.zipcodewilmington.assessment1.part1.BasicStringUtils;

public class Palindrome {

    public Integer countPalindromes(String input) {
        int total = 0;
        for (int startIndex = 0; startIndex < input.length(); startIndex++) {
            for (int endIndex = startIndex; endIndex < input.length(); endIndex++) {
                String s = input.substring(startIndex, endIndex + 1);
                if (s.equals(BasicStringUtils.reverse(s)))
                    total += 1;
            }
        }
        return total;
    }
}

