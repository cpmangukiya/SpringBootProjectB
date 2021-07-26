package org.example.problems;

public class FibonacciSeries {
    public static void main(String[] args) {
        // 0 1 1 2 3 5 8 13 21 34 55
        // Total of prev two is next
        printFibonacciNumbers(12);
        System.out.println();
        recursivePrintAll(12); //Not working

        System.out.println();
        System.out.println(printNthFibonacciNumberRecursive(7));
    }

    private static void printFibonacciNumbers(int a) {
        if(a < 0) return;
        int nextOne = 0;
        System.out.print(nextOne+" ");
        if(a == 1) return;
        int nextTwo = 1;
        System.out.print(nextTwo+" ");
        if(a == 2) return;

        for(int i=0; i < a-3;a--) {
            System.out.print((nextOne+nextTwo)+" ");
            int temp = nextTwo;
            nextTwo = nextOne + nextTwo;
            nextOne = temp;
        }
    }

    private static int printNthFibonacciNumberRecursive(int i) {
        if(i == 0)
            return 0;
        return recursive(i-1);
    }

    private static int recursive(int i) {
        if(i <= 1) return i;

        return recursive(i-1)+recursive(i-2);
    }

    private static void recursivePrintAll(int i) {
        if(i <= 1) System.out.print(i+" ");

        int number = recursive(i-1)+recursive(i-2);
        System.out.print(number+" ");
    }
}
