package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] seq1 = br.readLine().toCharArray();
        char[] seq2 = br.readLine().toCharArray();
        int[][] dp = new int[seq1.length+1][seq2.length+1];

        for (int i = 1; i <= seq1.length; i++) {
            for (int j = 1; j <= seq2.length; j++) {
                if(seq1[i-1] == seq2[j-1]) {
                    // 같은 값이라면 대각선 값 + 1
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    // 다른 값이라면 위쪽 값 또는 왼쪽 값 중 최대값
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[seq1.length][seq2.length]);

    }
}
