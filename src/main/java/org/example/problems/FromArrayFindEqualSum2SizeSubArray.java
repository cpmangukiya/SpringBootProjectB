package org.example.problems;

import java.util.HashMap;
import java.util.Map;


public class FromArrayFindEqualSum2SizeSubArray {

    public static void main(String[] args) {
        findTwoSubArrayOfSameSize(new Integer[]{1, 2, 3, 4, 5});
    }


    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        //This function is not needed
        boolean checkIfSamePair(int a, int b) {
            return this.a == a && this.b == b || this.a == b && this.b == a;
        }
    }

    public static void findTwoSubArrayOfSameSize(Integer[] array) {
        Map<Integer, Pair> map = new HashMap<>();
        for(int i=0;i< array.length;i++) {
            for(int j=i+1;j<array.length;j++){
                Integer tempSum = array[i]+array[j];
                if(map.containsKey(tempSum) && !map.get(tempSum).checkIfSamePair(i,j)){
                    System.out.println("{"+array[map.get(tempSum).a]+","+array[map.get(tempSum).b]+"} {"+array[i]+","+array[j]+"}");
                    return;
                } else {
                    map.put(tempSum, new Pair(i, j));
                }
            }
        }
    }
}
