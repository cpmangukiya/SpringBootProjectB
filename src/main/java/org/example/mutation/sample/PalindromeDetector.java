package org.example.mutation.sample;

public class PalindromeDetector {

    public static boolean isPalindromeRecursiveWay(String input) {

        if(input == null || input.length() == 0) {
            return true;
        }
        if(input.length() == 1) {
            return true;
        }

        int length = input.length();
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(length-1);
        String subString = input.substring(1,length-1);

        return (firstChar == lastChar) && isPalindromeRecursiveWay(subString);
    }
}
