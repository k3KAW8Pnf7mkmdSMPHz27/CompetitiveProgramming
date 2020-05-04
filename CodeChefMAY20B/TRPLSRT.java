/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ConcurrentSkipListMap;

/* Name of the class has to be "Main" only if the class is public. */
class TRPLSRT {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = readInt(br);
        SortedMap<Integer, Integer> integers = new ConcurrentSkipListMap<>();
        for (; T > 0; T--) {
            int N = readInt(br);
            int K = readInt(br);
            integers.clear();
            for (int i = 0; i < N; i++) {
                integers.put(readInt(br), i);
            }

        }
    }

    private static int readInt(BufferedReader br) throws IOException {
        int value = 0;
        int current = br.read();
        while (current < '0' || current > '9') {
            current = br.read();
        }
        while (current >= '0' && current <= '9') {
            value *= 10;
            value += current - '0';
            current = br.read();
        }
        return value;
    }
}
