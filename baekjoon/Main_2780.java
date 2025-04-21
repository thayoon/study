package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[1001][10];
        Arrays.fill(dp[1], 1);
        int mod = 1234567;
        for (int i = 2; i <= 1000; i++) {
            dp[i][0] = dp[i-1][7]%mod;
            dp[i][1] = (dp[i-1][2]+dp[i-1][4])%mod;
            dp[i][2] = (dp[i-1][1]+dp[i-1][3]+dp[i-1][5])%mod;
            dp[i][3] = (dp[i-1][2]+dp[i-1][6])%mod;
            dp[i][4] = (dp[i-1][1]+dp[i-1][5]+dp[i-1][7])%mod;
            dp[i][5] = (dp[i-1][2]+dp[i-1][6]+dp[i-1][8]+dp[i-1][4])%mod;
            dp[i][6] = (dp[i-1][3]+dp[i-1][5]+dp[i-1][9])%mod;
            dp[i][7] = (dp[i-1][4]+dp[i-1][8]+dp[i-1][0])%mod;
            dp[i][8] = (dp[i-1][5]+dp[i-1][9]+dp[i-1][7])%mod;
            dp[i][9] = (dp[i-1][6]+dp[i-1][8])%mod;
        }

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int now : dp[N]) {
                cnt = (cnt+now)%mod;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
