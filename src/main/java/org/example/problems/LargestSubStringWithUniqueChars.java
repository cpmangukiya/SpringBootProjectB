package org.example.problems;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class LargestSubStringWithUniqueChars {

    public static void main(String[] args) {

        // aaabcbdeafpbdephcbdeafpjbb Output : hcbdeafpj
        Assertions.assertEquals("hcbdeafpj",findUniqueString("aaabcbdeafpbdephcbdeafpjbb"));
    }

    private static String findUniqueString(String value) {

        int maxLength = 0;
        int maxStartIndex = 0;

        int candidateLength = 0;
        int candidateStartIndex = 0;

        int stringLength = value.length();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(value.charAt(0), 0);
        for(int i = 1; i < stringLength; i++) {
            if(!hashMap.containsKey(value.charAt(i))) {
                hashMap.put(value.charAt(i), i);
            } else {
                if(hashMap.get(value.charAt(i)) >= candidateStartIndex) {
                    candidateLength = i - candidateStartIndex;
                    if(maxLength < candidateLength) {
                        maxLength = candidateLength;
                        maxStartIndex = candidateStartIndex;
                    }
                    candidateStartIndex = hashMap.get(value.charAt(i))+1;
                }
                hashMap.replace(value.charAt(i), i);
            }
        }

        if(maxLength < stringLength-candidateStartIndex) {
            maxLength = stringLength-candidateStartIndex;
            maxStartIndex = candidateStartIndex;
        }

        return value.substring(maxStartIndex, maxStartIndex + maxLength);
    }
}
