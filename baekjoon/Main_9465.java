package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100,000

            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                    if(k==0) dp[j][k] = sticker[j][k];
                }
            }

            if(n==1) {
                sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
            } else {
                dp[0][1] = dp[1][0] + sticker[0][1];
                dp[1][1] = dp[0][0] + sticker[1][1];

                for (int j = 2; j < n; j++) {
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];
                }

                sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
            }
        }
        System.out.println(sb);
    }
}
