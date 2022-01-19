package Puzzles.Cafeteria;

import java.util.Arrays;

/**
 * A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. Social distancing guidelines require that every diner be seated such that K seats to their left and K seats to their right
 * (or all the remaining seats to that side if there are fewer than K) remain empty.
 * There are currently M diners seated at the table, the ith of whom is in seat S[i]
 * No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 * Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners,
 * assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
 * Please take care to write a solution which runs within the time limit(5 seconds).
 *
 * Constraints
 *      1 <= N <= 10^15
 *      1 <= K <= N
 *      1 <= M <= 500,00
 *      1 <= S[i] <= N
 *
 * Sample Cases
 *
 *      N = 10
 *      K = 1
 *      M = 2
 *      S = [2,6]
 *      return = 3
 *
 *      N = 15
 *      K = 2
 *      M = 3
 *      S = [11, 6, 14]
 *      return = 1
 *
 * Explanation
 *      In the first case, the cafeteria table has N = 10 seats, with two diners currently at seats 2 and 6 respectively.
 *      The table initially looks as follows, with brackets covering the K = 1 seat to the left and right of each existing diner that may not be taken.
 *      1 2 3 4 5 6 7 8 9 10
 *      [   ]   [   ]
 *
 *      Three additional diners may sit at seats 4, 8, and 10 without violating the social distancing guidelines.
 *      In the second case, only 1 additional diner is able to join the table, by sitting in any of the first 3 seats.
 */
public class Cafeteria {
    /*
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        return 0L;
    }
    */
    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        // Write your code here
        Arrays.sort(S);
        long result = 0;
        long start = 1, end;

        for(int i=0; i<M; ++i) {
            end = S[i] - K - 1;
            result += getCount(start, end, K);
            start = S[i] + K + 1;
        }
        result += getCount(start, N, K);
        return result;
    }

    private static long getCount(long start, long end, long K) {
        long count =  (end - start) / (K + 1) + 1;
        if (start > end) return 0;
        return count;
    }

    public static void main(String[] args){
        long N = 10;
        long K = 1;
        int M = 2;
        long[] S = {2,6};
        long answer = 0L;
        answer = getMaxAdditionalDinersCount(N, K, M, S);
        System.out.println(answer);
    }

}
