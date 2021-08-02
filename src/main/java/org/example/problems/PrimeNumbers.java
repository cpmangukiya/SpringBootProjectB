package org.example.problems;

import java.util.stream.IntStream;

public class PrimeNumbers {

    public static void main(String[] args) {
        // Number > 2, Divisible by 1 and itself only
        // 2 only even prime
        // 2,3 only consecutive primes
        // All other can be represented as 6n+1 or 6n-1
        // Other evens are non-prime

        System.out.println(isPrimeRecursive(22));
        System.out.println(isPrimeRecursive(1));
        System.out.println(isPrimeRecursive(79));
        System.out.println();
        System.out.println(isPrimeSquareRoot(22));
        System.out.println(isPrimeSquareRoot(1));
        System.out.println(isPrimeSquareRoot(79));
        System.out.println();
        System.out.println(isPrimeSquareRoot(7332));
        System.out.println(isPrimeSquareRoot(7333));
        System.out.println(isPrimeSquareRoot(7335));
        System.out.println(isPrimeSquareRoot(7337));
        System.out.println(isPrimeSquareRoot(7339));

        IntStream.range(0,100000000).parallel().peek(PrimeNumbers::isPrimeSquareRoot).count();

    }


    static int i=5;
    private static boolean isPrimeRecursive(int n) {
        if(n <= 1) {
            return false;
        }
        if(i == n) {
            return true;
        }
        if(n % 2 == 0) {
            return false;
        }
        if(n % i == 0) {
            return false;
        }
        if(i > Math.sqrt(n)) {
            return true;
        }
        i = i+2;
        return isPrimeRecursive(n);
    }


    private static boolean isPrimeSquareRoot(int n) {
        //Instead of checking till n, we can check till √n because a larger factor of n must be a multiple of smaller factor that has been already checked.
        //The algorithm can be improved further by observing that all primes are of the form 6k ± 1, with the exception of 2 and 3. This is because all integers can be expressed as (6k + i) for some integer k and for i = -1, 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), (6k + 4); and 3 divides (6k + 3). So a more efficient method is to sample if n is divisible by 2 or 3, then to check through all the numbers of form 6k ± 1.
        if(n <= 1) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        if(n % 2 == 0) {
            return false;
        }
        if(n % 3 == 0) {
            return false;
        }

        // This is unnecessary overhead, it is never true
        double valueOne = ((double)n+1)/6;
        double valueTwo = ((double)n-1)/6;
        if(valueOne % 1 != 0 && valueTwo % 1 != 0) {
            System.out.println("For:"+n);
            return false;
        }
        // This is unnecessary overhead, it is never true

        for(int i=5;i <= Math.sqrt(n);i+=2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
