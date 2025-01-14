package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int mod = 1_000_000_000;
        int[][] dp = new int[K+1][N+1];

        for (int i = 1; i <= K; i++) {
            if(i==1) {
                Arrays.fill(dp[i], 1); // 한 개의 정수로 만들 수 있는 경우는 자기 자신 한가지
            } else {
                for (int j = 0; j <= N; j++) {
                    if(j==0) { // 0을 만들 수 있는 방법은 정수 0 한가지
                        dp[i][j] = 1;
                    } else {
                        // i-1개의 정수로 j를 만드는 경우에 정수 0 추가한 경우
                        // i개의 정수로 j-1을 만드는 경우에 정수 1 추가한 경우
                        dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
                    }
                }
            }
        }

        System.out.println(dp[K][N]);

    }
}
