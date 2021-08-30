/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class A2 {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // They have done something wrong with ' \n', they are failing consistency check
        // int T = readInt(br);
        // br.read(); // Discard newline
        int T = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        for (; T > 0; T--) {
            String unNormalizedInput = br.readLine();
            int[] S = new int[unNormalizedInput.length()];
            for (int i = 0; i < S.length; i++) {
                S[i] = unNormalizedInput.charAt(i) - 'A';
            }

            // final int K = readInt(br);
            // br.read(); // Discard newline
            final int K = Integer.parseInt(br.readLine());
            int[][] mapping = new int[K][2];
            for (int i = 0; i < K; i++) {
                String input = br.readLine();
                mapping[i][0] = input.charAt(0) - 'A';
                mapping[i][1] = input.charAt(1) - 'A';
            }

            // Create DP
            final int DP_SIZE = 26;
            int[][] conversionCost = new int[DP_SIZE][DP_SIZE];
            for (int i = 0; i < DP_SIZE; i++) {
                Arrays.fill(conversionCost[i], -1);
            }

            // Identity
            for (int i = 0; i < DP_SIZE; i++) {
                conversionCost[i][i] = 0;
            }

            // Initialize with K
            for (int i = 0; i < K; i++) {
                final int from = mapping[i][0];
                final int to = mapping[i][1];
                final int cost = conversionCost[from][to];
                conversionCost[from][to] = cost < 0 ? 1 : cost;
            }

            // Fill with remaining values
            for (int currentNode = 0; currentNode < DP_SIZE; currentNode++) {
                var helper = new LinkedList<Integer>();
                final int[] currentCosts = conversionCost[currentNode];

                // Seed queue
                for (int toNode = 0; toNode < DP_SIZE; toNode++) {
                    // If we can go to the node and it hasn't or won't be visited
                    if (currentCosts[toNode] > 0) { // e.g., can we visit them at a cost
                        helper.add(toNode);
                    }
                }

                // Find all unexplored connections
                while (!helper.isEmpty()) {
                    int fromNode = helper.poll();
                    // The cost of reaching the next node
                    for (int toNode = 0; toNode < DP_SIZE; toNode++) {
                        // int toNextNode = conversionCost[fromNode][i];
                        // Can we visit the node and it is not itself?
                        if (conversionCost[fromNode][toNode] > 0) {
                            // Cost to this node
                            int costToGetHere = currentCosts[fromNode];
                            int costToGoNext = conversionCost[fromNode][toNode];
                            int cost = costToGetHere + costToGoNext;
                            // If we haven't calculated a cost for this path or if the cost is higher
                            if (currentCosts[toNode] < 0) {
                                currentCosts[toNode] = cost;
                                helper.add(toNode);
                            } else if (currentCosts[toNode] > cost) {
                                currentCosts[toNode] = cost;
                            }
                        }
                    }
                }
            }

            // Find costs for all conversions
            long answer = Long.MAX_VALUE;
            for (int goalCharacter = 0; goalCharacter < DP_SIZE; goalCharacter++) {
                long stringConversionCost = 0;
                for (int charValue : S) {
                    int costOfConversion = conversionCost[charValue][goalCharacter];
                    if (costOfConversion < 0) { // Conversion can't be done
                        stringConversionCost = -1;
                        break;
                    } else {
                        stringConversionCost += costOfConversion;
                    }
                }
                answer = stringConversionCost >= 0 ?
                        Math.min(answer, stringConversionCost) :
                        answer;
            }

            answer = answer == Long.MAX_VALUE ? -1 : answer;

            pw.println("Case #" + caseNumber + ": " + answer);
            caseNumber++;
        }
        pw.flush();
        pw.close();
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
