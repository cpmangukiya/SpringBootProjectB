package org.example.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'arrayChallenge' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts LONG_INTEGER_ARRAY arr as parameter.
     */

    public static List<Long> arrayChallenge(List<Long> arr) {
        // Write your code here
        List<Long> output = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {

            Long counter = 0L;

            for (int j = i-1; j >= 0; j--) {
                if(arr.get(i) > arr.get(j)) {
                    counter -= Math.abs(arr.get(i) - arr.get(j));
                } else {
                    counter += Math.abs(arr.get(i) - arr.get(j));
                }
            }

            output.add(counter);
        }
        return output;
    }

}

class AbsoluteDifferenceCounterToLeft {
    public static void main(String[] args) throws IOException {
        //3
        //2 3 5
        //0 -1 -5

        //5
        //2 5 3 6 4
        //0 -3 1 -8 0

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> arr = new ArrayList<>();

        String[] line = bufferedReader.readLine().trim().split(" ");

        for (int i = 0; i < arrCount; i++) {
            long arrItem = Long.parseLong(line[i]);
            arr.add(arrItem);
        }

        List<Long> result = Result.arrayChallenge(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)) + " ");

            if (i != result.size() - 1) {
                //bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
