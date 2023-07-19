package org.example.problems;

public class FindLCMorLCD {

    public static void main(String[] args) {
        // Multiples of 4: 4, 8, 12, 16, 20, 24, 28
        // Multiples of 10: 10, 20, 30, 40
        // Here, the number 20 is the first common multiple of both 4 and 10.
        // So, the Lowest Common Multiple ( LCM ) and Least Common Divisor ( LCD) of 4, 10 is 20.
        System.out.println(findLCMBruteForce(10, 15));

        // Efficient way :    LCM(a, b) = (a x b) / GCD(a, b)
        int a = 15, b = 20;
        System.out.println("LCM of " + a +
                " and " + b +
                " is " + lcm(a, b));

        a = 5; b = 10;
        System.out.println("LCM of " + a +
                " and " + b +
                " is " + lcm(a, b));
    }

    private static int findLCMBruteForce(int a, int b) {

        int i = 1;
        int j = 1;
        while(i < 10000 && j < 10000) {
            if (a * i == b * j) {
                return a * i;
            } else if(a * i < b * j) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a * b / gcd(a, b));
    }

    // Recursive method to return gcd of a and b
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }



}
