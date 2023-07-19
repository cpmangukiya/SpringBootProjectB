package org.example.problems;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class FindNextNotRepeatingCharInString {
    public static void main(String[] args) {

        Assertions.assertEquals('o', findNextNonRepeating("abddbcaoeclda"));
    }

    private static Character findNextNonRepeating(String value) {
        int[] chars = new int[256];

        for(int i = 0; i < 256; i++) {
            chars[i] = -1;
        }
        Arrays.fill(chars, -1);

        for(int i=0;i<value.length();i++) {
            if(chars[value.charAt(i)]==-1) {
                chars[value.charAt(i)] = i;
            } else {
                chars[value.charAt(i)] = -2;
            }
        }

        int res = -1;

        for(int i = 0; i < 256; i++) {
            if(chars[i] >= 0 && res == -1) {
                res = chars[i];
            } else if(chars[i] > 0) {
                res = Math.min(res, chars[i]);
            }
        }

        //if(res == Integer.MAX_VALUE) {// Handle negative case
        if(res == -1) {
            // Handle negative case
        }

        return value.charAt(res);
    }
}
