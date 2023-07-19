package org.example.problems;

import java.util.ArrayList;
import java.util.HashSet;

public class SomeProgram {
    public static void main(String[] args) {

    }
    static int longest(int a[], int n) {
        int ans = 0;
        int incr = 1;
        int decre = 1;
        ArrayList < Integer > b = new ArrayList < > ();
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                b.add(a[i]);
            }
        }
        for (int i = 1; i < b.size(); i++) {
            if (i > 0 && b.get(i) > b.get(i - 1)) {
                decre = 1;
                if (b.get(i) == b.get(i - 1) + 1) {
                    incr++;
                } else incr = 1;
            } else if (i > 0 && b.get(i) < b.get(i - 1)) {
                incr = 1;
                if (b.get(i) == b.get(i + 1) + 1) {
                    decre++;
                } else decre = 1;

            }

        }
        return ans;
    }
    static int longest2(int ar[], int n) {
        HashSet < Integer > s = new HashSet < > ();
        for (int i = 0; i < n; i++) {
            s.add(ar[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.contains(ar[i])) {

                int j = ar[i];
                while (s.contains(j)) j++;
                ans = Math.max(ans, j - ar[i]);
            }
        }
        return ans;
    }
}