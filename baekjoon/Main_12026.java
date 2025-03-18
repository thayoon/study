package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] boj = br.readLine().toCharArray();
        int[] dp = new int[N];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if(dp[i] == 987654321) continue;

            char next = boj[i] == 'B' ? 'O' : boj[i] == 'O' ? 'J' : 'B';

            for (int j = i+1; j < N; j++) {
                if(boj[j] == next) {
                    int e = (j-i)*(j-i);
                    dp[j] = Math.min(dp[j], dp[i]+e);
                }
            }
        }

        System.out.println(dp[N-1] == 987654321 ? -1 : dp[N-1]);
    }
}
