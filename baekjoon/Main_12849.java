package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12849 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int D = Integer.parseInt(br.readLine());
        long[][] dp = new long[D+1][8];
        long mod = 1_000_000_007;
        dp[0][0] = 1;
        // 0: 정보과학관 - 1, 2
        // 1: 전산관 - 0, 2, 3
        // 2: 미래관 - 0, 1, 3, 4
        // 3: 신양관 - 1, 2, 4, 5
        // 4: 한경직기념관 - 2, 3, 5, 6
        // 5: 진리관 - 3, 4, 7
        // 6: 형남공학관 - 4, 7
        // 7: 학생회관 - 5, 6

        for (int i = 0; i < D; i++) {
            dp[i+1][0] = (dp[i][1]+dp[i][2]) % mod;
            dp[i+1][1] = (dp[i][0] + dp[i][2] + dp[i][3]) % mod;
            dp[i+1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][4]) % mod;
            dp[i+1][3] = (dp[i][1] + dp[i][2] + dp[i][4] + dp[i][5]) % mod;
            dp[i+1][4] = (dp[i][2] + dp[i][3] + dp[i][5] + dp[i][6]) % mod;
            dp[i+1][5] = (dp[i][3] + dp[i][4] + dp[i][7]) % mod;
            dp[i+1][6] = (dp[i][4] + dp[i][7]) % mod;
            dp[i+1][7] = (dp[i][5] + dp[i][6]) % mod;
        }

        System.out.println(dp[D][0]);
    }
}
