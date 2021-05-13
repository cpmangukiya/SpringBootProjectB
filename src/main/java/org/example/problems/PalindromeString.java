package org.example.problems;

public class PalindromeString {

    public static void main(String[] args) {

        System.out.println(isPalindrome("ABCOA"));
        System.out.println(isPalindrome("ABCBA"));
        System.out.println(isPalindrome("ABADDABA"));
        System.out.println(isPalindrome("ABAADABA"));
        System.out.println();
        System.out.println(isPalindromeRecursiveWay("ABCOA"));
        System.out.println(isPalindromeRecursiveWay("ABCBA"));
        System.out.println(isPalindromeRecursiveWay("ABADDABA"));
        System.out.println(isPalindromeRecursiveWay("ABAADABA"));

    }

    public static boolean isPalindrome(String input) {

        if(input == null || input.length() == 0) {
            return false;
        }
        if(input.length() == 1) {
            return true;
        }

        int length = input.length();
        int checkUntil = length/2;

        for(int i=0; i < checkUntil; i++){
            if(input.charAt(i) != input.charAt(length-(i+1)) ) {
                return false;
            }
        }
        return true;
    }

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
