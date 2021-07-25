package org.example.problems;

import org.junit.jupiter.api.Assertions;

public class FirstLongestRepeatingCharInString {

    public static void main(String[] args) {

        Assertions.assertEquals("ccccc",findTheString("aabbcccddccccceef"));
        Assertions.assertEquals("ccccc",maxRepeatingEfficient("aabbcccddccccceef"));
    }

    private static String findTheString(String value) {

        int startIndex = 0;
        int maxLength = 1;

        int length = value.length();

        for(int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                if(value.charAt(i) == value.charAt(j)
                    && (j - i + 1) > maxLength) {
                    startIndex = i;
                    maxLength = j - i + 1;
                } else if (value.charAt(i) != value.charAt(j)) {
                    i = j-1;
                    break;
                }
            }
        }

        return value.substring(startIndex, startIndex + maxLength);
    }

    private static String maxRepeatingEfficient(String str)
    {
        int n = str.length();
        int count = 0;
        int at = 0;
        int cur_count = 1;

        // Traverse string except last character
        for (int i = 0; i < n; i++)
        {
            // If current character matches with next
            if (i < n - 1 && str.charAt(i) == str.charAt(i + 1))
                cur_count++;

                // If doesn't match, update result
                // (if required) and reset count
            else
            {
                if (cur_count > count)
                {
                    count = cur_count;
                    at = i;
                }
                cur_count = 1;
            }
        }
        return str.substring(at - count + 1, at + 1);
    }
}
