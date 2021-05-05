import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'deleteProducts' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ids
     *  2. INTEGER m
     */

    public static int deleteProducts(List<Integer> ids, int m) {
        int[] arr = ids.stream().mapToInt(i -> i).toArray();
        int n = arr.length;
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();


        int arraySize = 0;
        for (int i = 0; i < n; i++) {

            if (m1.containsKey(arr[i]) == false) {
                m1.put(arr[i], 1);
                arraySize++;
            } else m1.put(arr[i], m1.get(arr[i]) + 1);
        }

        Map<Integer, Integer> sortedMap = m1.entrySet().stream()
                .sorted(
                        (Map.Entry.<Integer, Integer>comparingByValue())
                                .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        int processedCount = 0;
        for (Map.Entry<Integer, Integer> mp : sortedMap.entrySet()) {

            if (mp.getValue() <= m) {
                m -= mp.getValue();
                processedCount++;
            } else return arraySize - processedCount;
        }

        return arraySize - processedCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int idsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ids = IntStream.range(0, idsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.deleteProducts(ids, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
