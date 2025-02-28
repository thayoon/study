package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 동전 가지 수
            int[] coins = new int[N]; // 동전
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine()); // 목표 금액
            int[] dp = new int[M+1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = coins[i]; j <= M; j++) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}
