package org.example.problems;

public class ZigZagStringConversion {

    public static void main(String[] args) {

        String sampleOne = "CONVERTTHISSTRING";
        // with 4 rows,
        // C     T     T
        // O   R T   S R
        // N E   H S   I G
        // V     I     N
        // 0 row 0(6-6),6(12-6),12... repeat
        // 1 row 1(6-5),7[7-2](12-5)... repeat
        // 2 row 2(6-4),8[8-4](12-4)... repeat
        // 3 row 3(6-3),9(12-3)... repeat
        // total size will be upper bound
        System.out.println(convert(sampleOne, 4));

        // with 3 rows,
        // C   E   H   T   G
        // O V R T I S R N
        // N   T   S   I
        // After 4 repeat
        // 0 - row 0(4-4), 4(8-4), 8(12-4), ...
        // 1 - row 1(4-3), 5(8-3), 9, ...
        // 2 - row 2(4-2), 6(4-2), 10 ...
        System.out.println(convert(sampleOne, 3));
    }

    static String convert(String input, int rowCount) {
        String output = "";

        int range = rowCount*2-2;

        for(int i = 0; i < rowCount; i++) {
            int next = i;
            while(next < input.length()) {
                System.out.print(input.charAt(next));
                next = next + range;
                if(i > 0 && i < rowCount - 1 && (next-(i*2)) < input.length()) {
                    System.out.print(input.charAt(next-(i*2)));
                }
            }
        }

        return output;
    }
}
