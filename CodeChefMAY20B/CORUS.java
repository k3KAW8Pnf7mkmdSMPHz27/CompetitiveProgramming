/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CORUS {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = readInt(br);
        for (; T > 0; T--) {
            int N = readInt(br);
            int Q = readInt(br);
            //br.read(); //Remove new line
            char[] S = br.readLine().toCharArray();
            // S is of length N
            // Each ith person has disease S_i
            int[] carriers = new int[26]; //Given by problem, max 26
            //Calculate how many carriers there are of each disease
            for (int i = 0; i < N; i++) {
                final int disease = S[i]-'a';
                carriers[disease]++;
            }

            for (int i = 0; i < Q; i++) {
                int C = readInt(br);
                long ans = 0;
                for (int j = 0; j < 26; j++) {
                    ans += Math.max(carriers[j] - C, 0);
                }
                System.out.println(ans);
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
