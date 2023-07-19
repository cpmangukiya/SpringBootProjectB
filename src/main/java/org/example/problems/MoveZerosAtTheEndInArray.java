package org.example.problems;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.h2.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZerosAtTheEndInArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0,14,12,0,0,1,1,1,2,5};
        moveZerosAtTheEndOfArray(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void moveZerosAtTheEndOfArray(int[] arr) {

        int zerothIndexForInterChange = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 0 && zerothIndexForInterChange == -1) {
                zerothIndexForInterChange = i;
            } else if(arr[i] != 0 && zerothIndexForInterChange != -1) {
                arr[zerothIndexForInterChange] = arr[i];
                arr[i] = 0;
                zerothIndexForInterChange++;
            }
        }
    }

}
