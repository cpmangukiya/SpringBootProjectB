package org.example.typicalapp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoMain {

    public static void main(String[] args) {
        oddEven();
    }

    private static void oddEven() {
        Map<String, List<Integer>> stringListMap = Stream.of(new Integer[]{1, 2, 3, 4, 5}).collect(Collectors.groupingBy(integer -> integer % 2 == 0 ? "even": "odd"));
        System.out.println(stringListMap);
    }


}
