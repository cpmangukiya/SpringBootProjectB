package org.example.problems;

public class PrintMatrixInSpiralForm {

    public static void main(String[] args) {
        // Print matrix in spiral form e.g. {{1,2,3},{4,5,6},{7,8,9}} Output . 1,2,3,6,9,8,7,4,5

        int[][] integerMatrix1 = {  {1,2,3},
                                    {4,5,6},
                                    {7,8,9}};

        printInSpiralForm(integerMatrix1);
        System.out.println();


        int[][] integerMatrix11 = {  {1,2,3,44},
                                     {4,5,6,66},
                                     {7,8,9,77},
                                     {10,11,12,88}};

        printInSpiralForm(integerMatrix11);
        System.out.println();


        int[][] integerMatrix2 = {   { 1, 2, 3, 4, 5, 6 },
                                     { 7, 8, 9, 10, 11, 12 },
                                     { 13, 14, 15, 16, 17, 18 }   };

        printInSpiralForm(integerMatrix2); //result 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
        System.out.println();


        int[][] integerMatrix22 = {   { 1, 2, 3, 4 },
                                      { 7, 8, 9, 10 },
                                      { 13, 14, 15, 16 },
                                      { 17, 18, 19, 20 },
                                      { 21, 22, 23, 24 }};

        printInSpiralForm(integerMatrix22);

    }

    private static void printInSpiralForm(int[][] integerMatrix) {

            int top = 0;
            int right = integerMatrix[0].length; // Initial 2
            int bottom = integerMatrix.length; // Initial 2
            int left = 0;

            while (top < bottom && right > left) {

                    for (int i = left; i < right; ++i) {
                        System.out.print(integerMatrix[top][i] + " ");
                    }
                    top++;

                    for (int i = top; i < bottom; ++i) {
                        System.out.print(integerMatrix[i][right-1] + " ");
                    }
                    right--;

                    if(bottom > top) {
                        for (int i = right-1; i >= left; --i) {
                            System.out.print(integerMatrix[bottom-1][i] + " ");
                        }
                        bottom--;
                    }

                    if(right > left) {
                        for (int i = bottom-1; i >= top; --i) {
                            System.out.print(integerMatrix[i][left] + " ");
                        }
                        left++;
                    }

            }

    }


}
