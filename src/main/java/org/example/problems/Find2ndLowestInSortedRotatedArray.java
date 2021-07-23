package org.example.problems;

import org.junit.jupiter.api.Assertions;

public class Find2ndLowestInSortedRotatedArray {

    public static void main(String[] args) {

        Integer[] integers = {6,7,9,11,15,16,19,2,4,5};
        Assertions.assertEquals(2, findLowest(integers, 0, integers.length-1));
        Assertions.assertEquals(4, find2ndLowest(integers, 0, integers.length-1));

        integers = new Integer[]{6, 7, 9, 11, 15, 16, 19, 2};
        Assertions.assertEquals(6, find2ndLowest(integers, 0, integers.length-1));
    }

    public static Integer findLowest(Integer[] array, int low, int high) {
        while (low < high) {

            int mid = (low+high)/2;

            if(array[mid].equals(array[high])) {
                high--;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return array[high];
    }

    public static Integer find2ndLowest(Integer[] array, int low, int high) {
        while (low < high) {
            int mid = (low+high)/2;

            if(array[mid].equals(array[high])) {
                high--;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return array.length == high+1 ? array[0] : array[high+1];
    }
}
