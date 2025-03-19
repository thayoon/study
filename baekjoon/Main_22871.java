package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_22871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // Ai
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N]; // 각 돌에 도착할 때 필요한 최대 힘의 최솟값 저장
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0; // 출발점

        for (int i = 1; i < N; i++) {
            // i번 돌에 도달하기 위한 이전 돌에서 건너오는 방법
            for (int j = 0; j < i; j++) {
                // 이전까지 사용한 최대 힘과 이번 점프의 힘 중 큰 값
                long k = Math.max((long) (i-j)*(1+Math.abs(arr[i] - arr[j])), dp[j]);
                dp[i] = Math.min(dp[i], k); // 가능한 j 중에서 최소한의 힘으로 도착하는 방법 선택
            }
        }
        System.out.println(dp[N-1]);

    }
}
