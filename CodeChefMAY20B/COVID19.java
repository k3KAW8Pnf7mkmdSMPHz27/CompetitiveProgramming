/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class COVID19 {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = readInt(br);
        for (; T > 0; T--) {
            final int N = readInt(br);
            int[] positions = new int[N];
            for (int i = 0; i < N; i++) {
                positions[i] = readInt(br);
            }
            Arrays.sort(positions);

            int max = 1;
            int min = Integer.MAX_VALUE;
            for (int person = 0; person < N; person++) {
                int total_infected = 1;
                //Check left
                int pos = positions[person];
                for (int i = person-1; i >= 0; i--) {
                    if(pos - positions[i] <= 2) {
                        total_infected++;
                    } else {
                        break;
                    }
                    pos = positions[i];
                }
                //Check right
                pos = positions[person];
                for (int i = person+1; i < N; i++) {
                    if(positions[i] - pos <= 2) {
                        total_infected++;
                    } else {
                        break;
                    }
                    pos = positions[i];
                }
                max = Math.max(max, total_infected);
                min = Math.min(min, total_infected);
            }
            System.out.println(min + " " + max);
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
