package org.example.problems;

import java.util.stream.IntStream;

public class MultiDimensionArrayPrinting {

    public static void main(String[] args) {

        int m = 3;
        int n = 4;
        int[][] arr = new int[m][n];
        int lengthOfRows = m;
        int lengthOfColumns = n;

        System.out.println("Length of array rows :"+lengthOfRows);
        System.out.println("Length of array columns :"+lengthOfColumns);

        int count = 1;
        StringBuffer stringBuffer;
        for(int i=0; i < lengthOfRows; i++){
            stringBuffer = new StringBuffer("");

            // Left to Right, Top to Bottom
            stringBuffer.append((i == 0 ? "#" : (i+1)) +" | ");

            for(int j=0; j < lengthOfColumns-1; j++) {
                stringBuffer.append(" "+count);
                count++;
            }
            if(i == 0) {
                System.out.print(stringBuffer);
                System.out.println();
                IntStream.range(0,stringBuffer.length()).forEach(s -> System.out.print("-"));
                System.out.println();
                System.out.print(stringBuffer.toString().replace("#","1"));
            } else {
                System.out.print(stringBuffer);
            }
            System.out.println();
        }


    }
}
