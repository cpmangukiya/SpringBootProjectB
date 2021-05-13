package org.example.problems;

import java.util.Arrays;

public class MoveZerosAtTheEndInArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0,14,12,0,0,1,1,1,2,5};
        //output {1,14,12,0,0}
        int eligibleZeroIndex = -1;
        for(int i=0;i < arr.length;i++) {
            int j = i+1;
            if(j < arr.length && eligibleZeroIndex < arr.length) {
                if(arr[i] == 0 && arr[j] != 0){
                    if(eligibleZeroIndex != -1){
                        int temp = arr[eligibleZeroIndex];
                        arr[eligibleZeroIndex] = arr[j];
                        arr[j] = temp;
                        if((eligibleZeroIndex+1) < arr.length && arr[(1+eligibleZeroIndex)] == 0) {
                            eligibleZeroIndex++;
                        } else {
                            eligibleZeroIndex = -1;
                        }
                    } else {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                } else if (arr[i] == 0 && arr[j] == 0) {
                    if(eligibleZeroIndex == -1) eligibleZeroIndex = i;
                }
            }
        }
        Arrays.stream(arr).peek(sa -> System.out.print(sa+" ")).count();
    }
}
