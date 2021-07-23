package org.example.problems;

import org.junit.jupiter.api.Assertions;

public class FindNextNotRepeatingCharInString {
    public static void main(String[] args) {

        Assertions.assertEquals('o', findNextNonRepeating("abddbcaoeclda"));
    }

    private static Character findNextNonRepeating(String value) {
        int[] chars = new int[256];

        for(int i = 0; i < 256; i++) {
            chars[i] = -1;
        }

        for(int i=0;i<value.length();i++) {
            if(chars[value.charAt(i)]==-1) {
                chars[value.charAt(i)] = i;
            } else {
                chars[value.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < 256; i++) {
            if(chars[i] > 0) {
                res = Math.min(res, chars[i]);
            }
        }

        if(res == Integer.MAX_VALUE) {// Handle negative case
        }

        return value.charAt(res);
    }
}
