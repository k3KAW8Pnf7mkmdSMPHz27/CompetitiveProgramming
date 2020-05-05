/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CHANDF {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = readLong(br);
        for (; T > 0; T--) {
            long X = readLong(br);
            long Y = readLong(br);
            long L = readLong(br);
            long R = readLong(br);
            //(X and Z) * (Y and Z)
            long Z = L;
            long max_value = 0;
            for (long i = L; i <= R; i++) {
                long currentValue = (X&Z)*(Y&Z);
                if (currentValue > max_value) {
                    Z = i;
                    max_value = currentValue;
                }
            }
            System.out.println(Z);
        }
    }

    private static long readLong(BufferedReader br) throws IOException {
        long value = 0;
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
