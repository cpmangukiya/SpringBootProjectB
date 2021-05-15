package org.example.problems;

import java.util.Arrays;

public class CheckValidTree {

    public static void main(String[] args) {
        int[] binaryTree = {10};
        assertSame("TRUE", solution(binaryTree), " For " + Arrays.toString(binaryTree));

        binaryTree = new int[]{10, 11, 7};
        assertSame("TRUE", solution(binaryTree), " For " + Arrays.toString(binaryTree));
        
        binaryTree = new int[]{10, 7, 9};
        assertSame("FALSE", solution(binaryTree), " For " + Arrays.toString(binaryTree));
        
        binaryTree = new int[]{15, 30, 7, 33, 21, 11, 5};
        assertSame("TRUE", solution(binaryTree), " For " + Arrays.toString(binaryTree));
        
        binaryTree = new int[]{15, 30, 7, 31, 20, 4, 10};
        assertSame("FALSE", solution(binaryTree), " For " + Arrays.toString(binaryTree));

        binaryTree = new int[]{15, 30, 7, 33, 20, 10, 4, 35, 32, 21, 17, 12, 8, 5, 3};
        assertSame("TRUE", solution(binaryTree), " For " + Arrays.toString(binaryTree));

        binaryTree = new int[]{15, 30, 7, 33, 20, 4, 10, 35, 32, 17, 21, 6, 5, 8, 12};
        assertSame("FALSE", solution(binaryTree), " For " + Arrays.toString(binaryTree));
        
    }

    public static void assertSame(String a, String b,  String message){
        System.out.println(message);
        if(!a.equals(b)) {
            System.out.println("  Failure. Expected was "+a);
        } else {
            System.out.println("  Success. Expected as "+a);
        }
        System.out.println("----------------------------");
    }

    public static String solution(int[] binaryTree) {

        if(binaryTree == null || binaryTree.length == 0) return "FALSE";

        if(binaryTree.length == 1) return "TRUE";

        int levels = (int) Math.sqrt(binaryTree.length);
        System.out.println("Layers : "+levels);

        int parent = 0;

        for(int i=0 ; i < levels+1; i++) {
            int items = (int) Math.pow(2, i);

            for(int j=0 ; j < items; j++) {
                int currentIndex = items-1+j;
                if(currentIndex >= binaryTree.length) {
                    break;
                }
                int currentIndexValue = binaryTree[currentIndex];

                if (i == 1) {
                    parent = binaryTree[0];
                    if(currentIndex%2 == 1 && !(currentIndexValue > parent)){
                        return "FALSE";
                    }
                    else if(currentIndex%2 == 0 && !(currentIndexValue < parent)){
                        return "FALSE";
                    }
                } else if (i > 0) {
                    int parentIndex = currentIndex % 2 == 0 ? (int)currentIndex/2-1 : (int)currentIndex/2;
                    parent = binaryTree[parentIndex];
                    int parentOfParentIndex = parentIndex % 2 == 0 ? (int)parentIndex/2-1 : (int)parentIndex/2;
                    int parentOfParent = binaryTree[parentOfParentIndex];
                    if (currentIndex % 4 == 3 && !(currentIndexValue > parent && currentIndexValue > parentOfParent)) {
                        return "FALSE";
                    } else if (currentIndex % 4 == 0 && !(currentIndexValue < parent && currentIndexValue > parentOfParent)) {
                        return "FALSE";
                    } else if (currentIndex % 4 == 1 && !(currentIndexValue > parent && currentIndexValue < parentOfParent)) {
                        return "FALSE";
                    } else if (currentIndex % 4 == 2 && !(currentIndexValue < parent && currentIndexValue < parentOfParent)) {
                        return "FALSE";
                    }
                }
            }
        }

        return "TRUE";
    }

}
