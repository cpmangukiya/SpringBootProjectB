package org.example.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAPairWithGivenSum {

    // Driver method to exam the above function
    public static void main(String[] args)
    {
        System.out.println( "Count of pairs is " + getPairsCountHashing(6, new int[] { 1, 5, 7, -1, 5 }));

        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;

        findPairHashing(A, sum);

        findPair(A, sum);
    }

    // Function to find a pair in an array with a given sum using sorting
    public static void findPair(int[] A, int sum)
    {
        // sort the array in ascending order
        Arrays.sort(A);

        // maintain two indices pointing to endpoints of the array
        int low = 0;
        int high = A.length - 1;

        // reduce the search space `A[low…high]` at each iteration of the loop

        // loop till the search space is exhausted
        while (low < high)
        {
            // sum found
            if (A[low] + A[high] == sum)
            {
                System.out.println("Pair found (" + A[low] + ", " + A[high] + ")");
                return;
            }

            // increment `low` index if the total is less than the desired sum;
            // decrement `high` index if the total is more than the desired sum
            if (A[low] + A[high] < sum) {
                low++;
            }
            else {
                high--;
            }
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }

    // Function to find a pair in an array with a given sum using hashing
    public static void findPairHashing(int[] A, int sum)
    {
        // create an empty HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // do for each element
        for (int i = 0; i < A.length; i++)
        {
            // check if pair `(A[i], sum-A[i])` exists

            // if the difference is seen before, print the pair
            if (map.containsKey(sum - A[i]))
            {
                System.out.printf("Pair found (%d, %d)", A[map.get(sum - A[i])], A[i]);
                return;
            }

            // store index of the current element in the map
            map.put(A[i], i);
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    static int getPairsCountHashing(int sum, int arr[])
    {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;
    }


}
