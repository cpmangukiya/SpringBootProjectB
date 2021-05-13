package org.example.problems;

public class FindGCF {

    public static void main(String[] args) {
        // Factors of 32 = 1, 2, 4, 8, 16 and 32.
        // Factors of 80 =1,2,4,5,8,10,16, 20 and 80.
        // Therefore, common factor of 32 and 80= 1, 2, 4,8 and 16.
        // Greatest common factor (G.C.F) of 32 and 80 = 16.

        // A simple solution is to find all prime factors of both numbers, then find intersection of all factors present
        // in both numbers. Finally return product of elements in the intersection.
        // An efficient solution is to use Euclidean algorithm which is the main algorithm used for this purpose.
        // The idea is, GCD of two numbers doesn’t change if smaller number is subtracted from a bigger number.

        int a = 98, b = 56;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));

        System.out.println("GCD of " + 98 +" and " + 57 + " is " + gcd(98, 57));

        System.out.println("GCD of " + 0 +" and " + 57 + " is " + gcd(0, 57));

        System.out.println("GCD2 of " + a +" and " + b + " is " + gcd2(a, b));

        System.out.println("GCD2 of " + 98 +" and " + 57 + " is " + gcd2(98, 57));

        System.out.println("GCD2 of " + 0 +" and " + 57 + " is " + gcd2(0, 57));

    }



    static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }

    // Recursive method to return gcd of a and b
    static int gcd2(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd2(b % a, a);
    }

}
