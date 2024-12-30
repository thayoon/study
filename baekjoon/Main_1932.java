package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            if(i==0) {
                dp[0][0] = Integer.parseInt(br.readLine());
//                triangle[0][0] = dp[0][0];
                continue;
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j==i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < dp[n-1][i]) max = dp[n-1][i];
        }

        System.out.println(max);
    }
}
