package org.example.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BasicPrograms {

    public static void main(String[] args) {
        findUniqueItems(Arrays.asList(1,2,1,5,7,3,9,3,5,6,3,2,2,4,5,2,8));
    }

    private static void findUniqueItems(List<Integer> asList) {
        asList.stream().reduce(new HashSet<>(),
                (set, value) -> {set.add(value); return set;},
                BasicPrograms::hashSetMerger);
    }

    private static HashSet<Integer> hashSetMerger(HashSet<Integer> a, HashSet<Integer> b){
        return null;
    }
}
