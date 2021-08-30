/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class A1 {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = readInt(br);
        br.read(); // Discard newline
        int caseNumber = 1;
        for (; T > 0; T--) {
            var ALL_LETTERS = new int[26];
            String S = br.readLine();
            System.out.println(S);

            // Skip autoboxing
            for (int i = 0; i < S.length(); i++) {
                // Discard new line etc.
                char c = S.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    ALL_LETTERS[c-'A']++;
                }
            }

            int maxCharsConsonants = 0;
            int maxCharsVowels = 0;
            int numberOfConsonants = 0;
            int numberOfVowels = 0;
            for (int i = 0; i < ALL_LETTERS.length; i++) {
                if (isVowel((char) (i+'A'))) {
                    maxCharsVowels = Math.max(maxCharsVowels, ALL_LETTERS[i]);
                    numberOfVowels += ALL_LETTERS[i];
                } else {
                    maxCharsConsonants = Math.max(maxCharsConsonants, ALL_LETTERS[i]);
                    numberOfConsonants += ALL_LETTERS[i];
                }
            }

            // Calculate how many converts if all -> vowels
            var numberOfVowelsToConvert = numberOfVowels - maxCharsVowels;
            var numberOfConsonantsToConvert = numberOfConsonants - maxCharsConsonants;

            var ifVowel = numberOfConsonants + numberOfVowelsToConvert * 2;
            var ifConsonants = numberOfVowels + numberOfConsonantsToConvert * 2;

            pw.println("Case #" + caseNumber + ": " + Math.min(ifConsonants, ifVowel));
            caseNumber++;
        }
        pw.flush();
        pw.close();
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

    @SuppressWarnings("DuplicatedCode")
    private static int[] createIntArray(final int N, BufferedReader br) throws IOException {
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = readInt(br);
        }
        return A;
    }

    @SuppressWarnings("DuplicatedCode")
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
