package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        final int MOD = 9901;

        dp[1][0] = 1; // 사자를 배치하지 않는 경우
        dp[1][1] = 1; // 사자를 왼쪽에 배치하는 경우
        dp[1][2] = 1; // 사자를 오른쪽에 배치하는 경우

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        System.out.println((dp[N][0]+dp[N][1]+dp[N][2]) % MOD);
    }
}
