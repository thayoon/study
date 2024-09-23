package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());   // r
            rgb[i][1] = Integer.parseInt(st.nextToken());   // g
            rgb[i][2] = Integer.parseInt(st.nextToken());   // b
        }

        int[][] dp = new int[N][3];
        dp[0][0] = rgb[0][0];   // r
        dp[0][1] = rgb[0][1];   // g
        dp[0][2] = rgb[0][2];   // b

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];    // r
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];    // g
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];    // b
        }

        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}
