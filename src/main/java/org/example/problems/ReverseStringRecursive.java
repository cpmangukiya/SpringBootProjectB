package org.example.problems;

import java.util.stream.Collectors;

public class ReverseStringRecursive {
    public static void main(String[] args) {
        String value = "Hello";

        System.out.println(reverseAString(value));

        reverseAStringRecursive(value);

    }

    private static void reverseAStringRecursive(String shrunkValue) {
        if(shrunkValue.length() > 1) {
            reverseAStringRecursive(shrunkValue.substring(1));
        }
        System.out.print(shrunkValue.charAt(0));
        return;
    }

    private static String reverseAString(String value) {

        return value.chars().boxed()
                .sorted((o1, o2) -> -1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

    }


}
